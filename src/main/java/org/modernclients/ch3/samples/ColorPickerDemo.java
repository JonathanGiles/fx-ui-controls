package org.modernclients.ch3.samples;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class ColorPickerDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction(e -> {
            Color c = colorPicker.getValue();
            System.out.println("New Color's RGB = "+c.getRed()+" "+c.getGreen()+" "+c.getBlue());
        });

        container.getChildren().add(colorPicker);
    }
}
