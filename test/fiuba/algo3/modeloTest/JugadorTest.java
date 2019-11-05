package fiuba.algo3.modeloTest;

import fiuba.algo3.mock.MockUnidad;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepciones.PuntosInsuficientes;

import static org.junit.Assert.*;

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
		MockUnidad unidad = new MockUnidad();
		
		jugador.comprarUnidad(unidad);
		
		assertEquals(jugador.getPuntos(),16);
	}
	@Test
	public void test02JugadorCompraYSeQuedaEnCero() {
		Jugador jugador = new Jugador("Agustina");
		MockUnidad unidad = new MockUnidad();
		
		jugador.comprarUnidad(unidad);
		jugador.comprarUnidad(unidad);
		jugador.comprarUnidad(unidad);
		jugador.comprarUnidad(unidad);
		jugador.comprarUnidad(unidad);
		
		assertEquals(jugador.getPuntos(),0);
	}
	@Test
	public void test03JugadorNoPuedeComprarMasSiNoTieneSaldo() {
		Jugador jugador = new Jugador("Pedro");
		MockUnidad unidad = new MockUnidad();
		boolean lanzoExcepcion = false;
		
		jugador.comprarUnidad(unidad);
		jugador.comprarUnidad(unidad);
		jugador.comprarUnidad(unidad);
		jugador.comprarUnidad(unidad);
		jugador.comprarUnidad(unidad); // Puntos del jugador en 0.
		
		try {
			jugador.comprarUnidad(unidad);
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
		MockUnidad unidad = new MockUnidad();
		
		jugador.comprarUnidad(unidad);
		
		assertFalse (jugador.esPerdedor());
	}
	@Test 
	public void test06JugadorConUnidadesMuertasEsPerdedor() {
		Jugador jugador = new Jugador("Diego");
		MockUnidad unidad = new MockUnidad();
		unidad.matar();
		
		jugador.comprarUnidad(unidad);
		
		assertTrue (jugador.esPerdedor());
	}
	@Test
	public void test07JugadorConUnaUnidadVivaYOtraMuertaNoEsPerdedor() {
		Jugador jugador = new Jugador("Lucia");
		MockUnidad unidad1 = new MockUnidad();
		MockUnidad unidad2 = new MockUnidad();

		unidad1.matar();
		
		jugador.comprarUnidad(unidad1);
		jugador.comprarUnidad(unidad2);
		
		assertFalse(jugador.esPerdedor());
		
	}
	
	
	
}
