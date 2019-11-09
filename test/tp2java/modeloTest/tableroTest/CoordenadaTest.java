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
	public void test00CalculaBienLaDistanciaEntreDosCoordeandasMismaYDistintaX() {
		Coordenada c1 = new Coordenada(7,1);
		Coordenada c2 = new Coordenada(1,1);
		
		int distancia = c1.calcularDistancia(c2);
		
		assertEquals (distancia,6);
	}

	@Test
	public void test00CalculaBienLaDistanciaEntreDosCoordeandasDiagonal() {
		Coordenada c1 = new Coordenada(7,7);
		Coordenada c2 = new Coordenada(1,1);
		
		int distancia = c1.calcularDistancia(c2);
		
		assertEquals (distancia,6);
	}
}
