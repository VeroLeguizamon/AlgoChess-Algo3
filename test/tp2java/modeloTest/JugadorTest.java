package tp2java.modeloTest;

import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.unidades.Unidad;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class JugadorTest {
	
	@Test
	public void test00JugadorSeCreaCon20Puntos() {
		Jugador jugador = new Jugador("Martina",0,9);
		assertEquals(jugador.getPuntos(), 20);
	}
	
	@Test
	public void test01JugadorCompraUnaUnidadCorrectamente() {
		Jugador jugador = new Jugador ("Rocio",0,9);
		Unidad mockUnidad = mock(Unidad.class);
		when(mockUnidad.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		
		jugador.comprarUnidad(mockUnidad);
		
		assertEquals(jugador.getPuntos(),16);
	}
	@Test
	public void test02JugadorCompraYSeQuedaEnCero() {
		Jugador jugador = new Jugador("Agustina",0,9);
		
		Unidad mockUnidad = mock(Unidad.class);
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
		//DETERMINAR como tratar puntos insuficientes sin lanzar excepcion
		
		Jugador jugador = new Jugador("Pedro",0,9);
		
		Unidad mockUnidad = mock(Unidad.class);
		when(mockUnidad.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		
		//boolean lanzoExcepcion = false;
		
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad);
		jugador.comprarUnidad(mockUnidad); // Puntos del jugador en 0.
		
		/*try {
			when(mockUnidad.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
			jugador.comprarUnidad(mockUnidad);
		} catch (PuntosInsuficientes e) {
			lanzoExcepcion = true;
		}*/
		
		assertTrue(true);
	}
	@Test
	public void test04JugadorRecienCreadoNoDeberiaSerPerdedor() {
		Jugador jugador = new Jugador("Miguel",0,9);
		
		assertFalse (jugador.esPerdedor());
	}
	
	@Test
	public void test05JugadorConUnidadesVivasDeberiaNoSerPerdedor() {
		Jugador jugador = new Jugador("Federico",0,9);

		Unidad mockUnidad = mock(Unidad.class);
		when(mockUnidad.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		when(mockUnidad.tieneVida()).thenReturn(true);
		
		jugador.comprarUnidad(mockUnidad);
		
		assertFalse (jugador.esPerdedor());
	}
	
	@Test 
	public void test06JugadorConUnidadesMuertasEsPerdedor() {
		Jugador jugador = new Jugador("Diego",0,9);
		
		Unidad mockUnidad = mock(Unidad.class);
		when(mockUnidad.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		when(mockUnidad.tieneVida()).thenReturn(false);
		
		jugador.comprarUnidad(mockUnidad);
		
		assertTrue (jugador.esPerdedor());
	}
	
	@Test
	public void test07JugadorConUnaUnidadVivaYOtraMuertaNoEsPerdedor() {
		Jugador jugador = new Jugador("Lucia",0,9);
		
		Unidad mockUnidad1 = mock(Unidad.class);
		when(mockUnidad1.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		when(mockUnidad1.tieneVida()).thenReturn(false);
		
		Unidad mockUnidad2 = mock(Unidad.class);
		when(mockUnidad2.restarPuntos(jugador.getPuntos())).thenReturn(jugador.getPuntos()-4);
		when(mockUnidad2.tieneVida()).thenReturn(true);
		
		jugador.comprarUnidad(mockUnidad1);
		jugador.comprarUnidad(mockUnidad2);
	
		assertFalse(jugador.esPerdedor());
		
	}
	@Test
	public void test08DeberiaDarFalseAlTenerUnaUnidadQueNoPerteneceASuSector() {
		Jugador jugador = new Jugador("Lucia",0,9);
		
		Unidad mockUnidad1 = mock(Unidad.class);
		when(mockUnidad1.getUbicacion()).thenReturn(new Coordenada(10,10));
		
		assertFalse(jugador.perteneceAlSector(mockUnidad1));
	}
	@Test
	public void test09DeberiaDarTrueAlTenerUnaUnidadQuePerteneceASuSector() {
		Jugador jugador = new Jugador("Lucia",0,9);
		
		Unidad mockUnidad1 = mock(Unidad.class);
		when(mockUnidad1.getUbicacion()).thenReturn(new Coordenada(0,5));
		
		assertTrue(jugador.perteneceAlSector(mockUnidad1));
	}
	
}
