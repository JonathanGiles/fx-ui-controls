package org.modernclients.ch3.samples;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import org.modernclients.ch3.Sample;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 * @author Frank Delporte <frank@webtechie.be>
 */
public class ProgressIndicatorDemo implements Sample {
    // No initial value of the ProgressIndicator is set, so will have an indeterminate indicator
    final ProgressIndicator progressIndicator = new ProgressIndicator();

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        container.getChildren().addAll(progressIndicator);
    }

    @Override
    public Optional<Node> buildControlPanel() {
        CheckBox indeterminateCheckBox = new CheckBox();
        indeterminateCheckBox.setSelected(true);

        Slider progressSlider = new Slider(0.0f, 1.0f, 0.5f);
        progressSlider.disableProperty().bind(indeterminateCheckBox.selectedProperty());

        indeterminateCheckBox.selectedProperty().addListener(o -> {
            if (indeterminateCheckBox.isSelected()) {
                progressIndicator.progressProperty().unbind();
                progressIndicator.setProgress(-1);
            } else {
                progressIndicator.progressProperty().bind(progressSlider.valueProperty());
            }
        });

        VBox vBox = new VBox(10,
                new Label("Indeterminate:"),
                indeterminateCheckBox,
                new Label("Progress:"),
                progressSlider);
        return Optional.of(vBox);
    }
}
