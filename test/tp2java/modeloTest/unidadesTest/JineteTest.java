package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.Before;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Jinete;

public class JineteTest {
	
	private Jinete jinete1;
	private Jinete jinete2;
	private Tablero mockTablero;
	
	@Before
	public void setUp() {
		
		mockTablero = mock(Tablero.class);
		jinete1 = new Jinete(1,new Coordenada(2,2),mockTablero);
		jinete2 = new Jinete(2,new Coordenada(4,2),mockTablero);
		
	}
	
	@Test
	public void testJinete1AtacaAJinete2CuerpoACuerpoYEsteUltimoPierdeVida() {
		
		jinete1.ataqueCuerpoACuerpo(jinete2);
		assertEquals(jinete2.getVida(),95);
		
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
	
	@Test
	public void testJinete1AtacaAJinete2ADistanciaSieteVecesYEsteUltimoMuere() {
		
		for(int i = 0; i < 7; i++)
			jinete1.ataqueADistancia(jinete2);
		assertFalse(jinete2.tieneVida());
		
	}
		
	@Test
	public void testJineteRecuperaVidaCorrectamente() {
		
		jinete1.recuperarVida(15);
		assertEquals(jinete1.getVida(),115);
		
	}
	
}
