package org.modernclients.ch3.samples;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.modernclients.ch3.Sample;

import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.IsoChronology;
import java.util.Optional;
import java.util.function.Consumer;

public class DatePickerDemo implements Sample {
    
    private DatePicker datePicker;
    private boolean disableFutureDaysSelection;
    
    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        datePicker = new DatePicker();
	    datePicker.setChronology(IsoChronology.INSTANCE);
	
	    Callback<DatePicker, DateCell> dayCellFactory = dp -> new DateCell() {
		    @Override
		    public void updateItem(LocalDate item, boolean empty) {
			    super.updateItem(item, empty);
			
			    if(disableFutureDaysSelection && item.isAfter(LocalDate.now())) {
				    Platform.runLater(() -> setDisable(true));
			    }
		    }
	    };
	    datePicker.setDayCellFactory(dayCellFactory);
        
        container.getChildren().addAll(datePicker);
    }
    
    @Override
    public Optional<Node> buildControlPanel() {
	    CheckBox cbShowPromptText = new CheckBox("Show Prompt Text (dd/MM/yyyy)");
	    cbShowPromptText.selectedProperty().addListener((observable, oldValue, newValue) -> {
		    if(newValue) { // selected
			    datePicker.setPromptText("dd/MM/yyyy");
		    }
		    else datePicker.setPromptText("");
	    });
	    cbShowPromptText.setSelected(true);
    	
	    CheckBox cbUseHijrahCalendar = new CheckBox("Use hijrah calendar");
	    cbUseHijrahCalendar.selectedProperty().addListener((observable, oldValue, newValue) -> {
	    	if(newValue) { // selected
			    datePicker.setChronology(HijrahChronology.INSTANCE);
		    }
		    else datePicker.setChronology(IsoChronology.INSTANCE);
	    });
	    
	    CheckBox cbDisableFutureDaysSelection = new CheckBox("Disable future days selection");
	    cbDisableFutureDaysSelection.selectedProperty().addListener((observable, oldValue, newValue) ->
		                                                                disableFutureDaysSelection = newValue);
    	
        VBox vBox = new VBox(cbShowPromptText, cbUseHijrahCalendar, cbDisableFutureDaysSelection);
	    vBox.setSpacing(5.0);
        return Optional.of(vBox);
    }
}
