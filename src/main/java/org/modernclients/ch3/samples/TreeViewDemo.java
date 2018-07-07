package org.modernclients.ch3.samples;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Mohammad Hossein Rimaz <mhrimaz@yahoo.com>
 */
public class TreeViewDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        TreeItem<String> rootItem = new TreeItem<>("JavaFX");
        rootItem.setExpanded(true);

        TreeItem<String> treeItem1 = new TreeItem<>("Layouts");
        TreeItem<String> treeItem11 = new TreeItem<>("Pane");
        TreeItem<String> treeItem12 = new TreeItem<>("AcnhorPane");
        treeItem1.getChildren().addAll(treeItem11,treeItem12);

        TreeItem<String> treeItem2 = new TreeItem<>("Controls");
        TreeItem<String> treeItem21 = new TreeItem<>("Button");
        TreeItem<String> treeItem22 = new TreeItem<>("CheckBox");
        treeItem2.getChildren().addAll(treeItem21,treeItem22);

        rootItem.getChildren().addAll(treeItem1,treeItem2);

        TreeView<String> tree = new TreeView<>(rootItem);
        tree.setOnMouseClicked(e->{
            ObservableList<TreeItem<String>> selectedItems = tree.getSelectionModel().getSelectedItems();
            console.accept("Selected item->"+selectedItems);
        });

        container.getChildren().add(tree);
    }
}
