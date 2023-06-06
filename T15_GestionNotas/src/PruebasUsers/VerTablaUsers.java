package PruebasUsers;

import java.util.List;

import Maestros.users;
import Modelos.ModeloUsers;

public class VerTablaUsers {
	public static void main(String[] args) {
		try {
			users usurios = new users();
			List<ModeloUsers> lista = usurios.getAll();
			for (ModeloUsers modelousuarios : lista) {
				System.out.println(modelousuarios);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
