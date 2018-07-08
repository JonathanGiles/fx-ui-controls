package org.modernclients.ch3.samples;

import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class ScrollBarDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setMin(0.0f);
        scrollBar.setMax(0.0f);
        scrollBar.valueProperty().addListener((o, oldValue, newValue) -> console.accept("ScrollBar value is " + newValue));

        container.getChildren().add(scrollBar);
    }
}
