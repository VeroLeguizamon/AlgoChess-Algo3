package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Unidad;
import tp2java.modelo.unidades.Catapulta;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class CatapultaTest {
	
	private Catapulta catapulta1;
	private Catapulta catapulta2;
	private Catapulta catapulta3;
	private Catapulta catapulta4;
	private Catapulta catapulta5;
	private Catapulta catapulta6;
	private Jugador mockJugador1;
	private Jugador mockJugador2;
	private Tablero mockTablero;
	
	@Before
	public void setUp() {
		
		mockJugador1 = mock(Jugador.class);
		mockJugador2 = mock(Jugador.class);
		mockTablero = mock(Tablero.class);
		when(mockJugador1.perteneceAlSector(anyObject())).thenReturn(true);
		when(mockJugador2.perteneceAlSector(anyObject())).thenReturn(true);
		
		catapulta1 = new Catapulta(mockJugador1, new Coordenada(2,2), mockTablero);			
				
		catapulta2 = new Catapulta(mockJugador2, new Coordenada(12,12), mockTablero);
		ArrayList<Unidad> unidadesAdyacentesCatapulta2 = new ArrayList<Unidad>();		
		catapulta3 = new Catapulta(mockJugador2, new Coordenada(13,13), mockTablero);
		ArrayList<Unidad> unidadesAdyacentesCatapulta3 = new ArrayList<Unidad>();		
		catapulta4 = new Catapulta(mockJugador1, new Coordenada(14,13), mockTablero);
		ArrayList<Unidad> unidadesAdyacentesCatapulta4 = new ArrayList<Unidad>();		
		catapulta5 = new Catapulta(mockJugador2, new Coordenada(14,14), mockTablero);
		ArrayList<Unidad> unidadesAdyacentesCatapulta5 = new ArrayList<Unidad>();		
		catapulta6 = new Catapulta(mockJugador2, new Coordenada(15,15), mockTablero);
		ArrayList<Unidad> unidadesAdyacentesCatapulta6 = new ArrayList<Unidad>();		
		
		unidadesAdyacentesCatapulta2.add(catapulta3);
		when(mockTablero.unidadesCercanas(catapulta2, 1)).thenReturn(unidadesAdyacentesCatapulta2);
		unidadesAdyacentesCatapulta3.add(catapulta2);
		unidadesAdyacentesCatapulta3.add(catapulta4);
		unidadesAdyacentesCatapulta3.add(catapulta5);
		when(mockTablero.unidadesCercanas(catapulta3, 1)).thenReturn(unidadesAdyacentesCatapulta3);
		unidadesAdyacentesCatapulta4.add(catapulta3);
		unidadesAdyacentesCatapulta4.add(catapulta5);
		when(mockTablero.unidadesCercanas(catapulta4, 1)).thenReturn(unidadesAdyacentesCatapulta4);
		unidadesAdyacentesCatapulta5.add(catapulta3);
		unidadesAdyacentesCatapulta5.add(catapulta4);
		unidadesAdyacentesCatapulta5.add(catapulta6);
		when(mockTablero.unidadesCercanas(catapulta5, 1)).thenReturn(unidadesAdyacentesCatapulta5);
		unidadesAdyacentesCatapulta6.add(catapulta5);
		when(mockTablero.unidadesCercanas(catapulta6, 1)).thenReturn(unidadesAdyacentesCatapulta6);
		
	}
	
	@Test
	public void testCatapulta1AtacaACatapulta2YEstaUltimaPierdeVida() {
		
		catapulta1.atacar(catapulta2);
		assertEquals(catapulta2.getVida(),30);
		assertTrue(catapulta1.puedoInteractuar(catapulta2));
	}
	
	@Test
	public void testCatapulta2AtacaACatapulta1YEstaUltimaPierdeVida() {
		
		catapulta2.atacar(catapulta1);
		assertEquals(catapulta1.getVida(),30);
		
	}
	
	@Test
	public void testCatapulta1AtacaACatapulta2PeroEstaMuyCerca() {
		
		catapulta2.setUbicacion(new Coordenada(4,4));
		catapulta1.atacar(catapulta2);
		assertEquals(catapulta2.getVida(),50);
		
	}
	
	@Test(expected = ObjetivoAliado.class)
	public void testCatapulta1IntentaAtacarACatapulta3PeroEsAliada() {
		
		catapulta3.setJugador(mockJugador1);
		catapulta1.atacar(catapulta3);
		
	}
	
	@Test
	public void testCatapulta1AtacaACatapulta2TresVecesYEstaUltimaMuere() {
		
		for(int i = 0; i < 10; i++)
			catapulta1.atacar(catapulta2);
		assertFalse(catapulta2.tieneVida());
		
	}
	
	@Test
	public void testRecorrerUnidadesDesdeCatapultaEntre2y6DevuelveTodasLasContiguas() {
		
		ArrayList<Unidad> unidadesRecorridas= new ArrayList<Unidad>();
		unidadesRecorridas.add(catapulta2);
		unidadesRecorridas.add(catapulta3);
		unidadesRecorridas.add(catapulta4);
		unidadesRecorridas.add(catapulta5);
		unidadesRecorridas.add(catapulta6);
		
		assertTrue(catapulta1.recorrerUnidadesAfectadas(catapulta2).containsAll(unidadesRecorridas));
		assertTrue(catapulta1.recorrerUnidadesAfectadas(catapulta3).containsAll(unidadesRecorridas));
		assertTrue(catapulta1.recorrerUnidadesAfectadas(catapulta4).containsAll(unidadesRecorridas));
		assertTrue(catapulta1.recorrerUnidadesAfectadas(catapulta5).containsAll(unidadesRecorridas));
		assertTrue(catapulta1.recorrerUnidadesAfectadas(catapulta6).containsAll(unidadesRecorridas));
		
	}
	
	@Test
	public void testCatapulta1AtacaACatapulta3YTodasLasUnidadesContiguasPierdenVida() {
		
		catapulta1.atacar(catapulta3);
		
		assertEquals(catapulta2.getVida(),30);
		assertEquals(catapulta3.getVida(),30);
		assertEquals(catapulta4.getVida(),30);
		assertEquals(catapulta5.getVida(),30);
		assertEquals(catapulta6.getVida(),30);
		
	}
	
}
