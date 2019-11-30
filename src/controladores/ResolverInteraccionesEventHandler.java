package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Unidad;
import tp2java.modelo.unidades.UnidadMovible;
import vista.ContenedorJuego;
import vista.VistaCelda;

public class ResolverInteraccionesEventHandler implements EventHandler<ActionEvent> {

	private VistaCelda vistaCelda;
	private Tablero tablero;
	private ContenedorJuego contenedorJuego;
	private int x;
	private int y;
	
	public ResolverInteraccionesEventHandler(VistaCelda vistaCelda, Tablero tablero, ContenedorJuego contenedorJuego,
			int x, int y) {
		this.vistaCelda = vistaCelda;
		this.tablero = tablero;
		this.contenedorJuego = contenedorJuego;
		this.x = x;
		this.y = y;
		
	}
		
	@Override
	public void handle(ActionEvent arg0) {
		
		if (vistaCelda.getVistaUnidad() != null){
			Unidad unidad = vistaCelda.getVistaUnidad().getUnidad();
			if(contenedorJuego.hayUnidadSeleccionada() && (vistaCelda.getVistaUnidad() != contenedorJuego.getUnidadSeleccionada())) {
				contenedorJuego.getUnidadSeleccionada().getUnidad().interactuar(unidad);
				contenedorJuego.resetSeleccionado();
			} else {
				contenedorJuego.setUnidadSeleccionada(vistaCelda.getVistaUnidad());
				if(unidad.sePuedeMover()) {
					contenedorJuego.prepararMovimiento(vistaCelda);
			}
			}			
		}
		
	}
	
}


