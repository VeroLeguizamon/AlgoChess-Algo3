package tp2java.modelo.unidades;

import tp2java.modelo.unidades.Atacante;
import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.Jugador;

public class SoldadoDeInfanteria extends UnidadMovible implements Atacante, Curable{
	
	private Ataque ataque;
	private static int distanciaMaximaAtaque = 3;
	private static int precio = 1;
	private static int poderAtaque = 10;
	
	public SoldadoDeInfanteria(Jugador jugador, Coordenada ubicacion, Tablero tablero) {
		
		super(100,precio,jugador,ubicacion,tablero);
		ataque = new Ataque(this,poderAtaque);
	}
	public SoldadoDeInfanteria(Jugador jugador) {
		super(100,precio,jugador);
		ataque = new Ataque(this,poderAtaque);
	}
	public SoldadoDeInfanteria() {
		super(100,precio);
		ataque = new Ataque(this,poderAtaque);
	}
	
	@Override
	public void interactuar(Unidad unidad) {
		atacar(unidad);
	}
	
	@Override
	public void atacar(Unidad unidad) throws ObjetivoAliado{ 
		if(distanciaA(unidad) < distanciaMaximaAtaque)
			ataque.a(unidad);
			
	}
	
	@Override
	public void recuperarVida(int vidaARecuperar) {
		setVida(this.getVida() + vidaARecuperar);
		notifyObservers();
	}
	
	@Override	
	public int distanciaACurandero(Curandero curandero) {
		return distanciaA(curandero);
	}
	
	@Override
	public boolean esSoldadoDeInfanteria() {
		return true;
	}
	@Override
	public boolean sePuedeUnirAlBatallon() {
		return true;
	}
	
	@Override
	public boolean esCurable() {
		return true;
	}
	
}
