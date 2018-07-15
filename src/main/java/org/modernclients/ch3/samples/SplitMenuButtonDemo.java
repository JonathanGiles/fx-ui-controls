package org.modernclients.ch3.samples;

import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

import static org.modernclients.ch3.Utils.makeMenuItem;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class SplitMenuButtonDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        SplitMenuButton splitMenuButton = new SplitMenuButton();

        // this is the text in the 'action' area
        splitMenuButton.setText("Perform action!");

        // these are the menu items to display in the popup menu
        splitMenuButton.getItems().addAll(
                makeMenuItem("Burgers", console),
                makeMenuItem("Pizza", console),
                makeMenuItem("Hot Dog", console));

        // splitMenuButton does fire an onAction event, when the 'action' area is pressed
        splitMenuButton.setOnAction(e -> console.accept("SplitMenuButton onAction event"));

        container.getChildren().add(splitMenuButton);
    }
}
