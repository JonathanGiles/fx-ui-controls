package org.modernclients.ch3.samples;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

public class ToggleButtonDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        ToggleButton tb1 = new ToggleButton("Toggle button 1");
        ToggleButton tb2 = new ToggleButton("Toggle button 2");
        ToggleButton tb3 = new ToggleButton("Toggle button 3");

        ToggleGroup group = new ToggleGroup();
        tb1.setToggleGroup(group);
        tb2.setToggleGroup(group);
        tb3.setToggleGroup(group);

        group.selectedToggleProperty().addListener(i -> console.accept("Selected toggle is " + group.getSelectedToggle()));

        HBox hbox = new HBox(tb1, tb2, tb3);
        container.getChildren().add(hbox);
    }
}
