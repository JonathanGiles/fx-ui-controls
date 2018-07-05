package org.modernclients.ch3.samples;

import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

public class ProgressBarDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(0.25f);

        container.getChildren().add(progressBar);
    }
}
