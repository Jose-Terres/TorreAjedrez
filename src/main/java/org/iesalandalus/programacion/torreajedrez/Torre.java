package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

// Creamos la clase Torre con los atributos Color y Posicion
public class Torre {
	private Color color;
	private Posicion posicion;

	// creamos constructor por defecto, el nombre siempre es el mismo que el de la
	// clase
	public Torre() {
		// Llamamos al método setcolor y luego le metemos como parametro Color.Negro por
		// fedecto.
		setColor(Color.NEGRO);
		// Llamamos al método setcolor y luego le metemos como parametro Color.Negro por
		// fedecto.
		setPosicion(new Posicion(8, 'h'));
	}

	// creamos constructor que acepta como parámetro un color, el nombre siempre es
	// el mismo que el de la clase
	public Torre(Color color) {

		// llamamos al constructor al que le metemos la variable que nos han introducido
		// color
		setColor(color);

		// comprobamos que el parametro color es igual a Color.NEGRO la posicion tiene
		// que ser 8,h
		if (color.equals(Color.NEGRO)) {
			setPosicion(new Posicion(8, 'h'));
			// En caso de que el color no sea igual a Color,NEGRO la posicion tiene que ser
			// 8,h
		} else {
			setPosicion(new Posicion(1, 'h'));
		}

	}

	// Creamos constructor que acepte como parametro color y columna

	public Torre(Color color, char columna) {
		setColor(color);
		if (columna == 'a' || columna == 'h') {

			if (color.equals(Color.NEGRO)) {
				setPosicion(new Posicion(8, columna));

			} else {
				setPosicion(new Posicion(1, columna));
			}
		} else {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}

	}
	// ejercicio 16 Creamos el metodo Mover

	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		if (pasos < 1 || pasos > 7) {
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
		}

		int fila = posicion.getFila();
		int columna = posicion.getColumna();
		if (color == Color.BLANCO) {
			switch (direccion) {
			case ARRIBA:
				fila = fila + pasos;
				break;
			case ABAJO:
				fila = fila - pasos;
				break;
			case IZQUIERDA:
				columna = columna - pasos;
				break;
			case DERECHA:
				columna = columna + pasos;
				break;
			default:
				break;
			}
		} else {
			switch (direccion) {
			case ARRIBA:
				fila = fila - pasos;
				break;
			case ABAJO:
				fila = fila + pasos;
				break;
			case IZQUIERDA:
				columna = columna + pasos;
				break;
			case DERECHA:
				columna = columna - pasos;
				break;
			default:
				break;
			}
		}
		if (fila < 1 || fila > 8 || columna < 97 || columna > 104) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
		} else {
			setPosicion(new Posicion(fila, (char) columna));
		}
	}

	// creamos metodo enrocar
	public void enrocar(Direccion direccionValida) throws OperationNotSupportedException {
		if (direccionValida == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		if (direccionValida == Direccion.ENROQUE_CORTO) {
			if (posicion.getColumna() == 'h') {
				if (posicion.getFila() == 8 && color == Color.NEGRO) {
					mover(Direccion.DERECHA, 2);
				} else if (posicion.getFila() == 1 && color == Color.BLANCO) {
					mover(Direccion.IZQUIERDA, 2);
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
			}else {
				throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
			}
		} else {
			if (posicion.getColumna() == 'a') {
				if (posicion.getFila() == 8 && color == Color.NEGRO) {
					mover(Direccion.IZQUIERDA, 3);
				} else if (posicion.getFila() == 1 && color == Color.BLANCO) {
					mover(Direccion.DERECHA, 3);
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
			}else {
				throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
			}
		}
	}

	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {

		// comprobamos que si mete un color que sea null nos salte un ERROR (solo son
		// correctos BLANCO y NEGRO)
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
		this.color = color;
	}

	public Posicion getPosicion() {
		return new Posicion(posicion);
	}

	// en el seter hacemos la comprobacion de que la posicion no sea igual a null
	private void setPosicion(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("ERROR: La posicion .");
		}
		// la posicion tiene que ser igual a la posicion con el parametro que nos
		// pasamos
		this.posicion = new Posicion(posicion);
	}

}
