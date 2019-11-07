package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.Before;

import tp2java.modelo.unidades.SoldadoDeInfanteria;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.excepciones.*;


public class SoldadoDeInfanteriaTest {
	
	private SoldadoDeInfanteria soldado1;
	private SoldadoDeInfanteria soldado2;
	private Tablero mockTablero;
	
	@Before
	public void setUp() {
		
		mockTablero = mock(Tablero.class);
		soldado1 = new SoldadoDeInfanteria(1,new Coordenada(2,2),mockTablero);
		soldado2 = new SoldadoDeInfanteria(2,new Coordenada(3,2),mockTablero);
		
	}
	
	@Test
	public void testSoldado1AtacaASoldado2YEsteUltimoPierdeVida() {
		
		soldado1.atacar(soldado2);
		assertEquals(soldado2.getVida(),90);
		
	}
	
	@Test
	public void testSoldado1AtacaASoldado2DiezVecesYEsteUltimoMuere() {
		
		for(int i = 0; i < 10; i++)
			soldado1.atacar(soldado2);
		assertFalse(soldado2.tieneVida());
		
	}
	
	@Test(expected = ObjetivoAliado.class)
	public void testSoldado1IntentaAtacarASoldado3PeroEsAliado() {
		
		SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(1,new Coordenada(1,2),mockTablero);
		soldado1.atacar(soldado3);
		
	}
	
	@Test
	public void testSoldadoRecuperaVidaCorrectamente() {
		
		soldado1.recuperarVida(15);
		assertEquals(soldado1.getVida(),115);
		
	}
	
}
