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

	private static int distanciaMinimaArco = 2;
	private static int distanciaMaximaArco = 6;
	private static int distanciaMaximaEspada = 3;
	private static int precio = 3;
	private static int poderAtaqueEspada = 5;
	private static int poderAtaqueArco = 15;
	
	public Jinete(Jugador jugador, Coordenada ubicacion, Tablero tablero) {
		
		super(100,precio,jugador,ubicacion,tablero);
		ataqueConEspada = new Ataque(this,poderAtaqueEspada);
		ataqueConArco = new Ataque(this,poderAtaqueArco);
		
	}
	public Jinete(Jugador jugador) {
		super(100,precio,jugador);
		ataqueConEspada = new Ataque(this,poderAtaqueEspada);
		ataqueConArco = new Ataque(this,poderAtaqueArco);
	}
	
	public Jinete() {
		super(100,precio);
		ataqueConEspada = new Ataque(this,poderAtaqueEspada);
		ataqueConArco = new Ataque(this,poderAtaqueArco);
	}
	
	@Override
	public void interactuar(Unidad unidad) {
		atacar(unidad);
	}
	@Override
	public boolean puedoInteractuar(Unidad unidad) {
		int distancia = distanciaA(unidad);
		return (this.cumpleCondicionesParaAtaqueEspada(distancia)|| this.cumpleCondicionesParaUnAtaqueConArco(unidad, distancia));
	}
	
	private boolean cumpleCondicionesParaUnAtaqueConArco(Unidad unidad, int distancia) {
		int distanciaCercana = 2;
		ArrayList<Unidad> unidadesCercanas = getTablero().unidadesCercanas(this, distanciaCercana);
		return (distancia > distanciaMinimaArco && distancia < distanciaMaximaArco) && (!tieneEnemigoCercano(unidadesCercanas) || tieneSoldadoAliadoCercano(unidadesCercanas));
	}
	private boolean cumpleCondicionesParaAtaqueEspada(int distancia) {
		return (distancia < distanciaMaximaEspada);
	}
	
	@Override
	public void atacar(Unidad unidad) throws ObjetivoAliado{ 
		int distancia = distanciaA(unidad);
		
		if(this.cumpleCondicionesParaUnAtaqueConArco(unidad, distancia))
			ataqueConArco.a(unidad);
		else if(this.cumpleCondicionesParaAtaqueEspada(distancia))
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
		notifyObservers();
	}
	
	@Override	
	public int distanciaACurandero(Curandero curandero) {
		return distanciaA(curandero);
	}
	
	@Override
	public boolean esCurable() {
		return true;
	}
}
