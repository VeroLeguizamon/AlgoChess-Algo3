package tp2java.modelo.unidades;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;

public class SoldadoDeInfanteria extends UnidadMovible implements Atacante, Curable{
	
	private int poderDeAtaque;
	
	public SoldadoDeInfanteria(int jugador, Coordenada ubicacion, Tablero tablero) {
		
		super(100,1,jugador,ubicacion,tablero);
		this.poderDeAtaque = 10;
		
	}
	
	@Override
	public void atacar(Unidad unidad) { // Parámetro es la unidad a atacar.	
		unidad.perderVida(poderDeAtaque);
	}
	@Override
	public void recuperarVida(int vidaARecuperar) {
		setVida(this.getVida() + vidaARecuperar);
	}
}
