package org.modernclients.ch3.samples;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 * @author Frank Delporte <frank@webtechie.be>
 */
public class ProgressIndicatorDemo implements Sample {
    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
    	// We will align some components vertically
    	final VBox holder = new VBox();
    	holder.prefWidthProperty().bind(container.prefWidthProperty());
    	holder.prefHeightProperty().bind(container.prefHeightProperty());
    	container.getChildren().add(holder);
    	
    	// Construct the ProgressIndicator
    	// No initial value of the ProgressIndicator is set, so will have an indeterminated value
        final ProgressIndicator progressIndicator = new ProgressIndicator();
    	
    	// Add a ButtonBar instance to demo different functions of the ProgressIndicator
        final ButtonBar buttonBar = new ButtonBar();

        // Construct multiple buttons for demo cases
        final Button setTo0 = new Button("Set to indeterminated");
        setTo0.setOnAction(event -> progressIndicator.setProgress(-1));
        
        final Button setTo50 = new Button("Set to 50%");
        setTo50.setOnAction(event -> progressIndicator.setProgress(0.5f));
        
        final Button setTo75 = new Button("Set to 75%");
        setTo75.setOnAction(event -> progressIndicator.setProgress(0.75f));

        // Add buttons to the ButtonBar
        buttonBar.getButtons().addAll(setTo0, setTo50, setTo75);
        holder.getChildren().addAll(buttonBar);
    	
    	// Add it to the screen
        holder.getChildren().add(progressIndicator);
    }
}
