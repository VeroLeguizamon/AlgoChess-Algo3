package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import tp2java.modelo.tablero.Direccion;

public class ContenedorMovimientos extends GridPane {
	
	private Direccion DireccionSalida;
	public ContenedorMovimientos(ContenedorJuego contJuego) {
		
//		this.setVgap(10);
//		this.setHgap(10);
		
//		this.setStyle("-fx-background-color:Black");
//		this.setPadding(new Insets(10,20,10,20));
		
//		Image imgArriba=new Image("file:src/vista/imagenes/abajo.png",40,40,false,true);
//		Image imgAbajo=new Image("file:src/vista/imagenes/arriba.png",40,40,false,true);
//		Image imgDerrecha=new Image("file:src/vista/imagenes/derecha.png",40,40,false,true);
//		Image imgIzquierda=new Image("file:src/vista/imagenes/izquierda.png",40,40,false,true);
		Button btnArriba=new Button("Arriba");
		Button btnAbajo=new Button("Abajo");
		Button btnDerecha=new Button("Derecha");
		Button btnIzquierda=new Button("Izquierda");
		Button btnArribaIzq=new Button("ArribaIzq");
		Button btnAbajoIzq=new Button("AbajoIzq");
		Button btnArribaDere=new Button("ArribaDere");
		Button btnAbajoDere=new Button("AbajoDere");
		
		
//		BackgroundImage vimgArriba =new BackgroundImage(imgArriba, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
       
		
//		btnArriba.setGraphic(new ImageView(imgArriba));
//		btnAbajo.setGraphic(new ImageView(imgAbajo));
//		btnDerecha.setGraphic(new ImageView(imgDerrecha));
//		btnIzquierda.setGraphic(new ImageView(imgIzquierda));
//		
		
		btnArriba.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DireccionSalida=Direccion.ABAJO;				
			}
		});
		btnAbajo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DireccionSalida=Direccion.ARRIBA;				
			}
		});
		btnDerecha.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DireccionSalida=Direccion.DERECHA;				
			}
		});
		btnIzquierda.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DireccionSalida=Direccion.IZQUIERDA;				
			}
		});
		btnArribaIzq.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DireccionSalida=Direccion.ABAJO_IZQUIERDA;				
			}
		});
		btnAbajoIzq.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DireccionSalida=Direccion.ARRIBA_IZQUIERDA;				
			}
		});
		btnArribaDere.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DireccionSalida=Direccion.ABAJO_DERECHA;				
			}
		});
		btnAbajoDere.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DireccionSalida=Direccion.ARRIBA_DERECHA;				
			}
		});
		
		this.add(btnArriba, 1, 0);
		this.add(btnAbajo, 1, 2);
		this.add(btnDerecha, 2, 1);
		this.add(btnIzquierda, 0, 1);
		this.add(btnArribaIzq, 0, 0);
		this.add(btnArribaDere, 2, 0);
		this.add(btnAbajoIzq, 0, 2);
		this.add(btnAbajoDere, 2, 2);
//		DireccionSalida=Direccion.ABAJO;
	}
	
	public Direccion movimientoSeleccionado() {
		return this.DireccionSalida;
	}
	

}
