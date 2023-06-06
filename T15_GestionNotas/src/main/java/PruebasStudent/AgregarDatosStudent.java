package PruebasStudent;

import Maestros.student;
import Modelos.ModeloStudent;

public class AgregarDatosStudent {

	public static void main(String[] args) {
		try {
			// Datos
			ModeloStudent bean = new ModeloStudent(0, "jhanpol", "torres", "DNI", "88888888", "mgrados@gmail.com", "981234578", "A","0");
			// Proceso
			student Estudiante = new student();
			Estudiante.insert(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}