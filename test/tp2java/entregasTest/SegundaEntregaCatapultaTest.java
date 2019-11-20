package tp2java.entregasTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import tp2java.modelo.tablero.*;
import tp2java.modelo.*;
import tp2java.modelo.unidades.*;


public class SegundaEntregaCatapultaTest {
		
	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	private Catapulta catapulta1;
	private Jinete jinete1;
	private Jinete jinete2;
	private SoldadoDeInfanteria soldado1;
	private SoldadoDeInfanteria soldado2;
	private Curandero curandero;
	private Catapulta catapulta2;
	
	@Before
	public void setUp() {
		
		tablero = new Tablero();
		jugador1 = new Jugador("player1",0,9);
		jugador2 = new Jugador("player2",10,19);
		
		catapulta1 = new Catapulta(jugador1,new Coordenada(2,2),tablero);
		
		jinete1 = new Jinete(jugador2,new Coordenada(12,12),tablero);
		jinete2 = new Jinete(jugador2,new Coordenada(13,13),tablero);
		soldado1 = new SoldadoDeInfanteria(jugador2,new Coordenada(14,14),tablero);
		soldado2 = new SoldadoDeInfanteria(jugador2,new Coordenada(14,15),tablero);
		curandero = new Curandero(jugador2,new Coordenada(14,16),tablero);
		catapulta2 = new Catapulta(jugador2,new Coordenada(15,15),tablero);
		
	}
	
	@Test
	public void test01CatapultaAtacaAUnaUnidadYTodasSusContiguasSeVenAfectadasPorElAtaque() {
		
		tablero.colocarUnidad(catapulta1);
		tablero.colocarUnidad(jinete1);
		tablero.colocarUnidad(jinete2);
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);
		tablero.colocarUnidad(curandero);
		tablero.colocarUnidad(catapulta2);
		
		catapulta1.atacar(jinete2);
		
		assertEquals(jinete1.getVida(), 80);
		assertEquals(jinete2.getVida(), 80);
		assertEquals(soldado1.getVida(), 80);
		assertEquals(soldado2.getVida(), 80);
		assertEquals(curandero.getVida(), 55);
		assertEquals(catapulta2.getVida(), 30);
		
	}
	
	@Test
	public void test02LaCadenaDeUnidadesAfectadasPorElAtaqueDeCatapultaSeCortaDondeNoHayMasAdyacentes() {
		
		soldado1.setUbicacion(new Coordenada(12,11)); // Cambio de lugar un soldado para que se corte la cadena del ataque.
		
		tablero.colocarUnidad(catapulta1);
		tablero.colocarUnidad(jinete1);
		tablero.colocarUnidad(jinete2);
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);
		tablero.colocarUnidad(curandero);
		tablero.colocarUnidad(catapulta2);
		
		catapulta1.atacar(jinete2);
		
		assertEquals(jinete1.getVida(), 80);
		assertEquals(jinete2.getVida(), 80);
		assertEquals(soldado1.getVida(), 80);
		assertEquals(soldado2.getVida(), 100);
		assertEquals(curandero.getVida(), 75);
		assertEquals(catapulta2.getVida(), 50);
		
	}
	
}
