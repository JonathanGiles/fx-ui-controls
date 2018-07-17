package org.modernclients.ch3;

import javafx.scene.control.MenuItem;

import java.util.function.Consumer;

public class Utils {

    private Utils() { }

    public static MenuItem makeMenuItem(String text, Consumer<String> console) {
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(e -> console.accept("MenuItem '" + text + "' has been clicked on"));
        return menuItem;
    }
}
