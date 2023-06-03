package PruebasStudent;

import Maestros.student;
import Modelos.ModeloStudent;

import java.util.List;

public class VerTablaStudent {
	 public static void main(String[] args) {
		try {
			student estudiante = new student();
			List<ModeloStudent> lista = estudiante.getAll();
			for (ModeloStudent modeloestudiante : lista) {
				System.out.println(modeloestudiante);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
