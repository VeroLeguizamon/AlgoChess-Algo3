package tp2java.vista;

import tp2java.modelo.Jugador;
import tp2java.modelo.Observer;

public class VistaJugador implements Observer{
	private Jugador jugador;
	private int puntos;
	private DatosJugador datos;
	
	VistaJugador(Jugador jugador){
		this.jugador = jugador;
		this.puntos = jugador.getPuntos();
		jugador.addObserver(this);
	}
	
	@Override
	public void change() {
		this.puntos = jugador.getPuntos();
		this.datos.cambiarPuntos();
	}

	public Jugador getJugador() {
		return this.jugador;
	}
	public int getPuntos() {
		return this.puntos;
	}

	public void setContenedor(DatosJugador datos) {
		this.datos = datos;
	}
}
