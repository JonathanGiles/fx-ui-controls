package org.modernclients.ch3.samples;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class CheckBoxDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        CheckBox cb = new CheckBox("Enable Power Plant");
        cb.setIndeterminate(false);
        cb.setOnAction(e -> console.accept("Action event fired"));
        cb.selectedProperty().addListener(i -> console.accept("Selected state change to " + cb.isSelected()));

        container.getChildren().add(cb);
    }
}
