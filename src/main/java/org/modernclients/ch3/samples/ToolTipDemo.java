package org.modernclients.ch3.samples;

import java.util.Optional;
import java.util.function.Consumer;

import org.modernclients.ch3.Sample;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * @author Cyril FISCHER <contact@CyrilFischer.fr>
 */
public class ToolTipDemo implements Sample {

	private final Rectangle rectangle = new Rectangle(120, 120, Color.RED);
	private final Tooltip rectangleTooltip = new Tooltip("A Red Square (size : 120px)");

	private final Button hoverButton = new Button("Hover over me");
	private final Tooltip buttonTootlip = new Tooltip(
			"A button \n" + "Tooltip on control can be added with a convenient method");

	private final Circle circle = new Circle(50, Color.BLUE);
	private final Tooltip circleTooltip = new Tooltip("A Blue Circle (radius : 50px)");

	@Override
	public void buildDemo(Pane container, Consumer<String> console) {

		installToolTips();

		layoutDemo(rectangle, hoverButton, circle, container);
	}

	private void layoutDemo(Rectangle rectangle, Button hoverButton, Circle circle, Pane container) {

		Text instructionText = new Text("Hover over nodes");
		instructionText.setStyle("-fx-font-size: 18;");
		GridPane.setHalignment(instructionText, HPos.CENTER);

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setStyle("-fx-hgap: 3em; -fx-vgap: 3em");
		gridPane.add(instructionText, 0, 0, 3, 1);
		gridPane.add(rectangle, 0, 1);
		gridPane.add(hoverButton, 1, 1);
		gridPane.add(circle, 2, 1);
		container.getChildren().add(gridPane);

	}

	@Override
	public Optional<Node> buildControlPanel() {

		ToggleButton installToggle = new ToggleButton("Install/Uninstall");
		installToggle.setSelected(true);
		installToggle.setOnAction(a -> {
			if (installToggle.isSelected()) {
				installToolTips();
			} else {
				uninstallTooltips();
			}
		});

		Spinner<Integer> showDelaySpinner = new Spinner<>(0, 10_000, 1000, 500);
		showDelaySpinner.valueProperty().addListener((obs, old, showDelay) -> setShowDelay(showDelay));
		Label showDelayLabel = new Label("Showing Delay :");

		Spinner<Integer> hideDelaySpinner = new Spinner<>(0, 10_000, 200, 500);
		hideDelaySpinner.valueProperty().addListener((obs, old, hideDelay) -> setHideDelay(hideDelay));
		Label hideDelayLabel = new Label("Hiding Delay :");

		Spinner<Integer> showDurationSpinner = new Spinner<>(0, 10_000, 5000, 500);
		showDurationSpinner.valueProperty().addListener((obs, old, showDuration) -> setshowDuration(showDuration));
		Label showDurationLabel = new Label("Duration :");

		GridPane gridPane = layoutControlPanel(installToggle, showDelaySpinner, showDelayLabel, hideDelaySpinner,
				hideDelayLabel, showDurationSpinner, showDurationLabel);
		return Optional.of(gridPane);
	}

	private GridPane layoutControlPanel(ToggleButton installToggle, Spinner<Integer> showDelaySpinner,
			Label showDelayLabel, Spinner<Integer> hideDelaySpinner, Label hideDelayLabel,
			Spinner<Integer> showDurationSpinner, Label showDurationLabel) {
		GridPane gridPane = new GridPane();
		gridPane.add(installToggle, 0, 0);

		gridPane.add(showDelayLabel, 0, 1);
		gridPane.add(showDelaySpinner, 1, 1);

		gridPane.add(hideDelayLabel, 0, 2);
		gridPane.add(hideDelaySpinner, 1, 2);

		gridPane.add(showDurationLabel, 0, 3);
		gridPane.add(showDurationSpinner, 1, 3);

		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setStyle("-fx-hgap: 1em; -fx-vgap: 1em");
		return gridPane;
	}

	private void setShowDelay(int showDelay) {
		Duration duration = new Duration(showDelay);
		rectangleTooltip.setShowDelay(duration);
		buttonTootlip.setShowDelay(duration);
		circleTooltip.setShowDelay(duration);
	}

	private void setHideDelay(int hideDelay) {
		Duration duration = new Duration(hideDelay);
		rectangleTooltip.setHideDelay(duration);
		buttonTootlip.setHideDelay(duration);
		circleTooltip.setHideDelay(duration);

	}

	private void setshowDuration(int showDuration) {
		Duration duration = new Duration(showDuration);
		rectangleTooltip.setShowDuration(duration);
		buttonTootlip.setShowDuration(duration);
		circleTooltip.setShowDuration(duration);

	}

	private void installToolTips() {
		Tooltip.install(rectangle, rectangleTooltip);
		hoverButton.setTooltip(buttonTootlip);
		Tooltip.install(circle, circleTooltip);
	}

	private void uninstallTooltips() {
		Tooltip.uninstall(rectangle, rectangleTooltip);
		hoverButton.setTooltip(null);
		Tooltip.uninstall(circle, circleTooltip);

	}
}
