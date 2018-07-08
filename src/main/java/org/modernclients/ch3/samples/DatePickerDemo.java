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

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Fouad Almalki <me@fouad.io>
 */
public class DatePickerDemo implements Sample {
 
	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
    private DatePicker datePicker;
    private boolean disableRangeSelection;
    private Predicate<LocalDate> dateValidator = localDate -> {
    	if(disableRangeSelection) {
    		return localDate != null && !localDate.isAfter(LocalDate.now());
	    }
	    else return localDate != null;
    };
    
    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        datePicker = new DatePicker();
	    datePicker.setChronology(IsoChronology.INSTANCE);
	    datePicker.setOnAction(e -> {
		    LocalDate date = datePicker.getValue();
		    console.accept("Selected date: " + (date != null ? dateFormatter.format(date) : null));
	    });
	
	    Callback<DatePicker, DateCell> dayCellFactory = dp -> new DateCell() {
		    @Override
		    public void updateItem(LocalDate date, boolean empty) {
			    super.updateItem(date, empty);
			
			    if(!dateValidator.test(date)) {
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
			    System.out.println("string = " + string);
			    if(string != null && !string.trim().isEmpty()) {
				
				    LocalDate oldValue = datePicker.getValue();
				    LocalDate newValue;
			    	
			    	try {
					    newValue = LocalDate.parse(string, dateFormatter);
				    }
				    catch(DateTimeException e) {
				    	console.accept("The text \"" + string + "\" does not match the pattern \"dd/MM/yyyy\"");
				    	return oldValue;
				    }
				
				    if(!dateValidator.test(newValue)) {
					    console.accept("The date (" + dateFormatter.format(newValue) + ") is not allowed!");
					    return oldValue;
				    }
				    else return newValue;
			    }
			    else return null;
		    }
	    };
	    datePicker.setConverter(converter);
        
        container.getChildren().addAll(datePicker);
    }
    
    @Override
    public Optional<Node> buildControlPanel() {
	    CheckBox cbShowPromptText = new CheckBox("Show prompt text (dd/MM/yyyy)");
	    cbShowPromptText.selectedProperty().addListener((observable, oldValue, newValue) -> {
		    if(newValue) { // selected
			    datePicker.setPromptText("dd/MM/yyyy");
		    }
		    else datePicker.setPromptText("");
	    });
	    cbShowPromptText.setSelected(true);
    	
	    CheckBox cbShowHijrahCalendar = new CheckBox("Show hijrah calendar");
	    cbShowHijrahCalendar.selectedProperty().addListener((observable, oldValue, newValue) -> {
	    	if(newValue) { // selected
			    datePicker.setChronology(HijrahChronology.INSTANCE);
		    }
		    else datePicker.setChronology(IsoChronology.INSTANCE);
	    });
	
	    CheckBox cbDisableTextEditing = new CheckBox("Disable text editing");
	    cbDisableTextEditing.selectedProperty().addListener((observable, oldValue, newValue) ->
			                                                      datePicker.getEditor().setEditable(!newValue));
	    
	    CheckBox cbDisableFutureDaysSelection = new CheckBox("Disable range selection (e.g. future dates)");
	    cbDisableFutureDaysSelection.selectedProperty().addListener((observable, oldValue, newValue) -> {
			disableRangeSelection = newValue;
		
		    if(!dateValidator.test(datePicker.getValue())) {
			    datePicker.setValue(null);
			}
	    });
    	
        VBox vBox = new VBox(cbShowPromptText, cbShowHijrahCalendar,
                             cbDisableTextEditing, cbDisableFutureDaysSelection);
	    vBox.setSpacing(5.0);
        return Optional.of(vBox);
    }
}
