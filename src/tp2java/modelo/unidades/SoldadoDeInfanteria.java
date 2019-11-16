package tp2java.modelo.unidades;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;

public class SoldadoDeInfanteria extends UnidadMovible implements Atacante, Curable{
	
	private int poderDeAtaque;
	
	public SoldadoDeInfanteria(Coordenada ubicacion, Tablero tablero) {
		
		super(100,1,ubicacion,tablero);
		this.poderDeAtaque = 10;
		
	}
	
	@Override
	public void atacar(Unidad unidad) throws ObjetivoAliado{ // Parámetro es la unidad a atacar.	
		
		if(!this.mismoEquipo(unidad))
			unidad.perderVida(poderDeAtaque);
		else 
			throw (new ObjetivoAliado());
	}
	
	@Override
	public void recuperarVida(int vidaARecuperar) {
		setVida(this.getVida() + vidaARecuperar);
	}
}
