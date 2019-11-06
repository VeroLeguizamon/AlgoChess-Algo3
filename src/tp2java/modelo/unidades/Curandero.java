package tp2java.modelo.unidades;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;

public class Curandero extends UnidadMovible implements Curable {
	
	private int poderDeCuracion;
	
	public Curandero(int jugador, Coordenada ubicacion, Tablero tablero) {
		
		super(75,2,jugador,ubicacion,tablero);
		this.poderDeCuracion = 15;
		
	}

	@Override
	public void recuperarVida(int vidaARecuperar) {
		setVida(this.getVida() + vidaARecuperar);
	}
	
	// Parámetro es la unidad a curar. 
	// Debe llamar al método recuperarVida de un Curable.
	public void curar(Curable curable) { 
		curable.recuperarVida(poderDeCuracion);
	}
	
}
