package org.modernclients.ch3.samples;

import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class PasswordFieldDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password here");

        // this is fired when the user hits the Enter key
        passwordField.setOnAction(e -> console.accept("Entered password is: " + passwordField.getText()));

        // we can also observe input in real time
        passwordField.textProperty().addListener((o, oldValue, newValue) -> console.accept("current password input is " + newValue));

        container.getChildren().add(passwordField);
    }
}
