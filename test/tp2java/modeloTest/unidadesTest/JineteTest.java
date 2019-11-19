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
		jinete1 = new Jinete(jugador1,new Coordenada(2,2),mockTablero);
		jinete2 = new Jinete(jugador2,new Coordenada(4,2),mockTablero);
		jinete3 = new Jinete(jugador1,new Coordenada(3,2),mockTablero);
	}
	
	@Test
	public void testJinete1AtacaAJinete2CuerpoACuerpoPorTenerEnemigoCercanoYNingunSoldadoAliado() {
		
		when(mockTablero.tieneEnemigosCercanos(jinete1)).thenReturn(true);
		when(mockTablero.tieneSoldadoAliadoCercano(jinete1)).thenReturn(false);
		jinete1.atacar(jinete2);
		assertEquals(jinete2.getVida(),95);
		
	}
	
	@Test(expected = ObjetivoAliado.class)
	public void testJinete1IntentaAtacarAJinete3CuerpoACuerpoPeroEsAliado() {
		
		jinete1.atacar(jinete3);
		
	}
	
	@Test
	public void testJinete1AtacaAJinete2CuerpoACuerpoVeinteVecesYEsteUltimoMuere() {
		
		for(int i = 0; i < 20; i++)
			jinete1.atacar(jinete2);
		assertFalse(jinete2.tieneVida());
		
	}
	
	
	@Test
	public void testJinete1AtacaJinete2ADistanciaPorNoTenerEnemigosCercanos() {
		
		when(mockTablero.tieneEnemigosCercanos(jinete1)).thenReturn(false);
		when(mockTablero.tieneSoldadoAliadoCercano(jinete1)).thenReturn(false);
		jinete2.setUbicacion(new Coordenada(5,2));
		jinete1.atacar(jinete2);
		assertEquals(jinete2.getVida(),85);
		
	}
	
	public void testJinete1AtacaJinete2ADistanciaPorTenerEnemigosCercanosPeroContarConUnSoldadoAliado() {
		
		when(mockTablero.tieneEnemigosCercanos(jinete1)).thenReturn(true);
		when(mockTablero.tieneSoldadoAliadoCercano(jinete1)).thenReturn(true);
		jinete2.setUbicacion(new Coordenada(5,2));
		jinete1.atacar(jinete2);
		assertEquals(jinete2.getVida(),85);
		
	}
	
	@Test(expected = ObjetivoAliado.class)
	public void testJinete1IntentaAtacarAJinete3ADistanciaPeroEsAliado() {
		
		when(mockTablero.tieneEnemigosCercanos(jinete1)).thenReturn(false);
		when(mockTablero.tieneSoldadoAliadoCercano(jinete1)).thenReturn(true);
		jinete3.setUbicacion(new Coordenada(5,2));
		jinete1.atacar(jinete3);
		
	}
	
	@Test
	public void testJinete1AtacaAJinete2ADistanciaSieteVecesYEsteUltimoMuere() {
		
		when(mockTablero.tieneEnemigosCercanos(jinete1)).thenReturn(false);
		when(mockTablero.tieneSoldadoAliadoCercano(jinete1)).thenReturn(true);
		jinete2.setUbicacion(new Coordenada(5,2));
		for(int i = 0; i < 7; i++)
			jinete1.atacar(jinete2);
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
