package org.modernclients.ch3.samples;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

public class TextFieldDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        TextField textField = new TextField();
        textField.setPromptText("Enter name here");

        // this is fired when the user hits the Enter key
        textField.setOnAction(e -> console.accept("Entered text is: " + textField.getText()));

        // we can also observe input in real time
        textField.textProperty().addListener((o, oldValue, newValue) -> console.accept("current text input is " + newValue));

        container.getChildren().add(textField);
    }
}
