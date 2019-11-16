package tp2java.modelo.unidades;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;

public class Jinete extends UnidadMovible implements Atacante, Curable {
	
	private int poderDeAtaque;
	private int poderDeAtaqueADistancia;
	
	public Jinete(Coordenada ubicacion, Tablero tablero) {
		
		super(100,3,ubicacion,tablero);
		this.poderDeAtaque = 5;
		this.poderDeAtaqueADistancia = 15;
		
	}
	
	@Override
	public void atacar(Unidad unidad) throws ObjetivoAliado{ 
		// Tendra dos casos de ataque según las unidades en su proximidad.
		// Podrán ser ataqueCuerpoACuerpo(Unidad unidad) o ataqueADistancia(Unidad unidad).
	}
	
	public void ataqueCuerpoACuerpo(Unidad unidad) throws ObjetivoAliado{ // Parámetro es la unidad a atacar cuerpo a cuerpo.	
		
		if(!this.mismoEquipo(unidad))
			unidad.perderVida(poderDeAtaque);
		else 
			throw (new ObjetivoAliado());
	}
	
	public void ataqueADistancia(Unidad unidad) throws ObjetivoAliado{ // Parámetro es la unidad a atacar a distancia.
		if(this.mismoEquipo(unidad)) throw (new ObjetivoAliado());
		unidad.perderVida(poderDeAtaqueADistancia);
	}
	
	@Override
	public void recuperarVida(int vidaARecuperar) {
		setVida(this.getVida() + vidaARecuperar);
	}
}
