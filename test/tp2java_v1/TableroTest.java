package tp2java_v1;

import org.junit.Test;
//import org.junit.Assert;
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

}
