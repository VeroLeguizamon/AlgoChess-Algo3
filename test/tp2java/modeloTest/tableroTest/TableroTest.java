package tp2java.modeloTest.tableroTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Catapulta;
import tp2java.modelo.unidades.Unidad;


public class TableroTest {
	@Test
	public void test00TableroSeCreaSinUnidades(){
		Tablero tablero = new Tablero();
		assertEquals(tablero.cantUnidades(),0);
	}
	@Test
	public void test01TableroDevuelveFalseConCoordenadaFueraDeSuLimite() {
		Coordenada coordenada = new Coordenada(2,20);
		Tablero tablero = new Tablero();
		
		assertFalse(tablero.existeLaCelda(coordenada));	
	}
	@Test
	public void test02TableroDevuelveTrueConCoordenadaDentroDeSusLimites() {
		Coordenada coordenada = new Coordenada(2,2);
		Tablero tablero = new Tablero();
		
		assertTrue(tablero.existeLaCelda(coordenada));
	}
	//Test celda ocupada
	@Test 
	public void test03TableroDevuelveTrueSiLaCeldaEstaLibre() {
		Coordenada coordenada = new Coordenada(2,20);
		Tablero tablero = new Tablero();
		assertTrue(tablero.laCeldaEstaLibre(coordenada));
	}
	@Test
	public void test04TableroDevuelveFalseSiLaCeldaNoEstaLibre() {
		Coordenada coordenada = new Coordenada(2,0);
		Tablero tablero = new Tablero();
		
		Catapulta catapulta = new Catapulta(new Coordenada(2,0));
		catapulta.setJugador(new Jugador("player",0,9));
		tablero.colocarUnidad(catapulta);
		
		assertFalse(tablero.laCeldaEstaLibre(coordenada));
	}
	//Test puede moverse
	@Test
	public void test05DevuelveTrueSiLaUnidadSePuedeMover() {
		Tablero tablero = new Tablero();
		
		Catapulta catapulta = new Catapulta(new Coordenada(2,2));
		catapulta.setJugador(new Jugador("player",0,9));
		tablero.colocarUnidad(catapulta);
		
		assertTrue(tablero.sePuedeMoverUnidad(new Coordenada(2,1)));
	}
}