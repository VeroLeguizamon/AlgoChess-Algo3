package tp2java_v1;

import org.junit.Test;

import tp2java_v1.entidades.Jinete;
import tp2java_v1.entidades.SoldadoDeInfanteria;
import tp2java_v1.excepciones.CeldaEstaOcupadaExcepcion;
import tp2java_v1.excepciones.CeldaNoPerteneceAlSector;

import tp2java_v1.tablero.*;


public class TableroTest {
	@Test
	public void ocuparUnaCeldayVerificoQueEstaOcupada(){
		Coordenada coordenada=new Coordenada(0,3);
		Celda celda=new Celda(coordenada);
		celda.ocupada();
		org.junit.Assert.assertTrue(celda.estaOcupada());
		org.junit.Assert.assertTrue(celda.sectorEs()==0);
		
	}
	@Test
	public void test01SeColocaUnaEntidadAliadaEnUnSectorAliadoConExito(){
		Tablero tablero=new Tablero();
		//la entidad pertenece a un sector que en este caso lo pasamos por parametro y lo que hacemos es
		//colocarlo en el primer parametro que son las coordenadas.
		
		SoldadoDeInfanteria soldado=new SoldadoDeInfanteria(1,new Coordenada(3, 3));
		tablero.agregarEntidad(soldado);
		org.junit.Assert.assertTrue(tablero.cantEntidades()==1);
		
	}
	@Test (expected=CeldaEstaOcupadaExcepcion.class)
	public void test02SeVerificaQueNoSeColocaUnaPiezaAliadaEnUnCasilleroDelSectorAliadoOcupado() {
		Tablero tablero=new Tablero();
		//ocupamos un celda
		SoldadoDeInfanteria soldado=new SoldadoDeInfanteria(2,new Coordenada(3,11));
		tablero.agregarEntidad(soldado);
		//ocupemos a jinete en la misma celda y nos mostrara la excepcion de celda ocupada
		Jinete jinete=new Jinete(2, new Coordenada(3,11));
		tablero.agregarEntidad(jinete);
		
	}
	@Test (expected = CeldaNoPerteneceAlSector.class)
	public void test03SeVerificaQueNoSePuedeColocarUnaPiezaAliadaEnUnCasilleroDelSectorEnemigo() {
		Tablero tablero=new Tablero();
		//soldado pertenece a sector 1 y lo queremos colocar en la coordenada (3,11) que es sector 
		//lanza la excepcion.
		SoldadoDeInfanteria soldado=new SoldadoDeInfanteria(1,new Coordenada(3,11));
		tablero.agregarEntidad(soldado);
	}

}
