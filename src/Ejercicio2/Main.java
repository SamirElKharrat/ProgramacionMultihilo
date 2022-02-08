package Ejercicio2;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(4);
		Parking parking = new Parking();

		//Creacion de cada hilo
		Coche coche1 = new Coche(parking, semaforo);
		Coche coche2 = new Coche(parking, semaforo);
		Coche coche3 = new Coche(parking, semaforo);
		Coche coche4 = new Coche(parking, semaforo);
		Coche coche5 = new Coche(parking, semaforo);
		Coche coche6 = new Coche(parking, semaforo);

		//Iniciacion de los hilo
		coche1.start();
		coche2.start();
		coche3.start();
		coche4.start();
		coche5.start();
		coche6.start();

		
		//Método sleep para dormir el hilo Main
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		//Finalizacion de los hilos
		coche1.finalizar();
		coche2.finalizar();
		coche3.finalizar();
		coche4.finalizar();
		coche5.finalizar();
		coche6.finalizar();

	}

}
