package controladores;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class SalirEventHandler implements EventHandler<ActionEvent>{
	
	@Override
	public void handle(ActionEvent event) {
		
		
		
		Platform.exit();	
	}
	
	

}
