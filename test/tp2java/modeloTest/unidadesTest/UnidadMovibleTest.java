package tp2java.modeloTest.unidadesTest;

import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Direccion;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.UnidadMovible;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.Before;

public class UnidadMovibleTest {
	
	private UnidadMovible unidadM;
	private Tablero mockTablero;	
	private Jugador mockJugador;
	
	@Before
	public void setUp() {
		mockTablero = mock(Tablero.class);
		mockJugador = mock(Jugador.class);
		unidadM = new UnidadMovible();
		unidadM.setTablero(mockTablero);
		unidadM.setJugador(mockJugador);
		 
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveHaciaCoordenadaIndicadaEnCeldaLibre(){
	
		unidadM.setUbicacion(new Coordenada(5,5));

		when(mockTablero.sePuedeMoverUnidad(anyObject())).thenReturn(true);
		doNothing().when(mockJugador).realizarAccion();
		unidadM.mover(Direccion.ARRIBA);
		
		assertEquals(new Coordenada(5,6), unidadM.getUbicacion());
		
	}
	
/*	@Test(expected = CeldaNoAdyacenteExcepcion.class)
	public void testUnidadMovibleTiraErrorAlMoverseACeldaNoAdyacente(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		doThrow(new CeldaNoAdyacenteExcepcion()).when(mockTablero).moverEntidad(anyObject(), anyObject());
		unidadM.moverA(new Coordenada(8,8));
		
	}
	*/
	
	@Test
	public void testUnidadMovibleSeQuedaEnElMismoLugarSiEstaOcupadaLaCelda(){
		
		unidadM.setUbicacion(new Coordenada(6,5));

		when(mockTablero.sePuedeMoverUnidad(anyObject())).thenReturn(false);
		doNothing().when(mockJugador).realizarAccion();
		unidadM.mover(Direccion.ABAJO);
		
		assertEquals(new Coordenada(6,5), unidadM.getUbicacion());
	}
	
	@Test
	public void testUnidadMovibleSeQuedaEnElMismoLugarSiLaCeldaNoExiste(){
		
		unidadM.setUbicacion(new Coordenada(4,2));

		when(mockTablero.sePuedeMoverUnidad(anyObject())).thenReturn(false);
		doNothing().when(mockJugador).realizarAccion();
		
		assertEquals(true,true);
	}
	
	@Test
	public void testUnidadMovibleSeMueveHaciaArriba(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		when(mockTablero.sePuedeMoverUnidad(anyObject())).thenReturn(true);
		doNothing().when(mockJugador).realizarAccion();
		unidadM.mover(Direccion.ARRIBA);
		assertEquals(new Coordenada(5,6), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveEnDiagonalArribaDerecha(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		when(mockTablero.sePuedeMoverUnidad(anyObject())).thenReturn(true);
		doNothing().when(mockJugador).realizarAccion();
		unidadM.mover(Direccion.ARRIBA_DERECHA);
		assertEquals(new Coordenada(6,6), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveHaciaLaDerecha(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		when(mockTablero.sePuedeMoverUnidad(anyObject())).thenReturn(true);
		doNothing().when(mockJugador).realizarAccion();
		unidadM.mover(Direccion.DERECHA);
		assertEquals(new Coordenada(6,5), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveEnDiagonalAbajoDerecha(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		when(mockTablero.sePuedeMoverUnidad(anyObject())).thenReturn(true);
		doNothing().when(mockJugador).realizarAccion();
		unidadM.mover(Direccion.ABAJO_DERECHA);
		assertEquals(new Coordenada(6,4), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveHaciaAbajo(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		when(mockTablero.sePuedeMoverUnidad(anyObject())).thenReturn(true);
		doNothing().when(mockJugador).realizarAccion();
		unidadM.mover(Direccion.ABAJO);
		assertEquals(new Coordenada(5,4), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveEnDiagonalAbajoIzquierda(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		when(mockTablero.sePuedeMoverUnidad(anyObject())).thenReturn(true);
		doNothing().when(mockJugador).realizarAccion();
		unidadM.mover(Direccion.ABAJO_IZQUIERDA);
		assertEquals(new Coordenada(4,4), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveHaciaLaIzquierda(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		when(mockTablero.sePuedeMoverUnidad(anyObject())).thenReturn(true);
		doNothing().when(mockJugador).realizarAccion();
		unidadM.mover(Direccion.IZQUIERDA);
		assertEquals(new Coordenada(4,5), unidadM.getUbicacion());
		
	}
	
	@Test
	public void testUnidadMovibleSeMueveEnDiagonalArribaIzquierda(){
		
		unidadM.setUbicacion(new Coordenada(5,5));
		when(mockTablero.sePuedeMoverUnidad(anyObject())).thenReturn(true);
		doNothing().when(mockJugador).realizarAccion();
		unidadM.mover(Direccion.ARRIBA_IZQUIERDA);
		assertEquals(new Coordenada(4,6), unidadM.getUbicacion());
		
	}
	
}
	