package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import Modelos.ModeloStudent;
import Maestros.student;

@WebServlet({ "/StudentBuscar", "/StudentBuscar2", "/StudentProcesar", "/bbbb" })
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private student service = new student();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/StudentBuscar":
			buscar(request, response);
			break;
		case "/StudentBuscar2":
			buscar2(request, response);
			break;
		case "/StudentProcesar":
			procesar(request, response);
			break;
		}
	}

	private void buscar2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String last_name = request.getParameter("last_name");
		String names = request.getParameter("names");
		// Proceso
		ModeloStudent bean = new ModeloStudent();
		bean.setLast_name(last_name);
		bean.setNames(names);
		List<ModeloStudent> lista = service.get(bean);
		// Preparando el JSON
		Gson gson = new Gson();
		String data = gson.toJson(lista);
		// Reporte
		ControllerUtil.responseJson(response, data);
	}

	private void procesar(HttpServletRequest request, HttpServletResponse response) {
		//Datos
		String accion = request.getParameter("accion");
		ModeloStudent bean = new ModeloStudent();
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setNames(request.getParameter("names"));
		bean.setLast_name(request.getParameter("last_name"));
		bean.setType_document(request.getParameter("type_document"));
		bean.setNumber_document(request.getParameter("number_document"));
		bean.setEmail(request.getParameter("email"));
		bean.setCell_phone(request.getParameter("cell_phone"));
		bean.setActivate(request.getParameter("activate"));
		bean.setGrade_identifier(request.getParameter("grade_identifier"));
		
		 //Proceso
		try {
			switch (accion) {
			case ControllerUtil.CRUD_NUEVO: 
				service.insert(bean);
				break;
			case ControllerUtil.CRUD_EDITAR: 
				service.update(bean);
				break;
			case ControllerUtil.CRUD_ELIMINAR: 
				service.delete(bean.getId().toString());
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + accion);
			}
			ControllerUtil.responseJson(response, "Proceso exitoso.");
		} catch (Exception e) {
			ControllerUtil.responseJson(response, e.getMessage());
		}
		
		//System.out.println("Accion: " + accion);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Datos
		String last_name = request.getParameter("last_Name");
		String names = request.getParameter("names");
		// Proceso
		ModeloStudent bean = new ModeloStudent();
		bean.setLast_name(last_name);
		bean.setNames(names);
		List<ModeloStudent> lista = service.get(bean);
		// Reporte
		request.setAttribute("listado", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Estudiante.jsp");
		rd.forward(request, response);
	}

}
