package org.iesalandalus.programacion.torreajedrez;


// Creamos la clase Torre con los atributos Color y Posicion
public class Torre {
	private Color  color;
	private Posicion posicion;
		
	// creamos constructor por defecto, el nombre siempre es el mismo que el de la clase
	public Torre() {
		//Llamamos al método setcolor y luego le metemos como parametro Color.Negro por fedecto.
		setColor(Color.NEGRO);
		//Llamamos al método setcolor y luego le metemos como parametro Color.Negro por fedecto.
		setPosicion(new Posicion(8,'h'));
	}
	
	public Color getColor() {
		return color;
	}
	private void setColor(Color color) {
		this.color = color;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	
	
}
