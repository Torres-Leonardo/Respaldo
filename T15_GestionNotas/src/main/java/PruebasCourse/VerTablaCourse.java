package PruebasCourse;

import java.util.List;

import Maestros.course;
import Modelos.ModeloCourse;

public class VerTablaCourse {
	public static void main(String[] args) {
		try {
			course notas = new course();
			List<ModeloCourse> lista = notas.getAll();
			for (ModeloCourse modelocurso : lista) {
				System.out.println(modelocurso);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
