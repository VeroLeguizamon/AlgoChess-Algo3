package vista;

import java.io.File;

import controladores.MoverUnidadEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import tp2java.modelo.tablero.Direccion;

public class ContenedorMovimientos extends GridPane {
	
	private static final String BTN_ARRIBA="src/vista/imagenes/arriba.png";
	private static final String BTN_ABAJO="src/vista/imagenes/abajo.png";
	private static final String BTN_DERECHA="src/vista/imagenes/izquierda.png";
	private static final String BTN_IZQUIERDA="src/vista/imagenes/derecha.png";
	
	private static final String BTN_ARRIBA_DERECHA="src/vista/imagenes/arriba_derecho.png";
	private static final String BTN_ABAJO_DERECHA="src/vista/imagenes/abajo_derecho.png";
	private static final String BTN_ARRIBA_IZQUIERDA="src/vista/imagenes/arriba_Izq.png";
	private static final String BTN__ABAJO_IZQUIERDA="src/vista/imagenes/abajo_Izq.png";
	
	
	
	public ContenedorMovimientos(ContenedorJuego contJuego, VistaCelda seleccionada) {

		
		
		
		Image imgArriba=new Image(new File(BTN_ARRIBA).toURI().toString(),30,30,false,true);
		Image imgAbajo=new Image(new File(BTN_ABAJO).toURI().toString(),30,30,false,true);
		Image imgDerecha=new Image(new File(BTN_DERECHA).toURI().toString(),30,30,false,true);
		Image imgIzquierda=new Image(new File(BTN_IZQUIERDA).toURI().toString(),30,30,false,true);
		
		
		Image imgArriba_Derecha=new Image(new File(BTN_ARRIBA_DERECHA).toURI().toString(),30,30,false,true);
		Image imgAbajo_Derecha=new Image(new File(BTN_ABAJO_DERECHA).toURI().toString(),30,30,false,true);
		Image imgArriba_Izq=new Image(new File(BTN_ARRIBA_IZQUIERDA).toURI().toString(),30,30,false,true);
		Image imgAbajo_Izq=new Image(new File(BTN__ABAJO_IZQUIERDA).toURI().toString(),30,30,false,true);
		
		
		ImageView imgVArriba=new ImageView(imgArriba);
		ImageView imgVAbajo=new ImageView(imgAbajo);
		ImageView imgVDerecha=new ImageView(imgDerecha);
		ImageView imgVIzquierdaa=new ImageView(imgIzquierda);
		
		ImageView imgVArriba_Derech=new ImageView(imgArriba_Derecha);
		ImageView imgVAbajo_Derech=new ImageView(imgAbajo_Derecha);
		ImageView imgVArriba_Izq=new ImageView(imgArriba_Izq);
		ImageView imgVAbajo_Izq=new ImageView(imgAbajo_Izq);
		
		
//		Button btnArriba=new Button("\u2191");
		Button btnArriba=new Button("",imgVArriba);
		btnArriba.setMinSize(35, 35);
		btnArriba.setMaxSize(35, 35);
//		Button btnAbajo=new Button("\u2193");
		Button btnAbajo=new Button("",imgVAbajo);
		btnAbajo.setMinSize(35, 35);
		btnAbajo.setMaxSize(35, 35);
//		Button btnDerecha=new Button("\u2192");
		Button btnDerecha=new Button("",imgVDerecha);
		btnDerecha.setMinSize(35, 35);
		btnDerecha.setMaxSize(35, 35);
//		Button btnIzquierda=new Button("\u2190");
		Button btnIzquierda=new Button("",imgVIzquierdaa);
		btnIzquierda.setMinSize(35, 35);
		btnIzquierda.setMaxSize(35, 35);
//		Button btnArribaIzq=new Button("\u2196");
		Button btnArribaIzq=new Button("",imgVArriba_Izq);
		btnArribaIzq.setMinSize(35, 35);
		btnArribaIzq.setMaxSize(35, 35);
//		Button btnAbajoIzq=new Button("\u2199");
		Button btnAbajoIzq=new Button("",imgVAbajo_Izq);
		btnAbajoIzq.setMinSize(35, 35);
		btnAbajoIzq.setMaxSize(35, 35);
//		Button btnArribaDere=new Button("\u2197");
		Button btnArribaDere=new Button("",imgVArriba_Derech);
		btnArribaDere.setMinSize(35, 35);
		btnArribaDere.setMaxSize(35, 35);
//		Button btnAbajoDere=new Button("\u2198");
		Button btnAbajoDere=new Button("",imgVAbajo_Derech);
		btnAbajoDere.setMinSize(35, 35);
		btnAbajoDere.setMaxSize(35, 35);
		
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
