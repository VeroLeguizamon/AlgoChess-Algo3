package controladores;

import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Direccion;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Unidad;
import tp2java.modelo.unidades.UnidadMovible;
import vista.ContenedorJuego;
import vista.VistaCelda;
import vista.VistaUnidad;

public class MoverUnidadEventHandler implements EventHandler<ActionEvent>{
	
	private VistaCelda vistaCelda;
	private Tablero tablero;
	private ContenedorJuego contenedorJuego;
	
	private String movimientoSelecc;
	public MoverUnidadEventHandler(VistaCelda vistaCelda,Tablero tablero, ContenedorJuego contenedorJuego ) {
		this.contenedorJuego=contenedorJuego;
		this.vistaCelda=vistaCelda;
		this.tablero=tablero;
		
	}
	
	
	public Direccion movimientoEs() {
		Scanner sc = new Scanner(System.in);
		char tecla = sc.next().charAt(0);
		
		sc.close();
		
		System.out.println("la tecla es "+tecla);
		if(tecla=='w') {return Direccion.ARRIBA;}
//		if(tecla=='x') {return Direccion.ABAJO;}
//		if(tecla=='a') {return Direccion.IZQUIERDA;}
//		if(tecla=='d') {return Direccion.DERECHA;}
		
		
		return null;
		
		
	}
	
	//la unidad se puede mover esos ya esta validado con anterioridad
	
	@Override
	public void handle(ActionEvent event) {
//		Direccion mov = null;
//		Scanner sc =new Scanner(System.in);
//		char tecla=sc.next().charAt(0);
//		
//		
//		System.out.println("la tecla es "+tecla);
		
		
		
		Unidad unidadVista=vistaCelda.getVistaUnidad().getUnidad();
		
		if (tablero.sePuedeMoverUnidad(Direccion.ARRIBA.calcularCoordenada(unidadVista.getUbicacion()))) {

			((UnidadMovible)unidadVista).mover(Direccion.ARRIBA);
			contenedorJuego.getVistaTablero().actualizarTablero(tablero);
			
			contenedorJuego.resetSeleccionado();
//			
		}
		
	}

}
