package vista;

import javafx.geometry.Pos;

//import java.awt.TextField;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class IngresoJugadores {
	private final HBox hBox;
	private final TextField texto;
	
	public IngresoJugadores(String textomostrar) {
		// TODO Auto-generated constructor stub
	
		
		TextField textoInicio=new TextField(textomostrar);
		textoInicio.setPrefColumnCount(30);
		HBox hbox=new HBox(textoInicio);
		hbox.setSpacing(20);
		hbox.setAlignment(Pos.CENTER);
		this.hBox=hbox;
		this.texto=textoInicio;
		
		
	}

	public HBox gethBox() {
		return this.hBox;
	}

	public String getNombre() {
		return this.texto.getText();
	}

}
