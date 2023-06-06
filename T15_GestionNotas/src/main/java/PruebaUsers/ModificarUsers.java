package PruebaUsers;

import Maestros.users;
import Modelos.ModeloUsers;

public class ModificarUsers {
	public static void main(String[] args) {
		try {
			// Datos
			ModeloUsers bean = new ModeloUsers(14,"CNE","897656789","A","LEONARDITO","SANCHEZ","CARLOS@gmail.com","987676567","A");
			// Proceso
			users usuario = new users();
			usuario.update(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
