package tp2java.modelo.unidades;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.unidades.Atacante;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.Jugador;

public class Catapulta extends Unidad implements Atacante {
	
	private Ataque ataque;
	
	public Catapulta(Jugador jugador, Coordenada ubicacion, Tablero tablero) {
		
		super(50,5,jugador,ubicacion,tablero);
		this.ataque = new Ataque(this,20);
		
	}
	
	@Override 
	public void atacar(Unidad unidad) throws ObjetivoAliado{ // Parámetro es la unidad a atacar.	
		
		
		
		if(distanciaA(unidad) > 6)
			ataque.a(unidad);
		
		
		//Implementar daño en cadena.
		
	}
	
}
