package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Unidad;
import vista.ContenedorJuego;
import vista.VistaCelda;

public class ResolverInteraccionesEventHandler implements EventHandler<ActionEvent> {

	private VistaCelda vistaCelda;
	private ContenedorJuego contenedorJuego;
	
	public ResolverInteraccionesEventHandler(VistaCelda vistaCelda, Tablero tablero, ContenedorJuego contenedorJuego,
			int x, int y) {
		
		this.vistaCelda = vistaCelda;
		this.contenedorJuego = contenedorJuego;
		
	}
		
	@Override
	public void handle(ActionEvent arg0) {

		if (!vistaCelda.estaVacia() && !contenedorJuego.getJugadorEnTurno().realizoAccion()){
			
			Unidad unidad = vistaCelda.getVistaUnidad().getUnidad();
			
			if(contenedorJuego.hayUnidadSeleccionada() && !contenedorJuego.esLaMismaUnidadSeleccionada(this.vistaCelda)) {
				try {
					contenedorJuego.getUnidadSeleccionada().getUnidad().interactuar(unidad);
				} catch (ObjetivoAliado e) {
					nuevaAlerta("Unidad aliada.","Por favor, selecciona una enemiga.","Un gran poder conlleva una gran responsabilidad");
					contenedorJuego.quitarBotonesMovimiento();
				}
				contenedorJuego.resetSeleccionado();
			} else if (vistaCelda.getVistaUnidad().getUnidad().getJugador() == contenedorJuego.getJugadorEnTurno()){
				contenedorJuego.setUnidadSeleccionada(vistaCelda.getVistaUnidad());
				if(unidad.sePuedeMover()) {
					contenedorJuego.prepararMovimiento(vistaCelda);
				}
			} else {
				nuevaAlerta("No es tu unidad!","Esa unidad no pertenece al jugador en turno.","Un gran poder conlleva una gran responsabilidad");
				contenedorJuego.quitarBotonesMovimiento();
			}
			
			if(contenedorJuego.getJugadorEnTurno().realizoAccion()) {
				contenedorJuego.quitarBotonesMovimiento();
				contenedorJuego.setBotonTerminarTurno();
			}
		}
		
	}
	
	public void nuevaAlerta(String titulo, String texto, String contenido) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titulo);
		alert.setHeaderText(texto);
		alert.setContentText(contenido);
		alert.showAndWait();
	}
	
}


