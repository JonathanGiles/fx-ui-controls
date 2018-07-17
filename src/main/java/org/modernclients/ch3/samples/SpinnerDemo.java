package org.modernclients.ch3.samples;

import javafx.scene.control.Spinner;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class SpinnerDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        Spinner spinner = new Spinner();

        container.getChildren().add(spinner);
    }
}
