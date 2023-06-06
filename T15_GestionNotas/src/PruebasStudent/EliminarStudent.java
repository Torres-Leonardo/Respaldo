package PruebasStudent;

import Maestros.student;

public class EliminarStudent {
	public static void main(String[] args) {
		try {
			// Datos
			String identifier = "2";
			// Proceso
			student student = new student();
			student.delete(identifier);
			System.out.println("Registro eliminado.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
