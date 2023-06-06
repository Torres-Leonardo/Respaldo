package Maestros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Acceso.AccesoDB;
import Modelos.ModeloCourse;
import Plantilla.CRUD.CrudServiceSpec;
import Plantilla.RowMapper3;

public class course implements CrudServiceSpec<ModeloCourse>, RowMapper3<ModeloCourse>{

	private final String SQL_SELECT_BASE = "SELECT identifier, course_name FROM course";
	private final String SQL_INSERT = "INSERT INTO note(identifier, course_name) VALUES(?,?)";
	private final String SQL_UPDATE = "UPDATE course course_name=? SET WHERE identifier=?";
	private final String SQL_DELETE = "DELETE FROM course WHERE identifier=?";
	
	/**
	 * Mostrar toda la tabla de curso.
	 */
	@Override
	public List<ModeloCourse> getAll() {
		// Variables
				Connection cn = null;
				List<ModeloCourse> lista = new ArrayList<>();
				PreparedStatement pstm = null;
				ResultSet rs = null;
				ModeloCourse bean;
				// Proceso
				try {
					cn = AccesoDB.getConnection();
					pstm = cn.prepareStatement(SQL_SELECT_BASE);
					rs = pstm.executeQuery();
					while (rs.next()) {
						bean = mapRow(rs);
						lista.add(bean);
					}
					rs.close();
					pstm.close();
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				} finally {
					try {
						cn.close();
					} catch (Exception e2) {
					}
				}
				return lista;
	}

	/**
	 * Realiza la busqueda por ID.
	 */
	@Override
	public ModeloCourse getForId(String id) {
		// Variables
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ModeloCourse bean = null;
		String sql;
		// Proceso
		try {
			cn = AccesoDB.getConnection();
			sql = SQL_SELECT_BASE + " WHERE Identifier=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, Integer.parseInt(id));
			rs = pstm.executeQuery();
			if (rs.next()) {
				bean = mapRow(rs);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
		return bean;
	}


	/**
	 * Insertar datos.
	 */
	@Override
	public void insert(ModeloCourse bean) {
		// Variables
		Connection cn = null;
		String sql = null;
		PreparedStatement pstm = null;
		ResultSet rs;
		Integer id = 0;
		// Proceso
		try {
			// Iniciar la Tx
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Traer contador
			sql = "SELECT valor FROM controller WHERE parametro='course'";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				rs.close();
				pstm.close();
				throw new SQLException("Contador de student no existe.");
			}
			id = Integer.parseInt(rs.getString("valor"));
			rs.close();
			pstm.close();
			// Actualizar contador
			id++;
			sql = "UPDATE controller SET valor = ? WHERE parametro='course'";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, id + "");
			pstm.executeUpdate();
			pstm.close();
			// Insertar nuevo empleado
			pstm = cn.prepareStatement(SQL_INSERT);
			pstm.setString(1, id + "");
			pstm.setString(2, bean.getCourse_name());
			pstm.executeUpdate();
			pstm.close();
			// Fin de Tx
			bean.setIdentifier(id);
			cn.commit();
		} catch (SQLException e) {
			try {
				cn.rollback();
				cn.close();
			} catch (Exception e2) {
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
	}

	/**
	 * Cambiar datos.
	 */
	@Override
	public void update(ModeloCourse bean) {
		// Variables
		Connection cn = null;
		PreparedStatement pstm = null;
		int filas;
		// Proceso
		try {
			// Iniciar la Tx
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Actualizar el registro
			pstm = cn.prepareStatement(SQL_UPDATE);
			pstm.setString(1, bean.getCourse_name());
			pstm.setInt(8, bean.getIdentifier());
			filas = pstm.executeUpdate();
			pstm.close();
			if (filas != 1) {
				throw new SQLException("Error, verifique sus datos e intentelo nuevamente.");
			}
			// Fin de Tx
			cn.commit();
		} catch (SQLException e) {
			try {
				cn.rollback();
				cn.close();
			} catch (Exception e2) {
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
	}

	/**
	 * Borrar datos.
	 */
	@Override
	public void delete(String id) {
		// Variables
		Connection cn = null;
		PreparedStatement pstm = null;
		int filas = 0;
		// Proceso
		try {
			// Inicio de Tx
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Proceso
			pstm = cn.prepareStatement(SQL_DELETE);
			pstm.setInt(1, Integer.parseInt(id));
			filas = pstm.executeUpdate();
			pstm.close();
			if (filas != 1) {
				throw new SQLException("No se pudo eliminar el curso.");
			}
			// Confirmar Tx
			cn.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public ModeloCourse mapRow(ResultSet rs) throws SQLException {
		ModeloCourse bean = new ModeloCourse();
		bean.setIdentifier(rs.getInt("Identifier"));
		bean.setCourse_name(rs.getString("Names"));
		return bean;
	}

	/**
	 * Realiza la busqueda por apellido y nombre.
	 */
	@Override
	public List<ModeloCourse> get(ModeloCourse bean) {
		// Variables
				Connection cn = null;
				List<ModeloCourse> lista = new ArrayList<>();
				PreparedStatement pstm = null;
				ResultSet rs = null;
				ModeloCourse item;
				String sql;
				String Course_name;
				// Preparar los datos
				Course_name = "%" + Plantilla.UtilService.setStringVacio(bean.getCourse_name()) + "%";
				// Proceso
				try {
					// Conexion
					cn = AccesoDB.getConnection();
					// La consulta
					sql = SQL_SELECT_BASE + " WHERE Names LIKE ? AND Activate LIKE ?";
					pstm = cn.prepareStatement(sql);
					pstm.setString(1, Course_name);
					rs = pstm.executeQuery();
					while (rs.next()) {
						item = mapRow(rs);
						lista.add(item);
					}
					rs.close();
					pstm.close();
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				} finally {
					try {
						cn.close();
					} catch (Exception e2) {
					}
				}
				return lista;
	}

}