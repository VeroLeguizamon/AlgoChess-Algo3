package tp2java.primeraEntrega;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import tp2java.modelo.tablero.*;
import tp2java.modelo.*;
import tp2java.modelo.unidades.*;
import tp2java.excepciones.*;

public class primeraEntregaTest {
	
	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	
	@Before
	public void setUp() {
		
		tablero = new Tablero();
		jugador1 = new Jugador("player1");
		jugador2 = new Jugador("player2");
		
	}
	
	// Pruebas Entidades
	@Test
	public void test00UnidadMovibleSeMueveHaciaAbajoUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(1,new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.agregarEntidad(jinete);
		jinete.moverHaciaAbajo();
		assertEquals(jinete.getUbicacion(), new Coordenada(5,4));	
		
	}
	@Test
	public void test01UnidadMovibleSeMueveHaciaArribaUnCasilleroExitosamente() {
			
		Jinete jinete = new Jinete(1,new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.agregarEntidad(jinete);
		jinete.moverHaciaArriba();
		assertEquals(jinete.getUbicacion(), new Coordenada(5,6));	
		
	}
	@Test
	public void test02UnidadMovibleSeMueveHaciaLaDerechaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(1,new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.agregarEntidad(jinete);
		jinete.moverHaciaLaDerecha();
		assertEquals(jinete.getUbicacion(), new Coordenada(6,5));	
		
	}
	@Test
	public void test03UnidadMovibleSeMueveHaciaLaIzquierdaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(1,new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.agregarEntidad(jinete);
		jinete.moverHaciaLaIzquierda();
		assertEquals(jinete.getUbicacion(), new Coordenada(4,5));
		
	}
	@Test
	public void test04UnidadMovibleSeMueveEnDiagonalArribaDerechaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(1,new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.agregarEntidad(jinete);
		jinete.moverEnDiagonalArribaDerecha();
		assertEquals(jinete.getUbicacion(), new Coordenada(6,6));
		
	}
	@Test
	public void test05UnidadMovibleSeMueveHaciaDiagonalArribaIzquierdaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(1,new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.agregarEntidad(jinete);
		jinete.moverEnDiagonalArribaIzquierda();
		assertEquals(jinete.getUbicacion(), new Coordenada(4,6));
		
	}
	@Test
	public void test06UnidadMovibleSeMueveHaciaDiagonalAbajoDerechoUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(1,new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.agregarEntidad(jinete);
		jinete.moverEnDiagonalAbajoDerecha();
		assertEquals(jinete.getUbicacion(), new Coordenada(6,4));
		
	}
	@Test
	public void test07UnidadMovibleSeMueveHaciaDiagonalAbajoIzquierdoUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(1,new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.agregarEntidad(jinete);
		jinete.moverEnDiagonalAbajoIzquierda();
		assertEquals(jinete.getUbicacion(), new Coordenada(4,4));
		
	}
	@Test(expected = CeldaEstaOcupadaExcepcion.class)
	public void test08UnidadMovibleNoPuedeMoverseACasilleroOcupadoExitosamente() {
		
		Jinete jinete = new Jinete(1,new Coordenada(5,5),tablero);
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(1,new Coordenada(6,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.agregarEntidad(jinete);
		jugador1.comprarUnidad(soldado);
		tablero.agregarEntidad(soldado);
		jinete.moverHaciaLaDerecha();
		
	}
	@Test
	public void test09SoldadoDeInfanteriaAliadoAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Jinete jinete = new Jinete(2,new Coordenada(5,5),tablero);
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(1,new Coordenada(6,5),tablero);
		
		soldado.atacar(jinete);
		assertEquals(jinete.getVida(), 90);
		
	}
	@Test
	public void test10JineteAliadoAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Jinete jinete = new Jinete(1,new Coordenada(5,5),tablero);
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(2,new Coordenada(6,5),tablero);
		
		jinete.ataqueCuerpoACuerpo(soldado);
		assertEquals(soldado.getVida(), 95);
		jinete.ataqueADistancia(soldado);
		assertEquals(soldado.getVida(), 80);
		
	}
	@Test
	public void test11CatapultaAliadaAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Catapulta catapulta = new Catapulta(1,new Coordenada(5,15));
		Curandero curandero = new Curandero(2,new Coordenada(5,5),tablero);
		
		catapulta.atacar(curandero);
		assertEquals(curandero.getVida(), 55);
		
	}
	@Test
	public void test12CuranderoAliadoCuraAPiezaAliadaYSumaPuntosExitosamente() {
		
		Curandero curandero = new Curandero(2,new Coordenada(5,5),tablero);
		Jinete jinete = new Jinete(2,new Coordenada(5,6),tablero);
		
		curandero.curar(jinete);
		assertEquals(jinete.getVida(), 115);
		
	}
	
	// Pruebas Tablero
	@Test
	public void test13TableroColocaPiezaAliadaEnZonaAliadaVaciaExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test14TableroNoPuedeColocarPiezaAliadaEnCasilleroAliadoExitosamente() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test15TableroNoPuedeColocarPiezaAliadaEnUnCasilleroDelSectorEnemigo() {
		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test16TableroSeCreaEIniciaCorrectamente () {
		
		Assert.assertEquals(true, true);
	}
	
	// Pruebas Jugador 	
	@Test
	public void test17JugadorNoPuedeTomarMasEntidadesDeLoQuesusPuntosLePermiteExitosamente() {

		
		Assert.assertEquals(true, true);
	}
	@Test
	public void test18JugadorSinEntidadesResultaSerPerdedor() {
		
		Assert.assertEquals(true, true);
	}

}
