package org.modernclients.ch3.samples;

import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

public class AccordionDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        TitledPane t1 = new TitledPane("TitledPane 1", new Button("Button 1"));
        TitledPane t2 = new TitledPane("TitledPane 2", new Button("Button 2"));
        TitledPane t3 = new TitledPane("TitledPane 3", new Button("Button 3"));
        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(t1, t2, t3);

        container.getChildren().addAll(accordion);
    }
}
