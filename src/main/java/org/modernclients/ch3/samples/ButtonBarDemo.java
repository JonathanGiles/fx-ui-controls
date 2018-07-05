package org.modernclients.ch3.samples;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

import static javafx.scene.control.ButtonBar.ButtonData;

public class ButtonBarDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        // Create the ButtonBar instance
        ButtonBar buttonBar = new ButtonBar();

        // Create the buttons to go into the ButtonBar
        Button yesButton = new Button("Yes");
        ButtonBar.setButtonData(yesButton, ButtonData.YES);

        Button noButton = new Button("No");
        ButtonBar.setButtonData(noButton, ButtonData.NO);

        // Add buttons to the ButtonBar
        buttonBar.getButtons().addAll(yesButton, noButton);

        container.getChildren().addAll(buttonBar);
    }
}
