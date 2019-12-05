package tp2java.vista;

import javafx.geometry.Pos;

//import java.awt.TextField;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class IngresoJugadores {
	private final HBox hBox;
	private final TextField texto;
	
	public IngresoJugadores(String textomostrar) {
		
		TextField textoInicio=new TextField();
		textoInicio.setPromptText(textomostrar);
		textoInicio.setFont(Font.font("Arial",15));
		textoInicio.setStyle("-fx-padding:10 10 10 10; -fx-border-style:solid;"
				+ "-fx-border-size:3px; -fx-border-color:#888;");
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
	public boolean tieneNombreVacio() {
		return this.getNombre().isEmpty();
	}
}
