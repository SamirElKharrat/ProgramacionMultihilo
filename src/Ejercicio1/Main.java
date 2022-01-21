package Ejercicio1;

import java.util.concurrent.Exchanger;

/**
 * Hilo principal de la aplicacion que creara dos hilos con un 
 * Exchanger
 * 
 * El HiloConsumidor imprimira lo recogido del otro hilo
 * 
 * 
 * @author Samir El Kharrat Martín
 *
 */
public class Main {

	public static void main(String[] args) {
		//Exchanger para la cadena
		Exchanger<String> exgr = new Exchanger<String>();

		
		//Inicio del HiloProductor
		HiloProductor productor = new HiloProductor(exgr);
		productor.start();

		//Inicio del HiloConsumidor
		(new HiloConsumidor(exgr)).start();

	}

}
