package org.modernclients.ch3.samples;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class ComboBoxDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Apple",
                "Carrot",
                "Orange",
                "Banana",
                "Mango",
                "Strawberry"
        );

        comboBox.getSelectionModel()
                .selectedItemProperty()
                .addListener((o, oldValue, newValue) -> console.accept(newValue));

        container.getChildren().add(comboBox);
    }
}
