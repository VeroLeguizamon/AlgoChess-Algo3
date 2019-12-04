package tp2java.modelo.unidades;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.Jugador;

public class Curandero extends UnidadMovible implements Curable {

	private static int distanciaMaximaCuracion = 3;
	private static int precio = 2;
	private static int poderDeCuracion = 15;
	
	public Curandero(Jugador jugador, Coordenada ubicacion, Tablero tablero) {
		super(75,precio,jugador,ubicacion,tablero);
	}
	
	public Curandero(Jugador jugador) {
		super(75,precio,jugador);
	}
	
	public Curandero() {
		super(75,precio);
	}
	
	@Override
	public void interactuar(Unidad unidad) {
		
		if(unidad.esCurable()) {
			curar((Curable)unidad);
		}
		
	}
	
	public void curar(Curable curable) { 

		if(curable.distanciaACurandero(this) < distanciaMaximaCuracion) {
			curable.recuperarVida(poderDeCuracion);
			this.getJugador().realizarAccion();
		}
		
	}

	@Override
	public void recuperarVida(int vidaARecuperar) {
		setVida(this.getVida() + vidaARecuperar);
		notifyObservers();
	}
	
	@Override	
	public int distanciaACurandero(Curandero curandero) {
		return distanciaA(curandero);
	}
	
	@Override
	public boolean esCurable() {
		return true;
	}
	
}
