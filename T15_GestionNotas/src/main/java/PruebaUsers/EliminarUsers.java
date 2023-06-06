package PruebaUsers;

import Maestros.student;

public class EliminarUsers {
	public static void main(String[] args) {
		try {
			// Datos
			String id = "1";
			// Proceso
			student student = new student();
			student.delete(id);
			System.out.println("Registro eliminado.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
