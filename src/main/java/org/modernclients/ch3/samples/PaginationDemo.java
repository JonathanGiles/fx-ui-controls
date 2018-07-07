package org.modernclients.ch3.samples;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.Pagination;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.modernclients.ch3.Sample;

import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public class PaginationDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {
        Pagination pagination = new Pagination(10, 0);
        pagination.setPageFactory(pageIndex -> {
            VBox box = new VBox(5);
            for (int i = 0; i < 10; i++) {
                int linkNumber = pageIndex * 10 + i;
                Hyperlink link = new Hyperlink("Hyperlink #" + linkNumber);
                link.setOnAction(e -> console.accept("Hyperlink #" + linkNumber + " clicked!"));
                box.getChildren().add(link);
            }
            return box;
        });

        container.getChildren().add(pagination);
    }
}
