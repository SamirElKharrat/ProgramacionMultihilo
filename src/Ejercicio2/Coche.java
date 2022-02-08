package Ejercicio2;

import java.util.concurrent.Semaphore;

/**
 * Clase Coche donde se gestionara lo que hacen los hilo
 * 
 * @author SamirZSP
 *
 */
public class Coche extends Thread {

	// Clase parking para gestionar los métodos de la clase
	private Parking parking = new Parking();

	// Clase Semaphore para controlar las entradas y salidas
	private Semaphore semaforo;

	// boolean bucle para el while
	private boolean bucle = true;

	// boolean entro para gestionar si el coche entro
	private boolean entro = false;

	/**
	 * 
	 * Constructor de la clase donde se le pasaran parametros
	 * 
	 * @param parking  Clase parking para gestionar los métodos de la clase
	 * @param semaforo Clase Semaphore para controlar las entradas y salidas
	 */
	public Coche(Parking parking, Semaphore semaforo) {
		this.parking = parking;
		this.semaforo = semaforo;

	}

	/**
	 * Método sobrescrito run() de la clase Thread donde se gestionara lo que haga
	 * el hilo
	 */
	@Override
	public void run() {

		// While infinito para que los hilos entran y salgan indefinidamente
		while (bucle) {

			try {

				// El semaforo si esta en verde dejara coger el recurso y si esta en rojo ya
				// esta en uso por otro hilo
				semaforo.acquire();

			} catch (InterruptedException ex) {
			}

			// Llama al método de la clase Parking
			entro = parking.plazaOcupada();

			// Método sleep para dormir aleatoriamente al hilo
			try {
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				System.out.println(e);
			}

			// Deja el semaforo en verde y el recurso disponible de nuevo
			semaforo.release();

			// Condicion para ver si el coche entro para poder salir
			if (entro == true) {
				try {

					// El semaforo si esta en verde dejara coger el recurso y si esta en rojo ya
					// esta en uso por otro hilo
					semaforo.acquire();

				} catch (InterruptedException ex) {
				}

				// Llama al método de la clase Parking
				parking.plazaLibre();

				// Método sleep para dormir aleatoriamente al hilo
				try {
					sleep((int) (Math.random() + 1000));
				} catch (InterruptedException e) {
					System.out.println(e);
				}

				// Deja el semaforo en verde y el recurso disponible de nuevo
				semaforo.release();

			}

		}

	}

	// Método para finalizar el bucle
	public void finalizar() {
		bucle = false;
	}

}