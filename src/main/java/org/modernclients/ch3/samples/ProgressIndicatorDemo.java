package org.modernclients.ch3.samples;

import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

public class ProgressIndicatorDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setProgress(0.25f);

        container.getChildren().add(progressIndicator);
    }
}
