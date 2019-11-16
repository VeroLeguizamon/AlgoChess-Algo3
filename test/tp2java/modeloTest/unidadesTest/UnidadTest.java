package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import org.junit.Test;

import tp2java.modelo.unidades.Unidad;
import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;

import org.junit.Before;

public class UnidadTest {
	
	private Unidad unidad;
	
	@Before
	public void setUp() {
		unidad = new Unidad(20,5,new Coordenada(5,5));
	}
	
	@Test
	public void testUnidadCreadaCorrectamente() {
		
		assertEquals(unidad.getVida(), 20);
		assertEquals(unidad.getCosto(), 5);
		assertEquals(unidad.getUbicacion(), new Coordenada(5,5));
		
	}
	
	@Test
	public void testUnidadPierdeVidaCorrectamente() {
		
		unidad.perderVida(10);
		assertEquals(unidad.getVida(), 10);
		
	}
	
	@Test
	public void testUnidadPierdeVidaConPenalizadorCorrectamente() {
		
		unidad.setPenalizador(10);
		unidad.perderVida(10);
		assertEquals(unidad.getVida(), 9);		
		
	}
	
	@Test
	public void testUnidadRecienCreadaEstaViva() {
		
		assertTrue(unidad.tieneVida());
		
	}
	
	@Test	
	public void testUnidadPierdeVidaHastaMorir() {
		
		unidad.perderVida(5);
		
		assertTrue(unidad.tieneVida());
		
		unidad.perderVida(15);
		
		assertFalse(unidad.tieneVida());
		
		unidad.perderVida(5);		

		assertFalse(unidad.tieneVida());
		
	}
	
	@Test
	public void testUnidadDevuelveLaRestaALosPuntosDelJugador() {
		
		int puntosDelJugador = 20;
		
		assertEquals(unidad.restarPuntos(puntosDelJugador), 15);
		
		puntosDelJugador = 3;
		
		assertEquals(unidad.restarPuntos(puntosDelJugador), -2);
		
	}
	
	@Test
	public void testUnidadDeberiaDevolverTrueSiPerteneceAlMismoEquipo() {
		Unidad unidad2 = new Unidad(20,2,new Coordenada(5,4));
		Jugador jugador1 = new Jugador("player",0,9);
		
		unidad.setJugador(jugador1);
		unidad2.setJugador(jugador1);
		
		assertTrue(unidad.mismoEquipo(unidad2));
	}
	@Test
	public void testUnidadDeberiaDevolverFalseSiNoPerteneceAlMismoEquipo() {
		Unidad unidad2 = new Unidad(20,2,new Coordenada(5,4));
		Jugador jugador1 = new Jugador("player",0,9);
		Jugador jugador2 = new Jugador("play",10,19);
		unidad.setJugador(jugador1);
		unidad2.setJugador(jugador2);
		
		assertFalse(unidad.mismoEquipo(unidad2));
	}
	
}
