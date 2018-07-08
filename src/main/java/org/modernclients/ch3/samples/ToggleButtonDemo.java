package org.modernclients.ch3.samples;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class ToggleButtonDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        // create a few toggle buttons
        ToggleButton tb1 = new ToggleButton("Toggle button 1");
        ToggleButton tb2 = new ToggleButton("Toggle button 2");
        ToggleButton tb3 = new ToggleButton("Toggle button 3");

        // create a toggle group and add all the toggle buttons to it
        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(tb1, tb2, tb3);

        // it is possible to add an onAction listener for each button
        tb1.setOnAction(e -> console.accept("ToggleButton 1 was clicked on!"));

        // but generally it is better to just add a listener to the toggle group selectedToggle property
        group.selectedToggleProperty().addListener(i -> console.accept("Selected toggle is " + group.getSelectedToggle()));

        HBox hbox = new HBox(tb1, tb2, tb3);
        container.getChildren().add(hbox);
    }
}
