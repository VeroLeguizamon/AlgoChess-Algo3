package fiuba.algo3.modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.mock.interfaces.IUnidad;
import fiuba.algo3.modelo.Equipo;
import fiuba.algo3.mock.MockUnidad;

public class EquipoTest {

	@Test
	public void test00EquipoTieneUnidadesConVida() {
		IUnidad unidad1 = new MockUnidad();
		IUnidad unidad2 = new MockUnidad();
		Equipo equipo = new Equipo();
		
		equipo.agregar(unidad1);
		equipo.agregar(unidad2);
		
		assertTrue(equipo.hayUnidadesConVida());
	}
	@Test
	public void test01EquipoNoTieneNingunaUnidadConVida() {
		IUnidad unidad1 = new MockUnidad();
		IUnidad unidad2 = new MockUnidad();
		Equipo equipo = new Equipo();
		
		unidad1.matar();
		unidad2.matar();
		
		equipo.agregar(unidad1);
		equipo.agregar(unidad2);
		
		assertFalse(equipo.hayUnidadesConVida());
	}
	@Test
	public void test02EquipoTieneUnaUnidadConVidaYOtraNo() {
		IUnidad unidad1 = new MockUnidad();
		IUnidad unidad2 = new MockUnidad();
		Equipo equipo = new Equipo();
		
		unidad1.matar();
		
		equipo.agregar(unidad1);
		equipo.agregar(unidad2);
		
		assertTrue(equipo.hayUnidadesConVida());
	}

}
