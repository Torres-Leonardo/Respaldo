package Plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import Modelos.ModeloCourse;

public interface RowMapper3<T> {
	ModeloCourse mapRow(ResultSet rs) throws SQLException;
	}
