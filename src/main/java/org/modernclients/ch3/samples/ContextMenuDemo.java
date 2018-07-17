package org.modernclients.ch3.samples;

import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

import static org.modernclients.ch3.Utils.makeMenuItem;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class ContextMenuDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        // create a standard JavaFX Button
        Button button = new Button("Right-click Me!");
        button.setOnAction(event -> console.accept("Button was clicked"));
        button.setContextMenu(makeContextMenu(console));

        ContextMenu rectangleContextMenu = makeContextMenu(console);
        Rectangle rectangle = new Rectangle(50, 50, Color.RED);
        rectangle.setOnContextMenuRequested(e -> {
            // show the contextMenu to the right of the rectangle with zero
            // offset in x and y directions
            rectangleContextMenu.show(rectangle, Side.RIGHT, 0, 0);
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new Label("Right-click the following nodes for a context menu:"));
        borderPane.setCenter(new HBox(10, button, rectangle));

        container.getChildren().addAll(borderPane);
    }

    private ContextMenu makeContextMenu(Consumer<String> console) {
        // create a ContextMenu
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().addAll(
                makeMenuItem("Hello", console),
                makeMenuItem("World!", console),
                new SeparatorMenuItem(),
                makeMenuItem("Goodbye Again!", console)
        );
        return contextMenu;
    }
}
