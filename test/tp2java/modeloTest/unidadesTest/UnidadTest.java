package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import org.junit.Test;

import tp2java.modelo.unidades.Unidad;
import tp2java.modelo.tablero.Coordenada;

import org.junit.Before;

public class UnidadTest {
	
	private Unidad unidad;
	
	@Before
	public void setUp() {
		unidad = new Unidad(20,5,1, new Coordenada(5,5));
	}
	
	@Test
	public void testUnidadCreadaCorrectamente() {
		
		assertEquals(unidad.getVida(), 20);
		assertEquals(unidad.getCosto(), 5);
		assertEquals(unidad.getSector(), 1);
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
	
	
	
	
	
	
	
	
}
