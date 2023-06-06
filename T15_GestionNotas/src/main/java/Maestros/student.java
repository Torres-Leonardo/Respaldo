package Maestros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Acceso.AccesoDB;
import Modelos.ModeloStudent;
import Plantilla.RowMapper;
import Plantilla.CRUD.CrudServiceSpec;


public class student implements CrudServiceSpec<ModeloStudent>, RowMapper<ModeloStudent>{

	private final String SQL_SELECT_BASE = "SELECT id, Names, Last_Name, Type_Document, Number_Document, Email, Cell_Phone, Activate, Grade_Identifier FROM student";
	private final String SQL_INSERT = "SET IDENTITY_INSERT student ON INSERT INTO student(Identifier,Names,Last_Name,Type_Document,Number_Document,Email, Cell_Phone,Activate,Grade_Identifier) VALUES(?,?,?,?,?,?,?,?,?) SET IDENTITY_INSERT student OFF";
	private final String SQL_UPDATE = "UPDATE student SET Names=?,Last_Name=?,Type_Document=?,Number_Document=?,Email=?,Cell_Phone=?,Activate=?,Grade_Identifier=? WHERE id=?";
	private final String SQL_DELETE = "DELETE FROM student WHERE id=?";
	
	/**
	 * Mostrar toda la tabla student.
	 */
	@Override
	public List<ModeloStudent> getAll() {
		// Variables
		Connection cn = null;
		List<ModeloStudent> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ModeloStudent bean;
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
	public ModeloStudent getForId(String id) {
		// Variables
				Connection cn = null;
				PreparedStatement pstm = null;
				ResultSet rs = null;
				ModeloStudent bean = null;
				String sql;
				// Proceso
				try {
					cn = AccesoDB.getConnection();
					sql = SQL_SELECT_BASE + " WHERE Id=?";
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
	public List<ModeloStudent> get(ModeloStudent bean) {
		// Variables
				Connection cn = null;
				List<ModeloStudent> lista = new ArrayList<>();
				PreparedStatement pstm = null;
				ResultSet rs = null;
				ModeloStudent item;
				String sql;
				String last_name;
				String names;
				// Preparar los datos
				last_name = "%" + UtilService.setStringVacio(bean.getLast_name()) + "%";
				names = "%" + UtilService.setStringVacio(bean.getNames()) + "%";
				// Proceso
				try {
					// Conexion
					cn = AccesoDB.getConnection();
					// La consulta
					sql = SQL_SELECT_BASE + " WHERE last_name LIKE ? AND names LIKE ?";
					pstm = cn.prepareStatement(sql);
					pstm.setString(1, last_name);
					pstm.setString(2, names);
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
	 * Insertar datos.
	 */
	@Override
	public void insert(ModeloStudent bean) {
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
						throw new SQLException("Contador de student no existe.");
					}
					id = Integer.parseInt(rs.getString("valor"));
					rs.close();
					pstm.close();
					// Actualizar contador
					id++;
					sql = "UPDATE controller SET valor = ? WHERE parametro='student'";
					pstm = cn.prepareStatement(sql);
					pstm.setString(1, id + "");
					pstm.executeUpdate();
					pstm.close();
					// Insertar nuevo empleado
					pstm = cn.prepareStatement(SQL_INSERT);
					pstm.setString(1, id + "");
					pstm.setString(2, bean.getNames());
					pstm.setString(3, bean.getLast_name());
					pstm.setString(4, bean.getType_document());
					pstm.setString(5, bean.getNumber_document());
					pstm.setString(6, bean.getEmail());
					pstm.setString(7, bean.getCell_phone());
					pstm.setString(8, bean.getActivate());
					pstm.setString(9, bean.getGrade_identifier());
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
	public void update(ModeloStudent bean) {
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
					pstm.setString(1, bean.getNames());
					pstm.setString(2, bean.getLast_name());
					pstm.setString(3, bean.getType_document());
					pstm.setString(4, bean.getNumber_document());
					pstm.setString(5, bean.getEmail());
					pstm.setString(6, bean.getCell_phone());
					pstm.setString(7, bean.getActivate());
					pstm.setString(8, bean.getGrade_identifier());
					pstm.setInt(9, bean.getId());
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
						throw new SQLException("No se pudo eliminar a la estudiante.");
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
	public ModeloStudent mapRow(ResultSet rs) throws SQLException {
		ModeloStudent bean = new ModeloStudent();
		bean.setId(rs.getInt("Id"));
		bean.setNames(rs.getString("Names"));
		bean.setLast_name(rs.getString("Last_Name"));
		bean.setType_document(rs.getString("Type_Document"));
		bean.setNumber_document(rs.getString("Number_Document"));
		bean.setEmail(rs.getString("Email"));
		bean.setCell_phone(rs.getString("Cell_Phone"));
		bean.setActivate(rs.getString("Activate"));
		return bean;
	}
}