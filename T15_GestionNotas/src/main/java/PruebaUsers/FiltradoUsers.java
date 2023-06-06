package PruebaUsers;

import Maestros.users;
import Modelos.ModeloUsers;

public class FiltradoUsers {

		public static void main(String[] args) {
			try {
				users usuario = new users();
				ModeloUsers bean = usuario.getForId("12");
				System.out.println(bean);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
