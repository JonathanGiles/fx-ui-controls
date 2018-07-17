package org.modernclients.ch3.samples;

import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class SliderDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        Slider slider = new Slider(0.0f, 1.0f, 0.5f);
        slider.valueProperty().addListener((o, oldValue, newValue) -> console.accept("Slider value is " + newValue));

        container.getChildren().add(slider);
    }
}
