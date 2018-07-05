package org.modernclients.ch3.samples;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import org.modernclients.ch3.Sample;

import java.util.Observable;
import java.util.function.Consumer;

import static javafx.scene.control.ButtonBar.ButtonData;

public class ScrollPaneDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.RED)};
        LinearGradient gradient = new LinearGradient(0, 0, 1500, 1000, false, CycleMethod.NO_CYCLE, stops);

        Rectangle rect = new Rectangle(2000, 2000, gradient);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(120, 120);
        scrollPane.setContent(rect);

        ChangeListener<? super Number> o =
                (obs, oldValue, newValue) -> console.accept("x / y values are: (" + scrollPane.getHvalue() + ", " + scrollPane.getVvalue() + ")");
        scrollPane.hvalueProperty().addListener(o);
        scrollPane.vvalueProperty().addListener(o);

        container.getChildren().add(scrollPane);
    }
}
