package tp2java.modeloTest.tableroTest;

import static org.junit.Assert.*;
import org.junit.Test;
import tp2java.modelo.tablero.Coordenada;

public class CoordenadaTest {

	@Test
	public void test00CalculaBienLaDistanciaEntreDosCoordeandasMismaXDistintaY() {
		Coordenada c1 = new Coordenada(1,1);
		Coordenada c2 = new Coordenada(1,7);
		
		int distancia = c1.calcularDistancia(c2);
		
		assertEquals (distancia,6);
	}
	@Test
	public void test01CalculaBienLaDistanciaEntreDosCoordeandasMismaYDistintaX() {
		Coordenada c1 = new Coordenada(7,1);
		Coordenada c2 = new Coordenada(1,1);
		
		int distancia = c1.calcularDistancia(c2);
		
		assertEquals (distancia,6);
	}

	@Test
	public void test02CalculaBienLaDistanciaEntreDosCoordeandasDiagonal() {
		Coordenada c1 = new Coordenada(7,7);
		Coordenada c2 = new Coordenada(1,1);
		
		int distancia = c1.calcularDistancia(c2);
		
		assertEquals (distancia,6);
	}
	@Test 
	public void test03DeberiaDevolverTrueCuandoLosCoeficientesSonMenores() {
		Coordenada c2 = new Coordenada(1,1);
		
		assertTrue(c2.tieneCoeficientesMenoresOIgualesQue(7,7));
	}
	@Test
	public void test04DeberiaDevolverTrueCuandoTieneCoeficientesIguales() {
		Coordenada c2 = new Coordenada(7,7);
		
		assertTrue(c2.tieneCoeficientesMenoresOIgualesQue(7,7));
	}
	@Test
	public void test05DeberiaDevolverTrueCuandoTieneCoeficientesMayores() {
		Coordenada c1 = new Coordenada(7,7);
		assertTrue(c1.tieneCoeficientesMayoresOIgualesQue(1,1));
	}
}
