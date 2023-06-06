package Plantilla;

public class UtilService2 {
	private UtilService2() {
	}

	public static String setStringVacio(String dato) {
		if (dato == null) {
			dato = "";
		}
		dato = dato.trim(); // Para pensarlo
		return dato;
	}
}
