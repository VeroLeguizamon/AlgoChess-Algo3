package fiuba.algo3.modeloTest.unidadesTest;

import fiuba.algo3.modelo.unidades.UnidadMovible;
import tp2java_v1.tablero.Coordenada;
import tp2java_v1.tablero.Tablero;

import static org.junit.Assert.*;
import fiuba.algo3.modelo.excepciones.*;
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
		doNothing().when(mockTablero).moverUnidad(anyObject(), anyObject());
		unidadM.setTablero(mockTablero);
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveHaciaCoordenadaIndicadaEnCeldaLibre(){
	
		unidadM.setUbicacion(new Coordenada(5,5));
		unidadM.moverA(new Coordenada(5,6));
		assertEquals(new Coordenada(5,6), unidadM.getUbicacion());
		
	}
	
	@Test(expected = CeldaNoAdyacente.class)
	public void testUnidadMovibleTiraErrorAlMoverseACeldaNoAdyacente(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		doThrow(new CeldaNoAdyacente()).when(mockTablero).moverUnidad(anyObject(), anyObject());
		unidadM.moverA(new Coordenada(8,8));
		
	}
	
	@Test(expected = CeldaOcupada.class)
	public void testUnidadMovibleTiraErrorAlMoverseACeldaOcupada(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		doThrow(new CeldaOcupada()).when(mockTablero).moverUnidad(anyObject(), anyObject());
		unidadM.moverA(new Coordenada(6,5));
		
	}
	
	@Test(expected = CeldaInvalida.class)
	public void testUnidadMovibleTiraErrorAlMoverseACeldaInvalida(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		doThrow(new CeldaInvalida()).when(mockTablero).moverUnidad(anyObject(), anyObject());
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
	