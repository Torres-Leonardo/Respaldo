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

import Maestros.users;
import Modelos.ModeloUsers;

@WebServlet({ "/UsersBuscar", "/UsersBuscar2", "/UsersProcesar", "/bbbb" })

public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private users service = new users();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/UsersBuscar":
			buscar(request, response);
			break;
		case "/UsersBuscar2":
			buscar2(request, response);
			break;
		case "/UsersProcesar":
			procesar(request, response);
			break;
		}
	}

	private void procesar(HttpServletRequest request, HttpServletResponse response) {
		// Datos
		String accion = request.getParameter("accion");
		ModeloUsers bean = new ModeloUsers();
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setNames(request.getParameter("names"));
		bean.setLast_name(request.getParameter("last_name"));
		bean.setType_document(request.getParameter("type_document"));
		bean.setNumber_document(request.getParameter("number_document"));
		bean.setType_user(request.getParameter("type_user"));
		bean.setActivate(request.getParameter("activate"));
		bean.setEmail(request.getParameter("email"));
		bean.setCell_phone(request.getParameter("cell_phone"));

		// Proceso
		try {
			switch (accion) {
			case ControllerUtil2.CRUD_NUEVO:
				service.insert(bean);
				break;
			case ControllerUtil2.CRUD_EDITAR:
				service.update(bean);
				break;
			case ControllerUtil2.CRUD_ELIMINAR:
				service.delete(bean.getId().toString());
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + accion);
			}
			ControllerUtil2.responseJson(response, "Proceso exitoso.");
		} catch (Exception e) {
			ControllerUtil2.responseJson(response, e.getMessage());
		}

		// System.out.println("Accion: " + accion);
	}

	private void buscar2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String last_name = request.getParameter("last_name");
		String names = request.getParameter("names");
		// Proceso
		ModeloUsers bean = new ModeloUsers();
		bean.setLast_name(last_name);
		bean.setNames(names);
		List<ModeloUsers> lista = service.get(bean);
		// Preparando el JSON
		Gson gson = new Gson();
		String data = gson.toJson(lista);
		// Reporte
		ControllerUtil2.responseJson(response, data);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Datos
		String last_name = request.getParameter("last_Name");
		String names = request.getParameter("names");
		// Proceso
		ModeloUsers bean = new ModeloUsers();
		bean.setLast_name(last_name);
		bean.setNames(names);
		List<ModeloUsers> lista = service.get(bean);
		// Reporte
		request.setAttribute("listado", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Users.jsp");
		rd.forward(request, response);
	}

}
