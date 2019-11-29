package tp2java.modeloTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import tp2java.modelo.Equipo;
import tp2java.modelo.unidades.Jinete;
import tp2java.modelo.unidades.SoldadoDeInfanteria;
import tp2java.modelo.unidades.Unidad;

public class EquipoTest {

	@Test
	public void test00EquipoTieneUnidadesConVida() {
		Unidad mockUnidad1 = mock(Unidad.class);
		when(mockUnidad1.tieneVida()).thenReturn(true);
		Unidad mockUnidad2 = mock(Unidad.class);
		when(mockUnidad2.tieneVida()).thenReturn(true);
		
		Equipo equipo = new Equipo();
		
		equipo.agregar(mockUnidad1);
		equipo.agregar(mockUnidad2);
		
		assertTrue(equipo.hayUnidadesConVida());
	}
	@Test
	public void test01EquipoNoTieneNingunaUnidadConVida() {
		Unidad mockUnidad1 = mock(Unidad.class);
		when(mockUnidad1.tieneVida()).thenReturn(false);
		
		Unidad mockUnidad2 = mock(Unidad.class);
		when(mockUnidad2.tieneVida()).thenReturn(false);
		
		Equipo equipo = new Equipo();
		
		equipo.agregar(mockUnidad1);
		equipo.agregar(mockUnidad2);
		
		assertFalse(equipo.hayUnidadesConVida());
	}
	@Test
	public void test02EquipoTieneUnaUnidadConVidaYOtraNo() {
		Unidad mockUnidad1 = mock(Unidad.class);
		when(mockUnidad1.tieneVida()).thenReturn(false);
		
		Unidad mockUnidad2 = mock(Unidad.class);
		when(mockUnidad2.tieneVida()).thenReturn(true);
		
		Equipo equipo = new Equipo();
		
		equipo.agregar(mockUnidad1);
		equipo.agregar(mockUnidad2);
		
		assertTrue(equipo.hayUnidadesConVida());
	}
	@Test
	public void testDistintasUnidadesMismaClase() {
		Jinete jinete = new Jinete();
		Jinete jine = new Jinete();
		
		Equipo e = new Equipo();
		e.agregar(jinete);
		assertFalse(e.yaTiene(jine));
	}
	@Test 
	public void testMismaUnidadMismaClase() {
		SoldadoDeInfanteria sol1 = new SoldadoDeInfanteria();
		SoldadoDeInfanteria sol2 = sol1;
		
		Equipo e = new Equipo();
		e.agregar(sol1);
		assertTrue(e.yaTiene(sol2));
		
	}
}
