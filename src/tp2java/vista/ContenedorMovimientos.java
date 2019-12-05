package tp2java.vista;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import tp2java.controladores.MoverUnidadEventHandler;
import tp2java.modelo.tablero.Direccion;

public class ContenedorMovimientos extends GridPane {
	
	public ContenedorMovimientos(ContenedorJuego contJuego, VistaCelda seleccionada) {

		Button btnArriba=new Button("\u2191");
		btnArriba.setMinSize(30, 30);
		Button btnAbajo=new Button("\u2193");
		btnAbajo.setMinSize(30, 30);
		Button btnDerecha=new Button("\u2192");
		btnDerecha.setMinSize(30, 30);
		Button btnIzquierda=new Button("\u2190");
		btnIzquierda.setMinSize(30, 30);
		Button btnArribaIzq=new Button("\u2196");
		btnArribaIzq.setMinSize(30, 30);
		Button btnAbajoIzq=new Button("\u2199");
		btnAbajoIzq.setMinSize(30, 30);
		Button btnArribaDere=new Button("\u2197");
		btnArribaDere.setMinSize(30, 30);
		Button btnAbajoDere=new Button("\u2198");
		btnAbajoDere.setMinSize(30, 30);
		
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
