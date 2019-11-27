package tp2java.modelo.unidades;

import java.util.ArrayList;
import java.util.Iterator;

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
	public Jinete() {
		super(10,3);
		ataqueConEspada = new Ataque(this,5);
		ataqueConArco = new Ataque(this,15);
	}
	@Override
	public void atacar(Unidad unidad) throws ObjetivoAliado{ 
		
		int distancia = distanciaA(unidad);

		ArrayList<Unidad> unidadesCercanas = getTablero().unidadesCercanas(this, 2);
		
		if((distancia > 2 && distancia < 6) && (!tieneEnemigoCercano(unidadesCercanas) || tieneSoldadoAliadoCercano(unidadesCercanas)))
			ataqueConArco.a(unidad);
		else if(distancia < 3)
			ataqueConEspada.a(unidad);
		
	}
	
	public boolean tieneEnemigoCercano(ArrayList<Unidad> unidadesCercanas) {		

		Iterator<Unidad> actual = unidadesCercanas.iterator();		
		boolean contieneUnidadEnemiga = false;
		
		while(actual.hasNext() && contieneUnidadEnemiga == false) {
			Unidad unidadActual = actual.next();
			if(unidadActual.esEnemiga(this)) {
				contieneUnidadEnemiga = true;
			}
		}
		
		return contieneUnidadEnemiga;
		
	}
	
	
	public boolean tieneSoldadoAliadoCercano(ArrayList<Unidad> unidadesCercanas) {
		
		Iterator<Unidad> actual = unidadesCercanas.iterator();
		boolean contieneSoldadoAliado = false;
		
		while(actual.hasNext() && contieneSoldadoAliado == false) {
			Unidad unidadActual = actual.next();
			if(unidadActual.mismoEquipo(this) && unidadActual.esSoldadoDeInfanteria()) {
				contieneSoldadoAliado = true;
			}
		}
		
		return contieneSoldadoAliado;
		
	}
	
	@Override
	public void recuperarVida(int vidaARecuperar) {
		setVida(this.getVida() + vidaARecuperar);
	}
	
	@Override	
	public int distanciaACurandero(Curandero curandero) {
		return distanciaA(curandero);
	}
	@Override
	public Unidad crearUnidad() {
		return new Jinete();
	}
}
