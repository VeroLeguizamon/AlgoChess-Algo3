package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Aplicacion extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	private Stage stage;

	@Override
	public void start(final Stage primaryStage) throws Exception {
		
		this.stage = primaryStage;
		
		primaryStage.setTitle("TP-AlgoChess");
		primaryStage.getIcons().add(new Image("file:src/vista/imagenes/icon.png"));
		
		ContenedorBienvenida contenedorBienvenida=new ContenedorBienvenida(primaryStage);
		Scene escenaBienvenida=new Scene(contenedorBienvenida,1100,650);
		contenedorBienvenida.setBotonesSalirJugar(this);
		
		primaryStage.setScene(escenaBienvenida);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	public void cambiarEscenaCompra() {
		//Se le deben pasar jugadores 
		ContenedorCompra compra = new ContenedorCompra(this.stage);
		compra.setBotonSiguiente();
		Scene escenaCompra = new Scene(compra,1100,650);
		this.stage.setScene(escenaCompra);
		this.stage.show();
	}

}
