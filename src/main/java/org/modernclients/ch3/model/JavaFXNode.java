package org.modernclients.ch3.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JavaFXNode {

    private StringProperty name = new SimpleStringProperty();
    private StringProperty parent = new SimpleStringProperty();

    public JavaFXNode(String name, String parent) {
        this.name.set(name);
        this.parent.set(parent);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getParent() {
        return parent.get();
    }

    public StringProperty parentProperty() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent.set(parent);
    }
}
