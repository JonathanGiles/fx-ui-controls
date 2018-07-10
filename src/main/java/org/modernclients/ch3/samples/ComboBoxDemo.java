package org.modernclients.ch3.samples;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author Abhinay Agarwal <abhinay_agarwal@live.com>
 */
public class ComboBoxDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        // Create the ComboBox instance
        ComboBox<String> comboBox = new ComboBox<>();

        // Add items to ComboBox
        IntStream.range(1, 100).forEach(i -> comboBox.getItems().add("Item " + i));
        
        // Display selected item in console
        comboBox.setOnAction(e -> console.accept(comboBox.getSelectionModel().getSelectedItem()));
        
        container.getChildren().add(comboBox);
    }
}
