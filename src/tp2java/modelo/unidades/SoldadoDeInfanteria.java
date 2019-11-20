package tp2java.modelo.unidades;

import tp2java.modelo.unidades.Atacante;
import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.Jugador;

public class SoldadoDeInfanteria extends UnidadMovible implements Atacante, Curable{
	
	private Ataque ataque;
	
	public SoldadoDeInfanteria(Jugador jugador, Coordenada ubicacion, Tablero tablero) {
		
		super(100,1,jugador,ubicacion,tablero);
		ataque = new Ataque(this,10);
	}
	
	@Override
	public void atacar(Unidad unidad) throws ObjetivoAliado{ // Parámetro es la unidad a atacar.	
		
		if(distanciaA(unidad) < 3)
			ataque.a(unidad);
	}
	
	@Override
	public void recuperarVida(int vidaARecuperar) {
		setVida(this.getVida() + vidaARecuperar);
	}
	
	@Override	
	public int distanciaACurandero(Curandero curandero) {
		return distanciaA(curandero);
	}
	
}
