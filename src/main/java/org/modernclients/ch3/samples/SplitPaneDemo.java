package org.modernclients.ch3.samples;

import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

public class SplitPaneDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        final StackPane sp1 = new StackPane();
        sp1.getChildren().add(new Button("Button One"));

        final StackPane sp2 = new StackPane();
        sp2.getChildren().add(new Button("Button Two"));

        final StackPane sp3 = new StackPane();
        sp3.getChildren().add(new Button("Button Three"));

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(sp1, sp2, sp3);
        splitPane.setDividerPositions(0.3f, 0.6f, 0.9f);

        container.getChildren().add(splitPane);
    }
}
