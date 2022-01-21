package Ejercicio1;

import java.util.concurrent.Exchanger;

/**
 * 
 * HiloConsumidor donde llegaran los valores del Productor para mostrarlos por
 * consola mediante el método run() y la clase Exchange
 * 
 * @author Samir El Kharrat Martín
 *
 */
public class HiloConsumidor extends Thread {

	// intercambiador de cadena
	final Exchanger<String> inter;

	// String donde pondremos los valores entregados
	String str;

	// Variable para controlar el while()
	int i = 0;

	/*
	 * Constructor de la Clase HiloConsumidor
	 * 
	 * @param echger parametro del exchanger
	 */
	HiloConsumidor(Exchanger<String> echger) {
		inter = echger;

	}

	/**
	 * Método run() donde se recogeran los 15 caracteres y se mostraran en pantalla
	 */
	@Override
	public void run() {

		// while() que estara sumando i + 1 hasta llegar a 15
		while (i <= 15) {

			// while() que mientrar str sea nulo o la longitud mayor a 0 enseñara los
			// mensajes
			while (str == null || str.length() > 0) {
				try {

					// Llama a exchange para intercambiador el caracter vacio por el caracter que
					// enviara HiloProductor
					str = inter.exchange("");

					if (str.length() > 0) {

						System.out.println("Consumidor Escribe " + str);
					}

				} catch (InterruptedException ex) {

				}

				// Se suma la variable i
				i++;

			}
		}
	}

}
