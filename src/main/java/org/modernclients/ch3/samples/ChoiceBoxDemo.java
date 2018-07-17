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

        choiceBox.getItems().addAll(
            "Choice 1",
            "Choice 2",
            "Choice 3",
            "Choice 4"
        );

        choiceBox.getSelectionModel()
                .selectedItemProperty()
                .addListener((o, oldValue, newValue) -> console.accept(newValue));

        container.getChildren().add(choiceBox);
    }
}
