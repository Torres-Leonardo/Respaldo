package PruebaCourse;

import java.util.List;

import Maestros.course;
import Modelos.ModeloCourse;

public class FiltradoNombresCourse {
	public static void main(String[] args) {
		try {
			// Datos
			ModeloCourse bean = new ModeloCourse();
			bean.setCourse_name("  1 ");
			// Proceso
			course curso = new course();
			List<ModeloCourse> lista = curso.get(bean);
			for (ModeloCourse cursos : lista) {
				System.out.println(cursos);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}