package Plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;

import Modelos.ModeloStudent;

public interface RowMapper<T> {

	ModeloStudent mapRow(ResultSet rs) throws SQLException;
}
