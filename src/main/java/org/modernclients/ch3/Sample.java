package org.modernclients.ch3;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Jonathan Giles <jonathan@jonathangiles.net>
 */
public interface Sample extends Comparable<Sample> {

    void buildDemo(Pane container, Consumer<String> console);

    default String getName() {
        String className = getClass().getSimpleName();
        return className.endsWith("Demo") ?
                className.substring(0, className.length() - 4) :
                "Unknown Demo";
    }

    default Optional<Node> buildControlPanel() {
        return Optional.empty();
    }

    @Override
    default int compareTo(Sample o) {
        return getName().compareTo(o.getName());
    }
}
