package PruebaCourse;

import Maestros.course;
import Modelos.ModeloCourse;

public class AgregarDatosCourse {
	
	public static void main(String[] args) {
		try {
			// Datos
			ModeloCourse bean = new ModeloCourse(0, "Mate");
			// Proceso
			course Curso = new course();
			Curso.insert(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}