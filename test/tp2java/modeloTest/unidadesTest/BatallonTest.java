package tp2java.modeloTest.unidadesTest;



import static org.junit.Assert.assertEquals;



import org.junit.Test;

import java.util.ArrayList;





import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Direccion;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Batallon;
import tp2java.modelo.unidades.Catapulta;
import tp2java.modelo.unidades.SoldadoDeInfanteria;



public class BatallonTest {
	private SoldadoDeInfanteria soldado1,soldado2,soldado3,soldado4;
	
	private Jugador jugador1;
	private Tablero tablero;
	private Catapulta catapulta;
	
	
	@Test
	public void test01SeVerificaQue3SoldadosContiguosPuedenMoverseAlMismoTiempoEnLaMismaDireccion(){
		jugador1 = new Jugador("Player1",0,9);
		Batallon batallon = null;
		tablero=new Tablero();
		soldado1 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,2),tablero);
		soldado2 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,3),tablero);
		soldado3 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,4),tablero);
		
		
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);
		tablero.colocarUnidad(soldado3);
		
		if(tablero.existeBatallon(soldado2)) {
			ArrayList<SoldadoDeInfanteria>soldados=new ArrayList<SoldadoDeInfanteria>();
			soldados=tablero.obtenerBatallon(soldado2);
			batallon=new Batallon(soldados);
		}	
		
		
        
		batallon.mover(Direccion.ABAJO);
		
		
    	assertEquals(Direccion.ABAJO.calcularCoordenada(new Coordenada(2,2)), soldado1.getUbicacion());
		assertEquals(Direccion.ABAJO.calcularCoordenada(new Coordenada(2,3)), soldado2.getUbicacion());
		assertEquals(Direccion.ABAJO.calcularCoordenada(new Coordenada(2,4)), soldado3.getUbicacion());
	}
	
	@Test 
	public void test02TenemosBatallonYUnaCatapultaQueEsUnObstaculoDeUnSoldadoEntoncesVerificamosQueElNoSeMueve() {
		jugador1 = new Jugador("Player1",0,9);
		tablero=new Tablero();
		Batallon batallon=null;
		soldado1 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,2),tablero);
		soldado2 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,3),tablero);
		soldado3 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,4),tablero);
		catapulta=new Catapulta(jugador1,new Coordenada(1,3), tablero);
		
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);
		tablero.colocarUnidad(soldado3);
		tablero.colocarUnidad(catapulta);
		
		
		if(tablero.existeBatallon(soldado2)) {
			ArrayList<SoldadoDeInfanteria>soldados=new ArrayList<SoldadoDeInfanteria>();
			soldados=tablero.obtenerBatallon(soldado2);
			batallon=new Batallon(soldados);
		}
		
		batallon.mover(Direccion.IZQUIERDA);
		
		
		assertEquals(Direccion.IZQUIERDA.calcularCoordenada(new Coordenada(2,2)), soldado1.getUbicacion());
		assertEquals(new Coordenada(2,3), soldado2.getUbicacion());
		assertEquals(Direccion.IZQUIERDA.calcularCoordenada(new Coordenada(2,4)), soldado3.getUbicacion());
		
		
	}
	
	@Test 
	public void test03TenemosBatallonYUnaCatapultaQueEsUnObstaculoDeUnSoldadoEntoncesNoTendremosMasBatallon() {
		jugador1 = new Jugador("Player1",0,9);
		tablero=new Tablero();
		Batallon batallon=null;
		soldado1 = new SoldadoDeInfanteria(jugador1,new Coordenada(1,2),tablero);
		soldado2 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,2),tablero);
		soldado3 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,3),tablero);
		catapulta=new Catapulta(jugador1,new Coordenada(1,3), tablero);
		
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);
		tablero.colocarUnidad(soldado3);
		tablero.colocarUnidad(catapulta);
		
		
		if(tablero.existeBatallon(soldado2)) {
			ArrayList<SoldadoDeInfanteria>soldados=new ArrayList<SoldadoDeInfanteria>();
			soldados=tablero.obtenerBatallon(soldado2);
			batallon=new Batallon(soldados);
		}
			

		batallon.mover(Direccion.IZQUIERDA);
		
		
		assertEquals(tablero.existeBatallon(soldado3), false);
	}
	
	@Test
	public void test04ExistenCuatroSoldadosContiguoSeVerificaQueAlMoverSoloSeMuevenTresSoldadosSiCorresponde() {
		jugador1 = new Jugador("Player1",0,9);
		tablero=new Tablero();
		Batallon batallon=null;
		soldado1 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,2),tablero);
		soldado2 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,3),tablero);
		soldado3 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,4),tablero);
		soldado4 = new SoldadoDeInfanteria(jugador1,new Coordenada(1,4),tablero);
		
		
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);
		tablero.colocarUnidad(soldado3);
		tablero.colocarUnidad(soldado4);
		
		
		if(tablero.existeBatallon(soldado2)) {
			ArrayList<SoldadoDeInfanteria>soldados=new ArrayList<SoldadoDeInfanteria>();
			soldados=tablero.obtenerBatallon(soldado2);
			batallon=new Batallon(soldados);
		}
			
		
		batallon.mover(Direccion.DERECHA);
		
		
		assertEquals(Direccion.DERECHA.calcularCoordenada(new Coordenada(2,2)), soldado1.getUbicacion());
		assertEquals(Direccion.DERECHA.calcularCoordenada(new Coordenada(2,3)), soldado2.getUbicacion());
		assertEquals(Direccion.DERECHA.calcularCoordenada(new Coordenada(2,4)), soldado3.getUbicacion());
		assertEquals(new Coordenada(1, 4), soldado4.getUbicacion());
		
	}

	
}



