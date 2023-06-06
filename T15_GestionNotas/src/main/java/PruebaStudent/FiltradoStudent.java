package PruebaStudent;

import Maestros.student;
import Modelos.ModeloStudent;

public class FiltradoStudent {

		public static void main(String[] args) {
			try {
				student estudiante = new student();
				ModeloStudent bean = estudiante.getForId("10");
				System.out.println(bean);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
