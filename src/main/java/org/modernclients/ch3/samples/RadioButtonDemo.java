package org.modernclients.ch3.samples;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

public class RadioButtonDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        RadioButton rb1 = new RadioButton("Radio button 1");
        RadioButton rb2 = new RadioButton("Radio button 2");
        RadioButton rb3 = new RadioButton("Radio button 3");

        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        group.selectedToggleProperty().addListener(i -> console.accept("Selected toggle is " + group.getSelectedToggle()));

        HBox hbox = new HBox(rb1, rb2, rb3);
        container.getChildren().add(hbox);
    }
}
