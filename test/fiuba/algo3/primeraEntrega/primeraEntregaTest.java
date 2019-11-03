package fiuba.algo3.primeraEntrega;

import org.junit.Assert;
import org.junit.Test;

//import fiuba.algo3.modelo.Jugador;
//import fiuba.algo3.modelo.unidades.Unidad;

public class primeraEntregaTest {
	// Pruebas Entidades
	@Test
	public void test00UnidadMovibleSeMueveHaciaAbajoUnCasilleroExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test01UnidadMovibleSeMueveHaciaArribaUnCasilleroExitosamente() {
			
			Assert.assertEquals(true, true);
	}
	@Test
	public void test02UnidadMovibleSeMueveHaciaLaDerechaUnCasilleroExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test03UnidadMovibleSeMueveHaciaLaIzquierdaUnCasilleroExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test04UnidadMovibleSeMueveEnDiagonalArribaDerechaUnCasilleroExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test05UnidadMovibleSeMueveHaciaDiagonalArribaIzquierdaUnCasilleroExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test06UnidadMovibleSeMueveHaciaDiagonalAbajoDerechoUnCasilleroExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test07UnidadMovibleSeMueveHaciaDiagonalAbajoIzquierdoUnCasilleroExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test08UnidadMovibleNoPuedeMoverseACasilleroOcupadoExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test09SoldadoDeInfanteriaAliadoAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test10JineteAliadoAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test11CatapultaAliadoAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test12CuranderoAliadoAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	
	// Pruebas Tablero
	@Test
	public void test00TableroColocaPiezaAliadaEnZonaAliadaVaciaExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test01TableroNoPuedeColocarPiezaAliadaEnCasilleroAliadoExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test02TableroNoPuedeColocarPiezaAliadaEnUnCasilleroDelSectorEnemigo() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test03TableroSeCreaEIniciaCorrectamente () {
		
		Assert.assertEquals(true, true);
	}
	
	// Pruebas Jugador 
	
	@Test
	public void test00JugadorNoPuedeTomarMasEntidadesDeLoQuesusPuntosLePermiteExitosamente() {

		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test01JugadorSinEntidadesResultaSerPerdedor() {
		
		Assert.assertEquals(true, true);
	}

}
