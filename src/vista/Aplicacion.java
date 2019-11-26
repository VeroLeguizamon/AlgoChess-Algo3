package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("TP-AlgoChess");
		
		ContenedorBienvenida contenedorBienvenida=new ContenedorBienvenida(primaryStage);
		Scene escenaBienvenida=new Scene(contenedorBienvenida,850,650);
		contenedorBienvenida.setBotonesSalirJugar(primaryStage);
		
		primaryStage.setScene(escenaBienvenida);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

}
