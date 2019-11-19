package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Catapulta;

import static org.mockito.Mockito.*;

public class CatapultaTest {
	
	private Catapulta catapulta1;
	private Catapulta catapulta2;
	private Jugador mockJugador1;
	private Jugador mockJugador2;
	private Tablero mockTablero;
	
	@Before
	public void setUp() {
		
		mockJugador1 = mock(Jugador.class);
		mockJugador2 = mock(Jugador.class);
		mockTablero = mock(Tablero.class);
		when(mockJugador2.perteneceAlSector(anyObject())).thenReturn(true);
		catapulta1 = new Catapulta(mockJugador1, new Coordenada(2,2), mockTablero);
		catapulta2 = new Catapulta(mockJugador2, new Coordenada(12,17), mockTablero);
		
	}
	
	@Test
	public void testCatapulta1AtacaACatapulta2YEstaUltimaPierdeVida() {
		
		catapulta1.atacar(catapulta2);
		assertEquals(catapulta2.getVida(),30);
		
	}
	
	@Test(expected = ObjetivoAliado.class)
	public void testCatapulta1IntentaAtacarACatapulta3PeroEsAliada() {
		
		Catapulta catapulta3 = new Catapulta(mockJugador1,new Coordenada(10,14),mockTablero);
		catapulta1.atacar(catapulta3);
		
	}
	
	@Test
	public void testCatapulta1AtacaACatapulta2TresVecesYEstaUltimaMuere() {
		
		for(int i = 0; i < 10; i++)
			catapulta1.atacar(catapulta2);
		assertFalse(catapulta2.tieneVida());
		
	}
	
}
