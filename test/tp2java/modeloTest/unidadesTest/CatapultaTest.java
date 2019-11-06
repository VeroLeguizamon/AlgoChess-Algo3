package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.unidades.Catapulta;


public class CatapultaTest {
	
	private Catapulta catapulta1;
	private Catapulta catapulta2;
	
	@Before
	public void setUp() {
		
		catapulta1 = new Catapulta(1,new Coordenada(2,2));
		catapulta2 = new Catapulta(2,new Coordenada(3,2));
		
	}
	
	@Test
	public void testCatapulta1AtacaACatapulta2YEstaUltimaPierdeVida() {
		
		catapulta1.atacar(catapulta2);
		assertEquals(catapulta2.getVida(),30);
		
	}
	
	@Test
	public void testCatapulta1AtacaACatapulta2TresVecesYEstaUltimaMuere() {
		
		for(int i = 0; i < 10; i++)
			catapulta1.atacar(catapulta2);
		assertFalse(catapulta2.tieneVida());
		
	}
	
}
