package tp2java.modeloTest.tableroTest;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Sector;

public class SectorTest {

	@Test
	public void test00SectorDeberiaDevolverTrueCuandoUnaCoordenadaEstaDentroDelRango() {
		Sector sector = new Sector(0,0,5,5);
		
		Coordenada prueba = new Coordenada(3,4);
		
		assertTrue(sector.perteneceAlSector(prueba));
	}
	@Test
	public void test01SectorDeberiaDevolverFalseCuandoNoPerteneceLaCoordenada() {
		Sector sector = new Sector(0,0,5,5);
		
		Coordenada prueba = new Coordenada(6,6);
		
		assertFalse(sector.perteneceAlSector(prueba));
	}
	@Test
	public void test02SectorDevuelveTrueCasoLimiteMaximo() {
		Sector sector = new Sector(0,0,5,5);
		
		Coordenada prueba = new Coordenada(5,5);
		
		assertTrue(sector.perteneceAlSector(prueba));
	}
	@Test
	public void test03SectorDeberiaDevolverTrueCasoLimiteMinimo() {
		Sector sector = new Sector(0,0,5,5);
		
		Coordenada prueba = new Coordenada(0,0);
		
		assertTrue(sector.perteneceAlSector(prueba));
	}
	@Test
	public void test04SectorDeberiaDevolverFalseCoeficienteNegativo() {
		Sector sector = new Sector(0,0,5,5);
		
		Coordenada prueba = new Coordenada(-2,0);
		
		assertFalse(sector.perteneceAlSector(prueba));
	}
}
