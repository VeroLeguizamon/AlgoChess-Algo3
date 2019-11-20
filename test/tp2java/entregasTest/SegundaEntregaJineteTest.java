package tp2java.entregasTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import tp2java.modelo.tablero.*;
import tp2java.modelo.*;
import tp2java.modelo.unidades.*;

public class SegundaEntregaJineteTest { 
	
	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	private Jinete jinete;
	private SoldadoDeInfanteria soldado1;
	private SoldadoDeInfanteria soldado2; 
	
	@Before
	public void setUp() {
		
		tablero = new Tablero();
		jugador1 = new Jugador("player1",0,9);
		jugador2 = new Jugador("player2",10,19);
		
		jinete = new Jinete(jugador1,new Coordenada(5,5),tablero);
		soldado1 = new SoldadoDeInfanteria(jugador2,new Coordenada(15,15),tablero);
		soldado2 = new SoldadoDeInfanteria(jugador2,new Coordenada(15,16),tablero);
		
		
	}
	
	@Test
	public void test01JineteSinAliadosEnDistanciaCortaYUnEnemigoCercanoAtacaConEspada() {
		
		soldado1.setJugador(jugador1); //Aliado
		tablero.colocarUnidad(jinete);
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);	
		soldado1.setUbicacion(new Coordenada(8,8)); // A distancia media.
		soldado2.setUbicacion(new Coordenada(6,5)); // Enemigo a distancia corta.
		
		jinete.atacar(soldado2);
		
		assertEquals(soldado2.getVida(), 95);
		
	}
	
	@Test
	public void test02JineteConUnEnemigoADistanciaMediaYSinEnemigosCercanosAtacaConArco() {
		
		tablero.colocarUnidad(jinete);
		tablero.colocarUnidad(soldado1);
		soldado1.setUbicacion(new Coordenada(8,8)); // Enemigo distancia media.
		
		jinete.atacar(soldado1);
		
		assertEquals(soldado1.getVida(), 85);
		
	}
	
	@Test
	public void test03JineteConUnEnemigoADistanciaMediaYUnEnemigoCercanoAtacaConArcoSiHayUnSoldadoAliadoCercano() {
		
		// Soldado aliado a distancia corta.
		SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(jugador1,new Coordenada(5,6),tablero);
		
		tablero.colocarUnidad(jinete);
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);
		tablero.colocarUnidad(soldado3);
		soldado1.setUbicacion(new Coordenada(8,8)); // Enemigo distancia media.
		soldado2.setUbicacion(new Coordenada(6,5)); // Enemigo a distancia corta.
		
		jinete.atacar(soldado1);
		
		assertEquals(soldado1.getVida(), 85);
		
	}
	
	@Test
	public void test04JineteConUnEnemigoADistanciaMediaYUnEnemigoCercanoNoPuedeAtacarADistancia() {
		
		tablero.colocarUnidad(jinete);
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);	
		soldado1.setUbicacion(new Coordenada(8,8)); // Enemigo distancia media.
		soldado2.setUbicacion(new Coordenada(6,5)); // Enemigo a distancia corta.
		
		jinete.atacar(soldado1);
		
		assertEquals(soldado1.getVida(), 100);
		
	}
	
}