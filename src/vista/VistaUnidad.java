package vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class VistaUnidad extends Button{
	
	public VistaUnidad(String rutaImagen) {
		
		super();
		
		String string ="-fx-border-style:solid;" + 
				"-fx-border-color:#C89B70;" + 
				"-fx-border-width:1px;";
		Image unidad= new Image(rutaImagen,150,200,false,true);
        BackgroundImage vistaUnidad =new BackgroundImage(unidad, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
        this.setBackground(new Background(vistaUnidad));
        this.setStyle(string);
        this.setMinHeight(200);
        this.setMinWidth(150);
        
	}
}
