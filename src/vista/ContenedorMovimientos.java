package vista;

import controladores.MoverUnidadEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import tp2java.modelo.tablero.Direccion;

public class ContenedorMovimientos extends GridPane {
	
	public ContenedorMovimientos(ContenedorJuego contJuego, VistaCelda seleccionada) {

		Button btnArriba=new Button("Arriba");
		Button btnAbajo=new Button("Abajo");
		Button btnDerecha=new Button("Derecha");
		Button btnIzquierda=new Button("Izquierda");
		Button btnArribaIzq=new Button("ArribaIzq");
		Button btnAbajoIzq=new Button("AbajoIzq");
		Button btnArribaDere=new Button("ArribaDere");
		Button btnAbajoDere=new Button("AbajoDere");
			
		btnArriba.setOnAction(new MoverUnidadEventHandler(seleccionada, contJuego, Direccion.ABAJO));
		btnAbajo.setOnAction(new MoverUnidadEventHandler(seleccionada, contJuego, Direccion.ARRIBA));
		btnDerecha.setOnAction(new MoverUnidadEventHandler(seleccionada, contJuego, Direccion.DERECHA));
		btnIzquierda.setOnAction(new MoverUnidadEventHandler(seleccionada, contJuego, Direccion.IZQUIERDA));
		btnArribaIzq.setOnAction(new MoverUnidadEventHandler(seleccionada, contJuego, Direccion.ABAJO_IZQUIERDA));
		btnAbajoIzq.setOnAction(new MoverUnidadEventHandler(seleccionada, contJuego, Direccion.ARRIBA_IZQUIERDA));
		btnArribaDere.setOnAction(new MoverUnidadEventHandler(seleccionada, contJuego, Direccion.ABAJO_DERECHA));
		btnAbajoDere.setOnAction(new MoverUnidadEventHandler(seleccionada, contJuego, Direccion.ARRIBA_DERECHA));
		
		this.add(btnArriba, 1, 0);
		this.add(btnAbajo, 1, 2);
		this.add(btnDerecha, 2, 1);
		this.add(btnIzquierda, 0, 1);
		this.add(btnArribaIzq, 0, 0);
		this.add(btnArribaDere, 2, 0);
		this.add(btnAbajoIzq, 0, 2);
		this.add(btnAbajoDere, 2, 2);
		
	}
	
	

}
