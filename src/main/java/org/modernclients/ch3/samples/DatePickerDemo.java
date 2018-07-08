package org.modernclients.ch3.samples;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.modernclients.ch3.Sample;

import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DatePickerDemo implements Sample {
 
	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
    private DatePicker datePicker;
    private boolean disableFutureDaysSelection;
    
    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        datePicker = new DatePicker();
	    datePicker.setChronology(IsoChronology.INSTANCE);
	
	    Predicate<LocalDate> dateValidator = localDate -> localDate.isAfter(LocalDate.now());
	
	    Callback<DatePicker, DateCell> dayCellFactory = dp -> new DateCell() {
		    @Override
		    public void updateItem(LocalDate date, boolean empty) {
			    super.updateItem(date, empty);
			
			    if(disableFutureDaysSelection && dateValidator.test(date)) {
				    Platform.runLater(() -> setDisable(true));
			    }
		    }
	    };
	    datePicker.setDayCellFactory(dayCellFactory);
	
	    StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
		    @Override
		    public String toString(LocalDate date) {
			    if(date != null) return dateFormatter.format(date);
			    else return "";
		    }
		
		    @Override
		    public LocalDate fromString(String string) {
			    if(string != null && !string.trim().isEmpty()) {
				    LocalDate date = LocalDate.parse(string, dateFormatter);
				
				    if(disableFutureDaysSelection && dateValidator.test(date)) {
					    return datePicker.getValue(); // the old value
				    }
				    else return date;
			    }
			    else return null;
		    }
	    };
	    datePicker.setConverter(converter);
        
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
	
	    CheckBox cbDisableTextEditing = new CheckBox("Disable text editing");
	    cbDisableTextEditing.selectedProperty().addListener((observable, oldValue, newValue) ->
			                                                      datePicker.getEditor().setEditable(!newValue));
	    
	    CheckBox cbDisableFutureDaysSelection = new CheckBox("Disable future days selection");
	    cbDisableFutureDaysSelection.selectedProperty().addListener((observable, oldValue, newValue) ->
		                                                                disableFutureDaysSelection = newValue);
    	
        VBox vBox = new VBox(cbShowPromptText, cbUseHijrahCalendar, cbDisableTextEditing, cbDisableFutureDaysSelection);
	    vBox.setSpacing(5.0);
        return Optional.of(vBox);
    }
}
