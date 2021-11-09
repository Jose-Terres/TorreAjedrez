package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
	private int fila;
	private char columna;

	// Creamos constructor de Posicion y esta formado por fila y culumna, y los
	// parametros tienen que llevar el tip ejem int fila
	public Posicion(int fila, char columna) {
		// nos pide que le demos los valores por lo que seria setFIla setColumna
		setFila(fila);
		setColumna(columna);
	}

	// Creamos el constructor copia donde public Posicion es un constructor y
	// (Posicion ) estos son parametros (por defecto los parametros son los mismos
	// que le metodo fila y columna)
	// y pueden tener sobrecarga o duplicidad
	public Posicion(Posicion posicion) {
		// siempre comprobamos que sea nulo position == null en cullo caso...
		if (posicion == null) {
			// lanzamos THROW nueva NEWNullPointerException
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		}
		// si no es nulo asignamos los valores de la fila y la columna(directamente
		// cogemos set que ya esta validado
		setFila(posicion.getFila());
		setColumna(posicion.getColumna());
	}

	public int getFila() {
		return fila;
	}

	private void setFila(int fila) {
		// comprobamos que las filas esten entre 1 y 8
		if (fila < 1 || fila > 8) {
			// si no estan entre esos numeros nos lanza un error THROW NEW
			// IllegalArgumentException
			throw new IllegalArgumentException("ERROR: Fila no válida.");
			// en caso de que los valores esten dentro de 1 y 8 el valor de fila sera el de
			// fila
		} else {
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
			throw new IllegalArgumentException("ERROR: Columna no válida.");
			// en caso de que los valores esten dentro de a y h el valor de columna sera el
			// de columna
		} else {
			this.columna = columna;
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "fila=" + fila + ", columna=" + columna;
	}



}
