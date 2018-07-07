package org.modernclients.ch3.samples;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Mohammad Hossein Rimaz <mhrimaz@yahoo.com>
 */
public class ChoiceBoxDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        choiceBox.getItems().add("Choice 1");
        choiceBox.getItems().add("Choice 2");
        choiceBox.getItems().add("Choice 3");
        choiceBox.getItems().add("Choice 4");

        choiceBox.setOnAction(e->console.accept(choiceBox.getSelectionModel().getSelectedItem()));

        container.getChildren().add(choiceBox);
    }
}
