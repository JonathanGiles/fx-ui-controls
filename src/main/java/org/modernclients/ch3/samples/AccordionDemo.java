package org.modernclients.ch3.samples;

import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import org.modernclients.ch3.Sample;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 * @author Frank Delporte <frank@webtechie.be>
 */
public class AccordionDemo implements Sample {
	// Define the panes so we can use them later to change
    private TitledPane t1;
    private TitledPane t2;
    private TitledPane t3;
    private Accordion accordion;

    // Construct the demo screen
    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        t1 = new TitledPane("TitledPane 1", new Button("Button 1"));
        t2 = new TitledPane("TitledPane 2", new Button("Button 2"));
        t3 = new TitledPane("TitledPane 3", new Button("Button 3"));
        
        accordion = new Accordion();
        accordion.getPanes().addAll(t1, t2, t3);
        
        container.getChildren().addAll(accordion);
    }

    // Add the control panel
    @Override
    public Optional<Node> buildControlPanel() {
    	// Create animation checkbox
    	CheckBox animatedCheckBox = new CheckBox();
    	animatedCheckBox.setSelected(true);
    	
    	t1.animatedProperty().bind(animatedCheckBox.selectedProperty());
    	t2.animatedProperty().bind(animatedCheckBox.selectedProperty());
    	t3.animatedProperty().bind(animatedCheckBox.selectedProperty());
    	
    	// Create radiobuttons
        RadioButton rbNone = new RadioButton();   
        rbNone.setSelected(true);
        
        RadioButton rb1 = new RadioButton();             
        RadioButton rb2 = new RadioButton();        
        RadioButton rb3 = new RadioButton();
        
        // Create a toggle group and add all the radio buttons to it
        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(rbNone, rb1, rb2, rb3);
     
        group.selectedToggleProperty().addListener(o -> {
        	t1.setBorder(Border.EMPTY);
        	t2.setBorder(Border.EMPTY);
        	t3.setBorder(Border.EMPTY);
        	        	
            if (rb1.isSelected()) {
            	t1.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            	accordion.setExpandedPane(t1);
            } else if (rb2.isSelected()) {
            	t2.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.DASHED, new CornerRadii(0), new BorderWidths(1))));
            	accordion.setExpandedPane(t2);
            } else if (rb3.isSelected()) {
            	t3.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.DOTTED, new CornerRadii(0), new BorderWidths(5))));
            	accordion.setExpandedPane(t3);
            } 
        });

        VBox vBox = new VBox(10,
                new HBox(10, animatedCheckBox, new Label("Animated")),
                new Separator(),
                new Label("Highlight"),
                new HBox(10, rbNone, new Label("None")),
                new HBox(10, rb1, new Label("Accordion 1")),
                new HBox(10, rb2, new Label("Accordion 2")),
                new HBox(10, rb3, new Label("Accordion 3"))
        );
        return Optional.of(vBox);
    }
}