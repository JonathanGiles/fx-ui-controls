package org.modernclients.ch3.samples;

import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

public class TitledPaneDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        TitledPane t1 = new TitledPane("TitledPane 1", new Button("Button 1"));

        container.getChildren().add(t1);
    }
}
