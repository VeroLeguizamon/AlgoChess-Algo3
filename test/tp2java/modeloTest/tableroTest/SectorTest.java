package tp2java.modeloTest.tableroTest;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Sector;

public class SectorTest {

	@Test
	public void test00SectorDeberiaDevolverTrueCuandoUnaCoordenadaEstaDentroDelRango() {
		Coordenada max = new Coordenada(5,5);
		Coordenada min = new Coordenada(0,0);
		Sector sector = new Sector(min,max);
		
		Coordenada prueba = new Coordenada(3,4);
		
		assertTrue(sector.perteneceAlSector(prueba));
	}
	@Test
	public void test01SectorDeberiaDevolverFalseCuandoNoPerteneceLaCoordenada() {
		Coordenada max = new Coordenada(5,5);
		Coordenada min = new Coordenada(0,0);
		Sector sector = new Sector(min,max);
		
		Coordenada prueba = new Coordenada(3,6);
		
		assertFalse(sector.perteneceAlSector(prueba));
	}
	@Test
	public void test02SectorDevuelveTrueCasoLimiteMaximo() {
		Coordenada max = new Coordenada(5,5);
		Coordenada min = new Coordenada(0,0);
		Sector sector = new Sector(min,max);
		
		Coordenada prueba = new Coordenada(5,5);
		
		assertTrue(sector.perteneceAlSector(prueba));
	}
	@Test
	public void test03SectorDeberiaDevolverTrueCasoLimiteMinimo() {
		Coordenada max = new Coordenada(5,5);
		Coordenada min = new Coordenada(0,0);
		Sector sector = new Sector(min,max);
		
		Coordenada prueba = new Coordenada(0,0);
		
		assertTrue(sector.perteneceAlSector(prueba));
	}
	@Test
	public void test04SectorDeberiaDevolverFalseCoeficienteNegativo() {
		Coordenada max = new Coordenada(5,5);
		Coordenada min = new Coordenada(0,0);
		Sector sector = new Sector(min,max);
		
		Coordenada prueba = new Coordenada(-2,0);
		
		assertFalse(sector.perteneceAlSector(prueba));
	}
}
