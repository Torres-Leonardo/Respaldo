package PruebasStudent;

import Maestros.student;
import Modelos.ModeloStudent;

public class AgregarDatosStudent {

	public static void main(String[] args) {
		try {
			// Datos
			ModeloStudent bean = new ModeloStudent(0, "luis", "torres", "DNI", "78963639", "CARLA@gmail.com", "987987987", "I");
			// Proceso
			student Estudiante = new student();
			Estudiante.insert(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}