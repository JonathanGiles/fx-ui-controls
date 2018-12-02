package org.modernclients.ch3.samples;

import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Mohammad Hossein Rimaz <mhrimaz@yahoo.com>
 * @author Frank Delporte <frank@webtechie.be>
 */
public class TreeViewDemo implements Sample {
	private Consumer<String> console;

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
    	this.console = console;
    	
        TreeItem<String> rootItem = new TreeItem<>("JavaFX");
        rootItem.setExpanded(true);

        TreeItem<String> treeItem1 = new TreeItem<>("Layouts");
        TreeItem<String> treeItem11 = new TreeItem<>("Pane");
        TreeItem<String> treeItem12 = new TreeItem<>("AnchorPane");
        treeItem1.getChildren().addAll(treeItem11,treeItem12);

        TreeItem<String> treeItem2 = new TreeItem<>("Controls");
        TreeItem<String> treeItem21 = new TreeItem<>("Button");
        TreeItem<String> treeItem22 = new TreeItem<>("CheckBox");
        treeItem2.getChildren().addAll(treeItem21,treeItem22);

        rootItem.getChildren().addAll(treeItem1,treeItem2);

        TreeView<String> tree = new TreeView<>(rootItem);
        tree.getSelectionModel().getSelectedItems().addListener((ListChangeListener<TreeItem<String>>) c -> {
            if (c.next()) {
                console.accept("Tree View {\n" +
                        "    Removed Items from selection: " + c.getRemoved().toString() +
                        "\n    Added Items from selection: " + c.getAddedSubList().toString() +
                        "\n}");
            }
        });
        
        // We set show root to false. This will hide the root and only show it's children in the treeview.
        tree.setShowRoot(false);
        tree.setCellFactory(e -> new CellControlRenderer());

        container.getChildren().add(tree);
    }
    
    /**
     * Render a control depending on the content of the cell
     * Based on https://stackoverflow.com/questions/33360921/javafxhow-to-use-checkbox-and-button-in-treeview#33367482
     */
    class CellControlRenderer extends TreeCell<String> {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            // If the cell is empty we don't show anything.
            if (isEmpty()) {
                setGraphic(null);
                setText(null);
            } else {
                // We only show the custom cell if it is a leaf, meaning it has no children.
                if (this.getTreeItem().isLeaf() && item.equalsIgnoreCase("button")) {
                    Button button = new Button(item);
                    setGraphic(button);
                    setText(null);
                    
                    button.setOnAction(event -> console.accept("Button in the treeview was clicked"));
                } else if (this.getTreeItem().isLeaf() && item.equalsIgnoreCase("checkbox")) {
                	CheckBox checkBox = new CheckBox(item);
                    setGraphic(checkBox);
                    setText(null);
                    
                    checkBox.setOnAction(event -> console.accept("The checkbox in the treeview changed to " + checkBox.isSelected()));
                } else {
                    // If this is the root we just display the text.
                    setGraphic(null);
                    setText(item);
                }
            }
        }
    }
}
