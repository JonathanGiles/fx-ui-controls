package org.modernclients.ch3.samples;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class RadioButtonDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        // create a few radio buttons
        RadioButton rb1 = new RadioButton("Radio button 1");
        RadioButton rb2 = new RadioButton("Radio button 2");
        RadioButton rb3 = new RadioButton("Radio button 3");

        // create a toggle group and add all the radio buttons to it
        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(rb1, rb2, rb3);

        // it is possible to add an onAction listener for each button
        rb1.setOnAction(e -> console.accept("RadioButton 1 was clicked on!"));

        // but generally it is better to just add a listener to the toggle group selectedToggle property
        group.selectedToggleProperty().addListener(i -> console.accept("Selected toggle is " + group.getSelectedToggle()));

        HBox hbox = new HBox(rb1, rb2, rb3);
        container.getChildren().add(hbox);
    }
}
