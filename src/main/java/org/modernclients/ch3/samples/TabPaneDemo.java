package org.modernclients.ch3.samples;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.modernclients.ch3.Sample;

import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class TabPaneDemo implements Sample {

    private TabPane tabPane;

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        for (int i = 0; i < 5; i++) {
            Tab tab = new Tab("Tab " + i, new Rectangle(200, 200, randomColor()));
            tabPane.getTabs().add(tab);
        }

        container.getChildren().add(tabPane);
    }

    @Override
    public Optional<Node> buildControlPanel() {
        // toggle between standard and floating modes
        CheckBox floating = new CheckBox("Floating");
        floating.selectedProperty().addListener(i -> {
            tabPane.getStyleClass().remove(TabPane.STYLE_CLASS_FLOATING);
            if (floating.isSelected()) tabPane.getStyleClass().add(TabPane.STYLE_CLASS_FLOATING);
        });

        VBox vbox = new VBox(floating);
        return Optional.of(vbox);
    }

    private Color randomColor() {
        Random r = new Random();
        return Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256), 1.0);
    }
}
