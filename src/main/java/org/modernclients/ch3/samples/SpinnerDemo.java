package org.modernclients.ch3.samples;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class SpinnerDemo implements Sample {

    private Spinner spinner;

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        spinner = new Spinner();

        // debug output to console
        spinner.valueProperty().addListener((o, oldValue, newValue) ->
                System.out.println("value changed: '" + oldValue + "' -> '" + newValue + "'"));
        spinner.getEditor().textProperty().addListener((o, oldValue, newValue) ->
                System.out.println("text changed: '" + oldValue + "' -> '" + newValue + "'"));

        // add spinner to table
        container.getChildren().add(spinner);
    }

    @Override
    public Optional<Node> buildControlPanel() {
        // this lets us switch between the spinner value factories
        ComboBox<String> spinnerValueFactoryOptions =
                new ComboBox<>(FXCollections.observableArrayList("Integer", "Double", "List<String>"));
        spinnerValueFactoryOptions.getSelectionModel().selectedItemProperty().addListener((o, oldValue, newValue) -> {
            if (newValue == null) return;

            switch (newValue) {
                default:
                case "Integer": {
                    spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 10));
                    break;
                }

                case "List<String>": {
                    ObservableList<String> items = FXCollections.observableArrayList("Jonathan", "Julia", "Henry", "Pippa");
                    spinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(items));
                    break;
                }

                case "Double": {
                    spinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 1.0, 0.5, 0.05));
                    break;
                }
            }
        });
        spinnerValueFactoryOptions.getSelectionModel().select(0);

        ComboBox<String> spinnerStyleClassOptions =
                new ComboBox<>(FXCollections.observableArrayList(
                        "Default (Arrows on right (Vertical))",
                        "Arrows on right (Horizontal)",
                        "Arrows on left (Vertical)",
                        "Arrows on left (Horizontal)",
                        "Split (Vertical)",
                        "Split (Horizontal)"));
        spinnerStyleClassOptions.getSelectionModel().selectedItemProperty().addListener((o, oldValue, newValue) -> {
            spinner.getStyleClass().removeAll(
                    Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL,
                    Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL,
                    Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL,
                    Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL,
                    Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);

            switch (newValue) {
                default:
                case "Default (Arrows on right (Vertical))": break;

                case "Arrows on right (Horizontal)": {
                    spinner.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL);
                    break;
                }

                case "Arrows on left (Vertical)": {
                    spinner.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL);
                    break;
                }

                case "Arrows on left (Horizontal)": {
                    spinner.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL);
                    break;
                }

                case "Split (Vertical)": {
                    spinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
                    break;
                }

                case "Split (Horizontal)": {
                    spinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
                    break;
                }
            }
        });
        spinnerStyleClassOptions.getSelectionModel().select(0);

        final CheckBox wrapAroundCheckBox = new CheckBox();
        wrapAroundCheckBox.selectedProperty().addListener((o, oldValue, newValue) ->
                spinner.getValueFactory().setWrapAround(newValue));

        final CheckBox editableCheckBox = new CheckBox();
        spinner.editableProperty().bind(editableCheckBox.selectedProperty());

        final CheckBox rtlCheckBox = new CheckBox();
        rtlCheckBox.selectedProperty().addListener((o, oldValue, newValue) ->
                spinner.setNodeOrientation(newValue ? NodeOrientation.RIGHT_TO_LEFT : NodeOrientation.INHERIT));



        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        int row = 0;

        grid.add(new Label("Value Factory:"), 0, row);
        grid.add(spinnerValueFactoryOptions, 1, row++);

        grid.add(new Label("Style Class:"), 0, row);
        grid.add(spinnerStyleClassOptions, 1, row++);

        grid.add(new Label("Wrap around:"), 0, row);
        grid.add(wrapAroundCheckBox, 1, row++);

        grid.add(new Label("Editable:"), 0, row);
        grid.add(editableCheckBox, 1, row++);

        grid.add(new Label("Right-to-left:"), 0, row);
        grid.add(rtlCheckBox, 1, row++);

        return Optional.of(grid);
    }
}
