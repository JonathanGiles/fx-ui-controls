package org.modernclients.ch3.samples;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.modernclients.ch3.Sample;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class ButtonDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        Button button = new Button("Click Me!");
        button.setOnAction(event -> console.accept("Button was clicked"));

        container.getChildren().addAll(button);
    }

    @Override
    public Optional<Node> buildControlPanel() {
        Button test = new Button("Do something");
        VBox vBox = new VBox(test);
        return Optional.of(vBox);
    }
}
