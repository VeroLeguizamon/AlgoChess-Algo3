package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.unidades.Catapulta;

import static org.mockito.Mockito.*;

public class CatapultaTest {
	
	private Catapulta catapulta1;
	private Catapulta catapulta2;
	private Jugador mockJugador1;
	private Jugador mockJugador2;
	@Before
	public void setUp() {
		
		catapulta1 = new Catapulta(new Coordenada(2,2));
		catapulta2 = new Catapulta(new Coordenada(12,5));
		mockJugador1 = mock(Jugador.class);
		mockJugador2 = mock(Jugador.class);
		
		catapulta1.setJugador(mockJugador1);
		catapulta2.setJugador(mockJugador2);
	}
	
	@Test
	public void testCatapulta1AtacaACatapulta2YEstaUltimaPierdeVida() {
		
		catapulta1.atacar(catapulta2);
		assertEquals(catapulta2.getVida(),30);
		
	}
	
	@Test(expected = ObjetivoAliado.class)
	public void testCatapulta1IntentaAtacarACatapulta3PeroEsAliada() {
		
		Catapulta catapulta3 = new Catapulta(new Coordenada(10,14));
		catapulta3.setJugador(mockJugador1);
		catapulta1.atacar(catapulta3);
		
	}
	
	@Test
	public void testCatapulta1AtacaACatapulta2TresVecesYEstaUltimaMuere() {
		
		for(int i = 0; i < 10; i++)
			catapulta1.atacar(catapulta2);
		assertFalse(catapulta2.tieneVida());
		
	}
	
}
