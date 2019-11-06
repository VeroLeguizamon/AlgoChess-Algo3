package tp2java.modeloTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import tp2java.modelo.Equipo;
import tp2java.modelo.interfaces.IEntidad;

public class EquipoTest {

	@Test
	public void test00EquipoTieneUnidadesConVida() {
		IEntidad mockUnidad1 = mock(IEntidad.class);
		when(mockUnidad1.tieneVida()).thenReturn(true);
		IEntidad mockUnidad2 = mock(IEntidad.class);
		when(mockUnidad2.tieneVida()).thenReturn(true);
		
		Equipo equipo = new Equipo();
		
		equipo.agregar(mockUnidad1);
		equipo.agregar(mockUnidad2);
		
		assertTrue(equipo.hayUnidadesConVida());
	}
	@Test
	public void test01EquipoNoTieneNingunaUnidadConVida() {
		IEntidad mockUnidad1 = mock(IEntidad.class);
		when(mockUnidad1.tieneVida()).thenReturn(false);
		
		IEntidad mockUnidad2 = mock(IEntidad.class);
		when(mockUnidad2.tieneVida()).thenReturn(false);
		
		Equipo equipo = new Equipo();
		
		equipo.agregar(mockUnidad1);
		equipo.agregar(mockUnidad2);
		
		assertFalse(equipo.hayUnidadesConVida());
	}
	@Test
	public void test02EquipoTieneUnaUnidadConVidaYOtraNo() {
		IEntidad mockUnidad1 = mock(IEntidad.class);
		when(mockUnidad1.tieneVida()).thenReturn(false);
		
		IEntidad mockUnidad2 = mock(IEntidad.class);
		when(mockUnidad2.tieneVida()).thenReturn(true);
		
		Equipo equipo = new Equipo();
		
		equipo.agregar(mockUnidad1);
		equipo.agregar(mockUnidad2);
		
		assertTrue(equipo.hayUnidadesConVida());
	}

}
