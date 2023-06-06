package PruebaUsers;

import Maestros.users;
import Modelos.ModeloUsers;

public class AgregarDatosUsers {
	public static void main(String[] args) {
		try {
			// Datos
			ModeloUsers bean = new ModeloUsers(0, "DNI", "88748893", "A", "MIGUEL", "ARMAS", "MIGUEL@gmail.com", "987678592", "A");
			// Proceso
			users Usuario = new users();
			Usuario.insert(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
