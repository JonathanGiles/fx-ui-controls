package org.modernclients.ch3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoApp extends Application {

    private List<Sample> samples;

    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage primaryStage) {
        samples = getClasses("org.modernclients.ch3.samples")
                .filter(Sample.class::isAssignableFrom)
                .map(cls -> createSample((Class<? extends Sample>)cls))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .sorted()
                .collect(Collectors.toList());

        // simple UI to show demos - listview on left, demo area in center (with optional control panel area), console output at bottom
        StackPane demoPane = new StackPane();
        demoPane.getStyleClass().add("demo-pane");

        StackPane controlPane = new StackPane();
        controlPane.getStyleClass().addAll("control-pane");
        controlPane.setManaged(false);

        TextArea console = new TextArea();
        console.setPrefRowCount(10);
        console.getStyleClass().add("console");

        ListView<Sample> samplesList = new ListView<>();
        samplesList.getStyleClass().add("samples-list");
        samplesList.getItems().addAll(samples);
        samplesList.setCellFactory(listView -> new ListCell<Sample>() {
            @Override protected void updateItem(Sample item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText("");
                } else {
                    setText(item.getName());
                }
            }
        });
        samplesList.getSelectionModel().selectedItemProperty().addListener((o, oldSample, newSample) -> {
            // when selection changes, update the demo area
            demoPane.getChildren().clear();
            newSample.buildDemo(demoPane, str -> console.setText(str + "\r\n" + console.getText()));

            controlPane.getChildren().clear();
            newSample.buildControlPanel().ifPresent(controlPane.getChildren()::add);

            // show control pane?
            boolean showControlPane = !controlPane.getChildren().isEmpty();
            controlPane.setManaged(showControlPane);
            controlPane.setVisible(showControlPane);

            console.clear();
        });

        GridPane gridPane = new GridPane();
        gridPane.add(samplesList, 0, 0, 1, 2);
        gridPane.add(demoPane, 1, 0, 1, 1);
        gridPane.add(controlPane, 2, 0, 1, 1);
        gridPane.add(console, 1, 1, 2, 1);

        GridPane.setVgrow(demoPane, Priority.ALWAYS);
        GridPane.setHgrow(demoPane, Priority.ALWAYS);
        GridPane.setHgrow(console, Priority.ALWAYS);

        GridPane.setMargin(samplesList, new Insets(10));
        GridPane.setMargin(demoPane, new Insets(10, 10, 0, 0));
        GridPane.setMargin(controlPane, new Insets(10, 10, 0, 0));
        GridPane.setMargin(console, new Insets(10, 10, 10, 0));

        Scene scene = new Scene(gridPane, 1400, 900);
        scene.getStylesheets().add(DemoApp.class.getResource("ch3styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chapter 3 UI Controls Samples");
        primaryStage.show();
    }

    private Optional<Sample> createSample(Class<? extends Sample> cls) {
        try {
            return Optional.of(cls.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     */
    private static Stream<Class<?>> getClasses(final String packageName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');

        try {
            return Collections.list(classLoader.getResources(path)).stream()
                    .map(url -> new File(url.getFile()))
                    .flatMap(dir -> findClasses(dir, packageName));
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }
    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     */
    private static Stream<Class<?>> findClasses(File directory, String packageName) {
        if (!directory.exists()) {
            return Stream.empty();
        }

        return Stream.of(directory.listFiles()).flatMap(file -> {
            try {
                if (file.isDirectory()) {
                    return findClasses(file, packageName + "." + file.getName());
                } else if (file.getName().endsWith(".class")) {
                    return Stream.of(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return Stream.empty();
        });
    }
}
