package Plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import Modelos.ModeloUsers;

public interface RowMapper2<T> {
	ModeloUsers mapRow(ResultSet rs) throws SQLException;
}
