package org.modernclients.ch3.samples;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

public class TabPaneDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        TabPane tabPane = new TabPane();
        Tab tab = new Tab();
        tab.setText("new tab");
        tab.setContent(new Rectangle(200,200, Color.LIGHTSTEELBLUE));
        tabPane.getTabs().add(tab);

        container.getChildren().add(tabPane);
    }
}
