package org.modernclients.ch3.samples;

import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class HyperlinkDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        Hyperlink hyperlink = new Hyperlink("Click Me!");
        hyperlink.setOnAction(event -> console.accept("Hyperlink was clicked"));

        container.getChildren().add(hyperlink);
    }
}
