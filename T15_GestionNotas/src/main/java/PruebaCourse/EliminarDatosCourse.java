package PruebaCourse;

import Maestros.course;

public class EliminarDatosCourse {
	public static void main(String[] args) {
		try {
			// Datos
			String id = "1";
			// Proceso
			course Notas = new course();
			Notas.delete(id);
			System.out.println("Registro eliminado.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}