package org.modernclients.ch3.samples;

import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author Abhinay Agarwal <abhinay_agarwal@live.com>
 */
public class ListViewDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {

        // Create the ListView instance
        final ListView<String> listView = new ListView<>();
        
        // Add items to ListView
        IntStream.range(1, 100).forEach(i -> listView.getItems().add("Item " + i));
        
        // Display selected item in console
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            console.accept(newValue);
        });

        container.getChildren().add(listView);
    }
}
