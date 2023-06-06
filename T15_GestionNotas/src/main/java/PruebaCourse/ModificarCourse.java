package PruebaCourse;

import Maestros.course;
import Modelos.ModeloCourse;

public class ModificarCourse {
	public static void main(String[] args) {
		try {
			// Datos
			ModeloCourse bean = new ModeloCourse(14,"1");
			// Proceso
			course cursos = new course();
			cursos.update(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}