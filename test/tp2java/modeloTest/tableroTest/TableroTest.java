package tp2java.modeloTest.tableroTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Catapulta;
import tp2java.modelo.unidades.Unidad;


public class TableroTest {
	
	private Tablero tablero;
	private Jugador jugador;
	
	@Before
	public void setUp() {

		tablero = new Tablero();
		jugador = new Jugador("player",0,9);
		
	}
	
	@Test
	public void test00TableroSeCreaSinUnidades(){
		assertEquals(tablero.cantUnidades(),0);
	}
	@Test
	public void test01TableroDevuelveFalseConCoordenadaFueraDeSuLimite() {
		Coordenada coordenada = new Coordenada(2,20);
		assertFalse(tablero.existeLaCelda(coordenada));	
	}
	@Test
	public void test02TableroDevuelveTrueConCoordenadaDentroDeSusLimites() {
		Coordenada coordenada = new Coordenada(2,2);
		assertTrue(tablero.existeLaCelda(coordenada));
	}
	//Test celda ocupada
	@Test 
	public void test03TableroDevuelveTrueSiLaCeldaEstaLibre() {
		Coordenada coordenada = new Coordenada(2,20);
		assertTrue(tablero.laCeldaEstaLibre(coordenada));
	}
	@Test
	public void test04TableroDevuelveFalseSiLaCeldaNoEstaLibre() {
		Coordenada coordenada = new Coordenada(2,0);
		
		Catapulta catapulta = new Catapulta(jugador,new Coordenada(2,0),tablero);
		tablero.colocarUnidad(catapulta);
		
		assertFalse(tablero.laCeldaEstaLibre(coordenada));
	}
	//Test puede moverse
	@Test
	public void test05DevuelveTrueSiLaUnidadSePuedeMover() {
		
		Catapulta catapulta = new Catapulta(jugador,new Coordenada(2,2),tablero);
		catapulta.setJugador(new Jugador("player",0,9));
		tablero.colocarUnidad(catapulta);
		
		assertTrue(tablero.sePuedeMoverUnidad(new Coordenada(2,1)));
	}
	@Test
	public void test06SiUnaUnidadEstaMuertaSeMuedeColocarLaUnidad() {
		Unidad unidad = new Unidad(20,5,new Jugador("player",0,9),new Coordenada(5,5),tablero);
		Unidad unidad2 = new Unidad(20,5,new Jugador("player",0,9),new Coordenada(5,4),tablero);
		tablero.colocarUnidad(unidad2);
		tablero.colocarUnidad(unidad);
		unidad.perderVida(20);
		
		assertTrue(tablero.laCeldaEstaLibre(new Coordenada(5,5)));
		assertEquals(1,tablero.cantUnidades());
		
	}
}