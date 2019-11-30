package vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import tp2java.modelo.Observer;
import tp2java.modelo.unidades.Unidad;

public class VistaUnidad extends Button implements Observer{
	
	private Unidad unidad;
	private VistaTablero tablero;
	private String rutaImagen;
	
	public VistaUnidad(VistaTablero tablero, Unidad unidad) {
		
		super();
		this.tablero = tablero;
		this.unidad = unidad;
		rutaImagen = ("file:src/vista/imagenes/" + unidad.getClass().getSimpleName() + ".png");
		Image unidadImagen = new Image(rutaImagen,32,32,false,true);
		
		BackgroundImage vistaUnidad =new BackgroundImage(unidadImagen, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
       
		this.unidad.addObserver(this);
				
        this.setBackground(new Background(vistaUnidad));
        this.setMinHeight(32);
        this.setMinWidth(32);      
	}
	
	public String getRutaImagen() {
		return rutaImagen;
	}
	
	@Override
	public void change() {
		if(unidad.tieneVida()) {
			tablero.colocarVista(this, unidad.getUbicacion().getCoordx(), unidad.getUbicacion().getCoordy());
			System.out.print("a");
		}
		 
	}
	public Unidad getUnidad() {
		return this.unidad;
	}
}
