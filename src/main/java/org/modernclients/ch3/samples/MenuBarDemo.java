package org.modernclients.ch3.samples;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

import static org.modernclients.ch3.Utils.makeMenuItem;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class MenuBarDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        // Firstly we create our menu instances (and populate with menu items)
        final Menu fileMenu = new Menu("File");
        final Menu helpMenu = new Menu("Help");

        // we are creating a Menu here to add as a submenu to the File menu
        Menu newMenu = new Menu("Create New...");
        newMenu.getItems().addAll(
                makeMenuItem("Project", console),
                makeMenuItem("JavaFX class", console),
                makeMenuItem("FXML file", console)
        );

        // add menu items to each menu
        fileMenu.getItems().addAll(
                newMenu,
                new SeparatorMenuItem(),
                makeMenuItem("Exit", console)
        );
        helpMenu.getItems().addAll(makeMenuItem("Help", console));

        // then we create the MenuBar instance and add in the menus
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        container.getChildren().add(menuBar);
    }
}
