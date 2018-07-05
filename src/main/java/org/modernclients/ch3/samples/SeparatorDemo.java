package org.modernclients.ch3.samples;

import javafx.scene.control.ScrollBar;
import javafx.scene.control.Separator;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

public class SeparatorDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        Separator separator = new Separator();

        container.getChildren().add(separator);
    }
}
