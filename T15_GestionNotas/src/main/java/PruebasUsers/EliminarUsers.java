package PruebasUsers;

import Maestros.users;

public class EliminarUsers {
	public static void main(String[] args) {
		try {
			// Datos
			String id = "2";
			// Proceso
			users usuario = new users();
			usuario.delete(id);
			System.out.println("Registro eliminado.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
