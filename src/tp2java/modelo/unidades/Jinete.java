package tp2java.modelo.unidades;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.Jugador;

public class Jinete extends UnidadMovible implements Atacante, Curable {
	
	private Ataque ataqueConEspada;
	private Ataque ataqueConArco;
	
	public Jinete(Jugador jugador, Coordenada ubicacion, Tablero tablero) {
		
		super(100,3,jugador,ubicacion,tablero);
		ataqueConEspada = new Ataque(this,5);
		ataqueConArco = new Ataque(this,15);
		
	}
	
	@Override
	public void atacar(Unidad unidad) throws ObjetivoAliado{ 
		
		int distancia = distanciaA(unidad);
		
		if((distancia > 2 && distancia < 6) && (!tieneEnemigoCercano() || tieneSoldadoAliadoCercano()))
			ataqueConArco.a(unidad);
		else if(distancia < 3)
			ataqueConEspada.a(unidad);
		
	}
	
	//Por ahora tablero devuelve un boolean, podría utilizarse otro método que devuelva
	//las unidades cercanas y luego se verifique si se cumple la condición.
	private boolean tieneEnemigoCercano() {
		return getTablero().tieneEnemigosCercanos(this);
	}
	
	//Idem al comentario anterior.
	private boolean tieneSoldadoAliadoCercano() {
		return getTablero().tieneSoldadoAliadoCercano(this);
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
