package org.modernclients.ch3.samples;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;
import org.modernclients.ch3.model.JavaFXNode;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Abhinay Agarwal <abhinay_agarwal@live.com>
 */
public class TreeTableViewDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {

        List<JavaFXNode> layoutList = Arrays.asList(
                new JavaFXNode("Pane", "Region"),
                new JavaFXNode("AnchorPane", "Pane"),
                new JavaFXNode("BorderPane", "Pane")
        );

        List<JavaFXNode> controlList = Arrays.asList(
                new JavaFXNode("Button", "ButtonBase"),
                new JavaFXNode("Label", "Labeled"),
                new JavaFXNode("ListView", "Control")
        );

        TreeItem<JavaFXNode> rootItem = new TreeItem<>(new JavaFXNode("JavaFX", ""));
        rootItem.setExpanded(true);

        TreeItem<JavaFXNode> layouts = new TreeItem<>(new JavaFXNode("Layouts", ""));
        layoutList.forEach(item -> layouts.getChildren().addAll(new TreeItem<>(item)));

        TreeItem<JavaFXNode> controls = new TreeItem<>(new JavaFXNode("Controls", ""));
        controlList.forEach(item -> controls.getChildren().addAll(new TreeItem<>(item)));

        rootItem.getChildren().addAll(layouts,controls);

        TreeTableColumn<JavaFXNode, String> nameColumn = new TreeTableColumn<>("Name");
        nameColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getValue().getName()));
        nameColumn.setPrefWidth(150);
        TreeTableColumn<JavaFXNode, String> parentColumn = new TreeTableColumn<>("Parent");
        parentColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getValue().getParent()));
        parentColumn.setPrefWidth(150);

        TreeTableView<JavaFXNode> tree = new TreeTableView<>(rootItem);
        tree.setOnMouseClicked(e -> {
            ObservableList<TreeItem<JavaFXNode>> selectedItems = tree.getSelectionModel().getSelectedItems();
            if (selectedItems.size() > 0) {
                console.accept("Selected item -> " + selectedItems.get(0).getValue().getName());
            }
        });
        tree.getColumns().addAll(nameColumn, parentColumn);

        container.getChildren().add(tree);
    }
}

