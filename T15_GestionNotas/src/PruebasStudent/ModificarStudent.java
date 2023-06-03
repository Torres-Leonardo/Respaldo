package PruebasStudent;

import Maestros.student;
import Modelos.ModeloStudent;

public class ModificarStudent {
	public static void main(String[] args) {
		try {
			// Datos
			ModeloStudent bean = new ModeloStudent(1,"HOLA","COMOESTAS","DNI","72762052","z@gmail.com","986532741","A");
			// Proceso
			student student = new student();
			student.update(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
