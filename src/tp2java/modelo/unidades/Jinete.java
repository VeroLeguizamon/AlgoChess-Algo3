package tp2java.modelo.unidades;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;

public class Jinete extends UnidadMovible implements Atacante, Curable {
	
	private int poderDeAtaque;
	private int poderDeAtaqueADistancia;
	
	public Jinete(int jugador, Coordenada ubicacion, Tablero tablero) {
		
		super(100,3,jugador,ubicacion,tablero);
		this.poderDeAtaque = 5;
		this.poderDeAtaqueADistancia = 15;
		
	}
	
	@Override
	public void atacar(Unidad unidad) { 
		// Tendra dos casos de ataque según las unidades en su proximidad.
		// Podrán ser ataqueCuerpoACuerpo(Unidad unidad) o ataqueADistancia(Unidad unidad).
	}
	
	public void ataqueCuerpoACuerpo(Unidad unidad) { // Será privado una vez implementado atacar.
		unidad.perderVida(poderDeAtaque);
	}
	
	public void ataqueADistancia(Unidad unidad) { // Será privado una vez implementado atacar.
		unidad.perderVida(poderDeAtaqueADistancia);
	}
	
	@Override
	public void recuperarVida(int vidaARecuperar) {
		setVida(this.getVida() + vidaARecuperar);
	}
}
