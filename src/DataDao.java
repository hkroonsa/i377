import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataDao extends AbstractDao {

	public List<Data> findAllUnits() throws SQLException {
		
		List<Data> units = new ArrayList<Data>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM unit");
			while (rs.next()) {
				insertData(units);
			}
			return units;
		} finally {
			closeResources();
		}
		
	}
	
	public void addNew(String name, String code) throws SQLException   {
		try {
			pst = getConnection().prepareStatement("INSERT INTO unit (id, name, code) VALUES (NEXT VALUE FOR seq1, ?, ?)");
			pst.setString(1, name);
			pst.setString(2, code);
			pst.execute();
		}
		finally {
			closeResources();
		}
	}

	public void deleteId(int id) throws SQLException {
		try {			
			pst = getConnection().prepareStatement("DELETE FROM unit WHERE id = ?;");
			pst.setInt(1, id);
			pst.execute();
			
		} finally {
			closeResources();
		}
	}

	public List<Data> search(String name) throws SQLException {
		List<Data> units = new ArrayList<Data>();
		try {
			 pst = getConnection().prepareStatement("SELECT * FROM unit WHERE UPPER(name) LIKE ?");
			 pst.setString(1, "%" + name.toUpperCase() + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				insertData(units);
			}
			return units;
		} finally {
			closeResources();
		}
		
	}

	public void insertData(List<Data> units) throws SQLException {
		Data unit = new Data();
		unit.setId(rs.getInt(1));
		unit.setName(rs.getString(2));
		unit.setCode(rs.getString(3));
		units.add(unit);
	}	

	public void delete() throws SQLException {
		try {
			st = getConnection().createStatement();			
			rs = st.executeQuery("TRUNCATE TABLE unit");

		} finally {
			closeResources();
		}
	}
}