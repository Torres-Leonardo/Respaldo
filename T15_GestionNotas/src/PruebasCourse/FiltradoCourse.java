package PruebaCourse;

import Maestros.course;
import Modelos.ModeloCourse;

public class FiltradoCourse {

		public static void main(String[] args) {
			try {
				course curso = new course();
				ModeloCourse bean = curso.getForId("12");
				System.out.println(bean);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}