package org.iesalandalus.programacion.torreajedrez;


public class Posicion {
	private int fila;
	private char columna;

	// Creamos constructor  de Posicion y esta formado por fila y culumna, pero esta 
	public Posicion (int fila, char columna) {
		setFila (fila);
		setColumna(columna);
	}
	
	
	public Posicion (Posicion posicion) {
		if (posicion == null ) {
			throw new NullPointerException ("ERROR: No es posible copiar una posición nula.");
		}
		setFila(posicion.getFila());
		setColumna(posicion.getColumna());
	}
	
	public int getFila() {
		return fila;
	}

	private void setFila(int fila) {
		//comprobamos que las filas esten entre 1 y 8
		if (fila<1 || fila > 8) {
			// si no estan entre esos numeros nos lanza un error THROW NEW IllegalArgumentException 
			throw new IllegalArgumentException ("ERROR: la fila tiene que ser mayor que 1 y menor que 8");
			// en caso de que los valores esten dentro de 1 y 8 el valor de fila sera el de fila
		}else {
			this.fila = fila;
		}
	}
	public char getColumna() {
		return columna;
	}

	private void setColumna(char columna) {
		// comprobamos que las filas esten entre a y h
		if (columna < 'a' || columna > 'h') {
			// si no estan entre esos numeros nos lanza un error THROW NEW
			// IllegalArgumentException
			throw new IllegalArgumentException("ERROR: la columna tiene que ser estar entre a y h");
			// en caso de que los valores esten dentro de a y h el valor de columna sera el
			// de columna
		} else {
			this.columna = columna;
		}
	}

}

