package PruebaUsers;

import java.util.List;

import Maestros.users;
import Modelos.ModeloUsers;

public class FiltradoNombresUsers {
	public static void main(String[] args) {
		try {
			// Datos
			ModeloUsers bean = new ModeloUsers();
			bean.setNames("  LEONARDITO ");
			// Proceso
			users user = new users();
			List<ModeloUsers> lista = user.get(bean);
			for (ModeloUsers usuario : lista) {
				System.out.println(usuario);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
