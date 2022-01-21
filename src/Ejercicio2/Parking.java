package Ejercicio2;

/**
 * Clase Parking donde se gestionaran las entradas y salidas de los hilos
 * "coches"
 * 
 * @author Samir El Kharrat Martín
 *
 */
public class Parking {

	// array para mostrar en string el numero de plaza
	private int[] numparkingficticio = { 7, 4, 3, 8, 1 };

	// array para gestionar las plazas del parking
	private boolean[] plazasdis = { true, true, true, true, true };

	// variable para gestionar las plazas disponibles
	private int plazas;

	// variable booleana para gestionar si un hilo puede salir si ha podido entrar o
	// no al parking
	boolean entro = false;

	/**
	 * Constructor de la clase Parking donde se inicializa plaza con la longitud de
	 * la array
	 */
	public Parking() {
		plazas = numparkingficticio.length;
	}

	/**
	 * 
	 * Método plazaOcupada donde se gestionara las entradas al parking
	 * 
	 * @return booleano para gestionar si el hilo entro o no al parking
	 */
	public boolean plazaOcupada() {

		//for donde recorrera la array buscando plazas libres y al encontrarlas la llenara y acaba el for
		for (int i = 0; i < numparkingficticio.length; i++) {
			if (plazasdis[i] == true) {
				plazasdis[i] = false;

				System.out.println("Coche " + Thread.currentThread().getName() + " Entra al parking y aparca en "
						+ numparkingficticio[i]);

				plazas--;
				System.out.println("Plazas libres: " + plazas);
				System.out.println("Parking [7] [4] [3] [8] [1]");
				entro = true;
				break;
			} else {

			}

		}

		//retorno booleano
		return entro;

	}

	/**
	 * 
	 * Método plazaLibre donde se gestionara la salida del parking
	 * 
	 */
	public void plazaLibre() {

		//for donde recorrera la array viendo si la plaza esta ocupada y saliendo de ella
		for (int i = 0; i < numparkingficticio.length; i++) {
			if (plazasdis[i] == false) {
				plazasdis[i] = true;
				System.out.println("Coche " + Thread.currentThread().getName() + " Sale del parking");
				plazas++;
				System.out.println("Plazas libres: " + plazas);
				System.out.println("Parking [7] [4] [3] [8] [1]");
				break;
			} else {

			}

		}

	}

}
