package org.modernclients.ch3.samples;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class MenuBarDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        // Firstly we create our menu instances (and populate with menu items)
        final Menu fileMenu = new Menu("File");
        final Menu optionsMenu = new Menu("Options");
        final Menu helpMenu = new Menu("Help");

        // TODO add menu items

        // then we create the MenuBar instance and add in the menus
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, optionsMenu, helpMenu);

        container.getChildren().add(menuBar);
    }
}
