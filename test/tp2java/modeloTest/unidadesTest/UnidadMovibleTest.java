package tp2java.modeloTest.unidadesTest;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.UnidadMovible;

import tp2java.excepciones.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.Before;

public class UnidadMovibleTest {
	
	private UnidadMovible unidadM;
	private Tablero mockTablero;	
	
	@Before
	public void setUp() {
		
		mockTablero = mock(Tablero.class);
		unidadM = new UnidadMovible();
		doNothing().when(mockTablero).moverEntidad(anyObject(), anyObject());
		unidadM.setTablero(mockTablero);
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveHaciaCoordenadaIndicadaEnCeldaLibre(){
	
		unidadM.setUbicacion(new Coordenada(5,5));
		unidadM.moverA(new Coordenada(5,6));
		assertEquals(new Coordenada(5,6), unidadM.getUbicacion());
		
	}
	
	@Test(expected = CeldaNoAdyacenteExcepcion.class)
	public void testUnidadMovibleTiraErrorAlMoverseACeldaNoAdyacente(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		doThrow(new CeldaNoAdyacenteExcepcion()).when(mockTablero).moverEntidad(anyObject(), anyObject());
		unidadM.moverA(new Coordenada(8,8));
		
	}
	
	@Test(expected = CeldaEstaOcupadaExcepcion.class)
	public void testUnidadMovibleTiraErrorAlMoverseACeldaOcupada(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		doThrow(new CeldaEstaOcupadaExcepcion()).when(mockTablero).moverEntidad(anyObject(), anyObject());
		unidadM.moverA(new Coordenada(6,5));
		
	}
	
	@Test(expected = CeldaNoExisteExcepcion.class)
	public void testUnidadMovibleTiraErrorAlMoverseACeldaInvalida(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		doThrow(new CeldaNoExisteExcepcion()).when(mockTablero).moverEntidad(anyObject(), anyObject());
		unidadM.moverA(new Coordenada(8,8));
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveHaciaArriba(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		unidadM.moverHaciaArriba();
		assertEquals(new Coordenada(5,6), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveEnDiagonalArribaDerecha(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		unidadM.moverEnDiagonalArribaDerecha();
		assertEquals(new Coordenada(6,6), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveHaciaLaDerecha(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		unidadM.moverHaciaLaDerecha();
		assertEquals(new Coordenada(6,5), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveEnDiagonalAbajoDerecha(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		unidadM.moverEnDiagonalAbajoDerecha();
		assertEquals(new Coordenada(6,4), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveHaciaAbajo(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		unidadM.moverHaciaAbajo();
		assertEquals(new Coordenada(5,4), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveEnDiagonalAbajoIzquierda(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		unidadM.moverEnDiagonalAbajoIzquierda();
		assertEquals(new Coordenada(4,4), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveHaciaLaIzquierda(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		unidadM.moverHaciaLaIzquierda();
		assertEquals(new Coordenada(4,5), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveEnDiagonalArribaIzquierda(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		unidadM.moverEnDiagonalArribaIzquierda();
		assertEquals(new Coordenada(4,6), unidadM.getUbicacion());
		
	}
	
}
	