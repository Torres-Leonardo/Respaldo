package Controller;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class ControllerUtil2 {
	
	private ControllerUtil2() {
	}
	
	// Constantes del CRUD
	public final static String CRUD_NUEVO = "NUEVO";
	public final static String CRUD_EDITAR = "EDITAR";
	public final static String CRUD_ELIMINAR = "ELIMINAR";
	
	
	public static void responseJson(HttpServletResponse response, String data) {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(data);
			out.flush();
		} catch (Exception e) {
		}
	}
}
