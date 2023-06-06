package PruebasStudent;

import java.util.List;

import Maestros.student;
import Modelos.ModeloStudent;

public class FiltradoNombresStudent {
	public static void main(String[] args) {
		try {
			// Datos
			ModeloStudent bean = new ModeloStudent();
			bean.setActivate("  I  ");
			// Proceso
			student student = new student();
			List<ModeloStudent> lista = student.get(bean);
			for (ModeloStudent estudiante : lista) {
				System.out.println(estudiante);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
