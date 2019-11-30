package tp2java.modelo.unidades;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.Jugador;

public class Curandero extends UnidadMovible implements Curable {
	
	private int poderDeCuracion;
	
	public Curandero(Jugador jugador, Coordenada ubicacion, Tablero tablero) {
		
		super(75,2,jugador,ubicacion,tablero);
		this.poderDeCuracion = 15;
		
	}
	
	public Curandero(Jugador jugador) {
		
		super(75,2,jugador);
		this.poderDeCuracion = 15;
		
	}
	
	public Curandero() {
		super(75,2);
		this.poderDeCuracion = 15;
	}
	// Parámetro es la unidad a curar. 
	// Debe llamar al método recuperarVida de un Curable.
	
	@Override
	public void interactuar(Unidad unidad) {
		
		if(unidad.esCurable()) {
			curar((Curable)unidad);
			this.getJugador().realizoAccion();
		}
		
	}
	
	public void curar(Curable curable) { 
		
		if(curable.distanciaACurandero(this) < 3)
			curable.recuperarVida(poderDeCuracion);
		
	}

	@Override
	public void recuperarVida(int vidaARecuperar) {
		setVida(this.getVida() + vidaARecuperar);
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
