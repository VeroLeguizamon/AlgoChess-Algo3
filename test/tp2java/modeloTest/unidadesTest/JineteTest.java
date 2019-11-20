package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Jinete;
import tp2java.modelo.unidades.SoldadoDeInfanteria;
import tp2java.modelo.unidades.Unidad;

public class JineteTest {
	
	private Jinete jinete1;
	private Jinete jinete2;
	private Jinete jinete3;
	private ArrayList<Unidad> unidadesCercanas = new ArrayList<Unidad>();
	private Tablero mockTablero;
	private SoldadoDeInfanteria mockSoldadoAliado;
	private Jugador jugador1 = new Jugador("pl",0,9);
	private Jugador jugador2 = new Jugador("player",10,9);
	
	@Before
	public void setUp() {
		
		mockTablero = mock(Tablero.class);
		mockSoldadoAliado = mock(SoldadoDeInfanteria.class);
		jinete1 = new Jinete(jugador1,new Coordenada(2,2),mockTablero);
		jinete2 = new Jinete(jugador2,new Coordenada(4,2),mockTablero);
		jinete3 = new Jinete(jugador1,new Coordenada(3,2),mockTablero);
		when(mockTablero.unidadesCercanas(jinete1, 2)).thenReturn(unidadesCercanas);
		when(mockSoldadoAliado.mismoEquipo(jinete1)).thenReturn(true);
		
	}
	
	@Test
	public void testJineteTieneEnemigoCercano() {
		
		unidadesCercanas.add(jinete2);
		unidadesCercanas.add(jinete3);
		assertTrue(jinete1.tieneEnemigoCercano());
		
	}
	
	@Test
	public void testJineteNoTieneEnemigoCercano() {
		
		jinete2.setUbicacion(new Coordenada(5,5));
		unidadesCercanas.add(jinete3);
		assertFalse(jinete1.tieneEnemigoCercano());
		
	}
	
	@Test
	public void testJinete1AtacaAJinete2CuerpoACuerpoPorTenerEnemigoCercanoYNingunSoldadoAliado() {
		
		unidadesCercanas.add(jinete2);
		unidadesCercanas.add(jinete3);
		jinete1.atacar(jinete2);
		assertEquals(jinete2.getVida(),95);
		
	}
	
	@Test(expected = ObjetivoAliado.class)
	public void testJinete1IntentaAtacarAJinete3CuerpoACuerpoPeroEsAliado() {
		
		unidadesCercanas.add(jinete2);
		unidadesCercanas.add(jinete3);
		jinete1.atacar(jinete3);
		
	}
	
	@Test
	public void testJinete1AtacaAJinete2CuerpoACuerpoVeinteVecesYEsteUltimoMuere() {
		
		unidadesCercanas.add(jinete2);
		unidadesCercanas.add(jinete3);
		for(int i = 0; i < 20; i++)
			jinete1.atacar(jinete2);
		assertFalse(jinete2.tieneVida());
		
	}
	
	
	@Test
	public void testJinete1AtacaJinete2ADistanciaPorNoTenerEnemigosCercanos() {
		
		jinete2.setUbicacion(new Coordenada(5,5));
		unidadesCercanas.add(jinete3);
		jinete1.atacar(jinete2);
		assertEquals(jinete2.getVida(),85);
		
	}
	
	@Test
	public void testJinete1AtacaJinete2ADistanciaPorNoTenerEnemigosCercanosPeroJinete2EstaMuyLejos() {
		
		jinete2.setUbicacion(new Coordenada(10,10));
		unidadesCercanas.add(jinete3);
		jinete1.atacar(jinete2);
		assertEquals(jinete2.getVida(),100);
		
	}
	
	@Test
	public void testJinete1AtacaJinete2ADistanciaPorTenerEnemigosCercanosPeroContarConUnSoldadoAliado() {
		
		Jinete jinete4 = new Jinete(jugador2,new Coordenada(1,2),mockTablero);
		jinete2.setUbicacion(new Coordenada(5,5));
		unidadesCercanas.add(jinete3);
		unidadesCercanas.add(jinete4);
		unidadesCercanas.add(mockSoldadoAliado);
		jinete1.atacar(jinete2);
		assertEquals(jinete2.getVida(),85);
		
	}
	
	@Test(expected = ObjetivoAliado.class)
	public void testJinete1IntentaAtacarAJinete3ADistanciaPeroEsAliado() {
		
		jinete3.setUbicacion(new Coordenada(5,2));
		unidadesCercanas.add(jinete2);
		unidadesCercanas.add(mockSoldadoAliado);
		jinete1.atacar(jinete3);
		
	}
	
	@Test
	public void testJinete1AtacaAJinete2ADistanciaSieteVecesYEsteUltimoMuere() {
		
		jinete2.setUbicacion(new Coordenada(5,5));
		unidadesCercanas.add(jinete3);
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
