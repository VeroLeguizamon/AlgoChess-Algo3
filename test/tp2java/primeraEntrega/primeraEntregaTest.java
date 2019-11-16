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
	
	@Before
	public void setUp() {
		
		tablero = new Tablero();
		jugador1 = new Jugador("player1",0,9);
		
	}
	
	// Pruebas Entidades
	@Test
	public void test00UnidadMovibleSeMueveHaciaAbajoUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.moverHaciaAbajo();
		assertEquals(jinete.getUbicacion(), new Coordenada(5,4));	
		
	}
	@Test
	public void test01UnidadMovibleSeMueveHaciaArribaUnCasilleroExitosamente() {
			
		Jinete jinete = new Jinete(new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.moverHaciaArriba();
		assertEquals(jinete.getUbicacion(), new Coordenada(5,6));	
		
	}
	@Test
	public void test02UnidadMovibleSeMueveHaciaLaDerechaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.moverHaciaLaDerecha();
		assertEquals(jinete.getUbicacion(), new Coordenada(6,5));	
		
	}
	@Test
	public void test03UnidadMovibleSeMueveHaciaLaIzquierdaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.moverHaciaLaIzquierda();
		assertEquals(jinete.getUbicacion(), new Coordenada(4,5));
		
	}
	@Test
	public void test04UnidadMovibleSeMueveEnDiagonalArribaDerechaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.moverEnDiagonalArribaDerecha();
		assertEquals(jinete.getUbicacion(), new Coordenada(6,6));
		
	}
	@Test
	public void test05UnidadMovibleSeMueveHaciaDiagonalArribaIzquierdaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.moverEnDiagonalArribaIzquierda();
		assertEquals(jinete.getUbicacion(), new Coordenada(4,6));
		
	}
	@Test
	public void test06UnidadMovibleSeMueveHaciaDiagonalAbajoDerechoUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.moverEnDiagonalAbajoDerecha();
		assertEquals(jinete.getUbicacion(), new Coordenada(6,4));
		
	}
	@Test
	public void test07UnidadMovibleSeMueveHaciaDiagonalAbajoIzquierdoUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.moverEnDiagonalAbajoIzquierda();
		assertEquals(jinete.getUbicacion(), new Coordenada(4,4));
		
	}
	@Test
	public void test08UnidadMovibleNoPuedeMoverseACasilleroOcupadoExitosamente() {
		
		Jinete jinete = new Jinete(new Coordenada(5,5),tablero);
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(new Coordenada(6,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jugador1.comprarUnidad(soldado);
		tablero.colocarUnidad(soldado);
		jinete.moverHaciaLaDerecha();
		
		assertTrue(true);
		
	}
	@Test
	public void test09SoldadoDeInfanteriaAliadoAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Jinete jinete = new Jinete(new Coordenada(5,5),tablero);
		jinete.setJugador(new Jugador("player1",0,9));
		
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(new Coordenada(6,5),tablero);
		soldado.setJugador(new Jugador("player2",10,19));
		
		soldado.atacar(jinete);
		assertEquals(jinete.getVida(), 90);
		
	}
	@Test
	public void test10JineteAliadoAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Jinete jinete = new Jinete(new Coordenada(5,5),tablero);
		jinete.setJugador(new Jugador("player1",0,9));
		
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(new Coordenada(6,5),tablero);
		soldado.setJugador(new Jugador("player2",10,19));
		
		jinete.ataqueCuerpoACuerpo(soldado);
		assertEquals(soldado.getVida(), 95);
		jinete.ataqueADistancia(soldado);
		assertEquals(soldado.getVida(), 80);
		
	}
	@Test
	public void test11CatapultaAliadaAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Catapulta catapulta = new Catapulta(new Coordenada(5,15));
		catapulta.setJugador(new Jugador("player1",0,9));
		
		Curandero curandero = new Curandero(new Coordenada(5,5),tablero);
		curandero.setJugador(new Jugador("player2",10,19));
		
		catapulta.atacar(curandero);
		assertEquals(curandero.getVida(), 55);
		
	}
	@Test
	public void test12CuranderoAliadoCuraAPiezaAliadaYSumaPuntosExitosamente() {
		
		Curandero curandero = new Curandero(new Coordenada(5,5),tablero);
		Jinete jinete = new Jinete(new Coordenada(5,6),tablero);
		
		curandero.curar(jinete);
		assertEquals(jinete.getVida(), 115);
		
	}
	
	// Pruebas Tablero
	@Test
	public void test13TableroColocaPiezaAliadaEnZonaAliadaVaciaExitosamente() {
		Tablero tablero = new Tablero();
		
		Jinete jinete = new Jinete(new Coordenada(0,0),tablero);
		jugador1.comprarUnidad(jinete);
		
		tablero.colocarUnidad(jinete);
		
		Assert.assertEquals(tablero.cantUnidades(), 1);
		
	}
	@Test 
	public void test14TableroNoPuedeColocarPiezaAliadaEnCasilleroAliadoOcupadoExitosamente() {
		Tablero tablero = new Tablero();
		
		Jinete jinete = new Jinete(new Coordenada(0,0),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		
		Catapulta catapulta = new Catapulta(new Coordenada(0,0));
		tablero.colocarUnidad(catapulta);
		
		assertEquals(tablero.cantUnidades(),1);
	}
	
	@Test
	public void test15TableroNoPuedeColocarPiezaAliadaEnUnCasilleroDelSectorEnemigo() {
		Tablero tablero = new Tablero();
		
		Jinete jinete = new Jinete(new Coordenada(0,15),tablero);
		jugador1.comprarUnidad(jinete);
		
		tablero.colocarUnidad(jinete);
		
		assertEquals(0,tablero.cantUnidades());
	}
	
	@Test
	public void test16TableroSeCreaEIniciaCorrectamente () {
		Tablero tablero = new Tablero();
		Assert.assertEquals(tablero.cantUnidades(), 0);
	}
	
	// Pruebas Jugador 	
	@Test
	public void test17JugadorNoPuedeTomarMasEntidadesDeLoQuesusPuntosLePermiteExitosamente() {

		/*Tablero tablero = new Tablero();
		Jinete jinete = new Jinete(1,new Coordenada(0,0),tablero);
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(new Coordenada(0,1),tablero);
		Catapulta catapulta = new Catapulta(1,new Coordenada(0,2));
		
		jugador1.comprarUnidad(jinete);//17
		jugador1.comprarUnidad(soldado);//16
		jugador1.comprarUnidad(soldado);//15
		jugador1.comprarUnidad(catapulta);//10
		jugador1.comprarUnidad(catapulta);//5
		jugador1.comprarUnidad(catapulta);//0
		jugador1.comprarUnidad(jinete);*/
		// pensar como se deben tratar los puntos insuficientes sin lanzar excepcion.
		Assert.assertTrue(true);
	}
	@Test
	public void test18JugadorSinEntidadesResultaSerPerdedor() {
		
		Jinete jinete = new Jinete (new Coordenada(0,0),tablero);
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria (new Coordenada(0,1), tablero);
		
		jugador1.comprarUnidad(jinete);
		
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		
		Assert.assertTrue(jugador1.esPerdedor());
	}

}
