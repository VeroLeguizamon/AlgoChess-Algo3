package tp2java.modelo.unidades;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.unidades.Atacante;

public class Catapulta extends Unidad implements Atacante {
	
	private int poderDeAtaque;
	
	public Catapulta(int jugador, Coordenada ubicacion) {
		
		super(50,5,jugador,ubicacion);
		this.poderDeAtaque = 20;
		
	}
	
	@Override 
	public void atacar(Unidad unidad) throws ObjetivoAliado{ // Parámetro es la unidad a atacar.	
		
		if(this.getSector() != unidad.getSector())
			unidad.perderVida(poderDeAtaque);
		else 
			throw (new ObjetivoAliado());
	}
	
}
