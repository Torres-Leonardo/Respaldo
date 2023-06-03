package Maestros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Acceso.AccesoDB;
import Modelos.ModeloUsers;
import Plantilla.RowMapper2;
import Plantilla.CRUD.CrudServiceSpec;

public class users implements CrudServiceSpec<ModeloUsers>, RowMapper2<ModeloUsers> {

	private final String SQL_SELECT_BASE = "SELECT identifier, type_document, number_document, type_user, names, last_name, email, cell_phone, activate  FROM users";
	private final String SQL_INSERT = "INSERT INTO users(identifier, type_document, number_document, type_user, names, last_name, email, cell_phone, activate) VALUES(?,?,?,?,?,?,?,?,?)";
	private final String SQL_UPDATE = "UPDATE users SET  type_document=?, number_document=?, type_user=?, names=?, last_name=?, email=?, cell_phone=?, activate=? WHERE identifier=?";
	private final String SQL_DELETE = "DELETE FROM users WHERE identifier=?";

	@Override
	public ModeloUsers mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ModeloUsers bean = new ModeloUsers();
		bean.setIdentifier(rs.getInt("identifier"));
		bean.setType_document(rs.getString("type_document"));
		bean.setNumber_document(rs.getString("number_document"));
		bean.setType_user(rs.getString("type_user"));
		bean.setNames(rs.getString("names"));
		bean.setLast_name(rs.getString("last_name"));
		bean.setEmail(rs.getString("email"));
		bean.setCell_phone(rs.getString("cell_phone"));
		bean.setActivate(rs.getString("activate"));
		return bean;
	}

	/**
	 * Mostrar toda la tabla users.
	 */
	@Override
	public List<ModeloUsers> getAll() {
		// TODO Auto-generated method stub
		Connection cn = null;
		List<ModeloUsers> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ModeloUsers bean;
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
	public ModeloUsers getForId(String id) {
		// TODO Auto-generated method stub
		// Variables
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ModeloUsers bean = null;
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
	 * Realiza la busqueda por apellido y nombre.
	 */
	@Override
	public List<ModeloUsers> get(ModeloUsers bean) {
		// TODO Auto-generated method stub
		Connection cn = null;
		List<ModeloUsers> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ModeloUsers item;
		String sql;
		String Names;
		String Activate;
		// Preparar los datos
		Names = "%" + Plantilla.UtilService.setStringVacio(bean.getNames()) + "%";
		Activate = "%" + Plantilla.UtilService.setStringVacio(bean.getActivate()) + "%";
		// Proceso
		try {
			// Conexion
			cn = AccesoDB.getConnection();
			// La consulta
			sql = SQL_SELECT_BASE + " WHERE Names LIKE ? AND Activate LIKE ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, Names);
			pstm.setString(2, Activate);
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

	/**
	 * Insertar datos (PROCESO).
	 */
	@Override
	public void insert(ModeloUsers bean) {
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
			sql = "SELECT valor FROM controller WHERE parametro='student'";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				rs.close();
				pstm.close();
				throw new SQLException("Contador de users no existe.");
			}
			id = Integer.parseInt(rs.getString("valor"));
			rs.close();
			pstm.close();
			// Actualizar contador
			id++;
			sql = "UPDATE controller SET valor = ? WHERE parametro='users'";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, id + "");
			pstm.executeUpdate();
			pstm.close();
			// Insertar nuevo empleado
			pstm = cn.prepareStatement(SQL_INSERT);
			pstm.setString(1, id + "");
			pstm.setString(2, bean.getType_document());
			pstm.setString(3, bean.getNumber_document());
			pstm.setString(4, bean.getType_user());
			pstm.setString(5, bean.getNames());
			pstm.setString(6, bean.getLast_name());
			pstm.setString(7, bean.getEmail());
			pstm.setString(8, bean.getCell_phone());
			pstm.setString(9, bean.getActivate());
			pstm.executeUpdate();
			pstm.close();
			// Fin de Tx
			bean.setId(id);
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
	public void update(ModeloUsers bean) {
		//variables
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
			pstm.setString(1, bean.getType_document());
			pstm.setString(2, bean.getNumber_document());
			pstm.setString(3, bean.getType_user());
			pstm.setString(4, bean.getNames());
			pstm.setString(5, bean.getLast_name());
			pstm.setString(6, bean.getEmail());
			pstm.setString(7, bean.getCell_phone());
			pstm.setString(8, bean.getActivate());
			pstm.setInt(9, bean.getIdentifier());
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
						throw new SQLException("No se pudo eliminar el users.");
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
}