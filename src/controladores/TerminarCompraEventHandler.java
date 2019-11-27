package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class TerminarCompraEventHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	public TerminarCompraEventHandler(Stage stage) {
		super();
		this.stage = stage;
	}

	@Override
	public void handle(ActionEvent event) {
		//TODO: colocar unidades
	}
}
