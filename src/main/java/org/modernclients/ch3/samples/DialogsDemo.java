package org.modernclients.ch3.samples;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Almas Baimagambetov <almaslvl@gmail.com>
 */
public class DialogsDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        container.getChildren().addAll(new VBox(
                createButton(new Alert(AlertType.INFORMATION), "Information Alert"),
                createButton(new Alert(AlertType.CONFIRMATION), "Confirmation Alert"),
                createButton(new Alert(AlertType.WARNING), "Warning Alert"),
                createButton(new Alert(AlertType.ERROR), "Error Alert"),

                createButton(new ChoiceDialog<>("Cat",
                        "Dog", "Cat", "Mouse"), "Choice Dialog"),

                createButton(new TextInputDialog("Hello World"), "Text Input Dialog")
        ));
    }

    private Button createButton(Dialog<?> dialog, String dialogName) {
        Button btn = new Button("Show " + dialogName);
        btn.setOnAction(e -> dialog.show());
        return btn;
    }
}
