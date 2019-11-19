package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

import tp2java.modelo.unidades.Unidad;
import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;

import org.junit.Before;

public class UnidadTest {
	
	private Unidad unidad;
	private Unidad unidad2;
	private Tablero mockTablero;
	private Jugador jugador1;
	private Jugador jugador2;
	
	@Before
	public void setUp() {
		
		mockTablero = mock(Tablero.class);
		jugador1 = new Jugador("player",0,9);
		jugador2 = new Jugador("play",10,19);
		unidad = new Unidad(20,5,jugador1,new Coordenada(5,5),mockTablero);
		unidad2 = new Unidad(20,2,jugador2,new Coordenada(5,4),mockTablero);
		unidad.setJugador(jugador1);
		unidad2.setJugador(jugador2);
		
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
	
		unidad2.setJugador(jugador1);
		assertTrue(unidad.mismoEquipo(unidad2));
		
	}
	@Test
	public void testUnidadDeberiaDevolverFalseSiNoPerteneceAlMismoEquipo() {
		
		assertFalse(unidad.mismoEquipo(unidad2));
		
	}
	
}
