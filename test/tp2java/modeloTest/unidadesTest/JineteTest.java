package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.Before;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Jinete;

public class JineteTest {
	
	private Jinete jinete1;
	private Jinete jinete2;
	private Jinete jinete3;
	private Tablero mockTablero;
	private Jugador jugador1 = new Jugador("pl",0,9);
	private Jugador jugador2 = new Jugador("player",10,9);
	
	@Before
	public void setUp() {
		
		mockTablero = mock(Tablero.class);
		jinete1 = new Jinete(new Coordenada(2,2),mockTablero);
		jinete1.setJugador(jugador1);
		jinete2 = new Jinete(new Coordenada(4,2),mockTablero);
		jinete2.setJugador(jugador2);
		jinete3 = new Jinete(new Coordenada(3,2),mockTablero);
		jinete3.setJugador(jugador1);
	}
	
	@Test
	public void testJinete1AtacaAJinete2CuerpoACuerpoYEsteUltimoPierdeVida() {
		
		jinete1.ataqueCuerpoACuerpo(jinete2);
		assertEquals(jinete2.getVida(),95);
		
	}
	
	@Test(expected = ObjetivoAliado.class)
	public void testJinete1IntentaAtacarAJinete3CuerpoACuerpoPeroEsAliado() {
		
		jinete1.ataqueCuerpoACuerpo(jinete3);
		
	}
	
	@Test
	public void testJinete1AtacaAJinete2CuerpoACuerpoVeinteVecesYEsteUltimoMuere() {
		
		for(int i = 0; i < 20; i++)
			jinete1.ataqueCuerpoACuerpo(jinete2);
		assertFalse(jinete2.tieneVida());
		
	}
	
	@Test
	public void testJinete1AtacaAJinete2ADistanciaYEsteUltimoPierdeVida() {
		
		jinete1.ataqueADistancia(jinete2);
		assertEquals(jinete2.getVida(),85);
		
	}
	
	@Test(expected = ObjetivoAliado.class)
	public void testJinete1IntentaAtacarAJinete3ADistanciaPeroEsAliado() {
		
		jinete1.ataqueADistancia(jinete3);
		
	}
	
	@Test
	public void testJinete1AtacaAJinete2ADistanciaSieteVecesYEsteUltimoMuere() {
		
		for(int i = 0; i < 7; i++)
			jinete1.ataqueADistancia(jinete2);
		assertFalse(jinete2.tieneVida());
		
	}
	@Test
	public void testDevuelveTrueSiTieneElMismoEquipo() {
		assertTrue(jinete1.mismoEquipo(jinete3));
	}
		
	@Test
	public void testDevuelveFalseCuandoNoTieneElMismoEquipo() {
		assertFalse(jinete1.mismoEquipo(jinete2));
	}
	@Test
	public void testJineteRecuperaVidaCorrectamente() {
		
		jinete1.recuperarVida(15);
		assertEquals(jinete1.getVida(),115);
		
	}
	
}
