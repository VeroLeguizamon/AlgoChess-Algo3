package tp2java.modeloTest.tableroTest;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Sector;

public class SectorTest {

	@Test
	public void test00SectorDeberiaDevolverTrueCuandoUnaCoordenadaEstaDentroDelRango() {
		Sector sector = new Sector(0,5);
		
		Coordenada prueba1 = new Coordenada(1,1);
		Coordenada prueba2 = new Coordenada(2,5);
		Coordenada prueba3 = new Coordenada(2,10);
		Coordenada prueba4 = new Coordenada(3,6);
		Coordenada prueba5 = new Coordenada(5,4);
		Coordenada prueba6 = new Coordenada(4,7);
		
		assertTrue(sector.perteneceAlSector(prueba1));
		assertTrue(sector.perteneceAlSector(prueba2));
		assertTrue(sector.perteneceAlSector(prueba3));
		assertTrue(sector.perteneceAlSector(prueba4));
		assertTrue(sector.perteneceAlSector(prueba5));
		assertTrue(sector.perteneceAlSector(prueba6));
	}
	@Test
	public void test01SectorDeberiaDevolverFalseCuandoNoPerteneceLaCoordenada() {
		Sector sector = new Sector(0,5);
		
		Coordenada prueba = new Coordenada(6,0);
		
		assertFalse(sector.perteneceAlSector(prueba));
	}
	@Test
	public void test02SectorDevuelveTrueCasoLimiteMaximo() {
		Sector sector = new Sector(0,5);
		
		Coordenada prueba = new Coordenada(5,5);
		
		assertTrue(sector.perteneceAlSector(prueba));
	}
	@Test
	public void test03SectorDeberiaDevolverTrueCasoLimiteMinimo() {
		Sector sector = new Sector(0,5);
		
		Coordenada prueba = new Coordenada(0,0);
		
		assertTrue(sector.perteneceAlSector(prueba));
	}
	@Test
	public void test04SectorDeberiaDevolverFalseCoeficienteNegativo() {
		Sector sector = new Sector(0,5);
		
		Coordenada prueba = new Coordenada(-2,0);
		
		assertFalse(sector.perteneceAlSector(prueba));
	}
}
