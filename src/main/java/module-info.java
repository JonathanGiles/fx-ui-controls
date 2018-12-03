module org.modernclients.ch3 {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.media;

    exports org.modernclients.ch3 to javafx.graphics, javafx.fxml;

    opens org.modernclients.ch3 to javafx.graphics, javafx.fxml;

}
