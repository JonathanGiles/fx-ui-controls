package org.modernclients.ch3.samples;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import org.modernclients.ch3.Sample;
import org.modernclients.ch3.model.Person;

import java.util.function.Consumer;

import static org.modernclients.ch3.model.Person.Gender.Female;
import static org.modernclients.ch3.model.Person.Gender.Male;

public class TableViewDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {

        // Create the TableColumn instances
        final TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
        final TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        final TableColumn<Person, Person.Gender> genderColumn = new TableColumn<>("Gender");

        // Set data properties to columns
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        
        // Create the ListView instance
        final TableView<Person> tableView = new TableView<>();
        
        // Add TableColumns to TableView
        tableView.getColumns().addAll(firstNameColumn, lastNameColumn, genderColumn);

        // Add list of persons to TableView
        tableView.getItems().addAll(createPersons());
        
        container.getChildren().add(tableView);
    }
    
    private ObservableList<Person> createPersons() {
        return FXCollections.observableArrayList(
            new Person("Jonathan", "Giles", Male),
            new Person("Julia", "Giles", Female),
            new Person("Henry", "Giles", Male),
            new Person("Pippa", "Giles", Female)
        );
    }
}