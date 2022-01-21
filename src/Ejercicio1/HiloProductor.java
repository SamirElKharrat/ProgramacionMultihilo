package Ejercicio1;

import java.util.concurrent.Exchanger;

/**
 * HiloProductos encargado de crear 15 caracteres en el método run() en un bucle
 * 
 * @author Samir El Kharrat Martín
 *
 */
public class HiloProductor extends Thread {

	// intercambiador de cadena
	private Exchanger<String> inter;

	// Buffer de 6 caracteres como maximo
	String[] buffer = { "", "", "", "", "", "" };

	// bucle para parar el while()
	boolean bucle = true;

	/**
	 * Constructor de la clase HiloProductor
	 * 
	 * @param echger parametro del exchanger
	 */
	HiloProductor(Exchanger<String> echger) {
		inter = echger;

	}

	/**
	 * Método run() donde se crearan los 15 caracteres y se mandaran a
	 * HiloConsumidor
	 */
	@Override
	public void run() {

		// Caracter a enviar
		char ch = 'A';

		// Variable para posiciones del buffer
		int x = 0;

		/**
		 * While donde se producira todo
		 */
		while (bucle) {

			// for() de 15 veces donde se crearan y se mandaran los caracteres
			for (int i = 1; i <= 15; i++) {

				// Condicion para cuando la variable de x sea igual a la longitud del buffer
				// pasar el valor a 0 para controlar las pocisiones del buffer
				if (x == buffer.length)
					x = 0;

				// Añadimos caracter al buffer
				buffer[x] = String.valueOf(ch);

				System.out.println("Productor Crea " + buffer[x]);

				// Sumamos el valor del caracter y de la posicion del buffer
				ch++;
				x++;

				try {

					// for deonde mandaremos los valores del array de derecha a izquierda
					for (int j = buffer.length - 1; j >= 0; j--) {

						// Condicion para solo mandar valores que no esten vacios
						if (buffer[j].equals("")) {

						} else {
							buffer[j] = inter.exchange(buffer[j]);
						}

					}

				} catch (InterruptedException ex) {

				}

			}

			// Cuando acabe el for el booleano cambiara a false para que el while finalize
			bucle = false;

		}

	}
}
