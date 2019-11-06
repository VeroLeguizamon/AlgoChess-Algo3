package tp2java.modeloTest;

import tp2java.modelo.Jugador;
import tp2java.excepciones.PuntosInsuficientes;
import tp2java.modelo.interfaces.IEntidad;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class JugadorTest {
	
	@Test
	public void test00JugadorSeCreaCon20Puntos() {
		Jugador jugador = new Jugador("Martina");
		assertEquals(jugador.getPuntos(), 20);
	}
	
	@Test
	public void test01JugadorCompraUnaUnidadCorrectamente() {
		Jugador jugador = new Jugador ("Rocio");
		IEntidad mockUnidad = mock(IEntidad.class);
		when(mockUnidad.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		
		jugador.comprarUnidad(mockUnidad);
		
		assertEquals(jugador.getPuntos(),16);
	}
	@Test
	public void test02JugadorCompraYSeQuedaEnCero() {
		Jugador jugador = new Jugador("Agustina");
		
		IEntidad mockUnidad = mock(IEntidad.class);
		when(mockUnidad.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
	
		
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad);
		
		assertEquals(jugador.getPuntos(),0);
	}
	@Test
	public void test03JugadorNoPuedeComprarMasSiNoTieneSaldo() {
		Jugador jugador = new Jugador("Pedro");
		
		IEntidad mockUnidad = mock(IEntidad.class);
		when(mockUnidad.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		
		boolean lanzoExcepcion = false;
		
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad); // Puntos del jugador en 0.
		
		try {
			when(mockUnidad.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
			jugador.comprarUnidad(mockUnidad);
		} catch (PuntosInsuficientes e) {
			lanzoExcepcion = true;
		}
		assertTrue(lanzoExcepcion);
	}
	@Test
	public void test04JugadorRecienCreadoNoDeberiaSerPerdedor() {
		Jugador jugador = new Jugador("Miguel");
		
		assertFalse (jugador.esPerdedor());
	}
	
	@Test
	public void test05JugadorConUnidadesVivasDeberiaNoSerPerdedor() {
		Jugador jugador = new Jugador("Federico");

		IEntidad mockUnidad = mock(IEntidad.class);
		when(mockUnidad.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		when(mockUnidad.tieneVida()).thenReturn(true);
		
		jugador.comprarUnidad(mockUnidad);
		
		assertFalse (jugador.esPerdedor());
	}
	
	@Test 
	public void test06JugadorConUnidadesMuertasEsPerdedor() {
		Jugador jugador = new Jugador("Diego");
		
		IEntidad mockUnidad = mock(IEntidad.class);
		when(mockUnidad.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		when(mockUnidad.tieneVida()).thenReturn(false);
		
		jugador.comprarUnidad(mockUnidad);
		
		assertTrue (jugador.esPerdedor());
	}
	
	@Test
	public void test07JugadorConUnaUnidadVivaYOtraMuertaNoEsPerdedor() {
		Jugador jugador = new Jugador("Lucia");
		
		IEntidad mockUnidad1 = mock(IEntidad.class);
		when(mockUnidad1.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		when(mockUnidad1.tieneVida()).thenReturn(false);
		
		IEntidad mockUnidad2 = mock(IEntidad.class);
		when(mockUnidad2.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		when(mockUnidad2.tieneVida()).thenReturn(true);
		
		jugador.comprarUnidad(mockUnidad1);
		jugador.comprarUnidad(mockUnidad2);
	
		assertFalse(jugador.esPerdedor());
		
	}
	
	
	
}
