package es.open4job.aytozgz.opendata.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.open4job.aytozgz.opendata.modelo.vo.AparcamientoBicebergVO;

public class AparcamientoBicebergDAO extends GenericDAO {

	public static final Logger logger = Logger
			.getLogger(AparcamientoMotoDAO.class.getName());

	public AparcamientoBicebergDAO(String driver, String url, String user,
			String password) {
		super(driver, url, user, password);
	}

	// listado de aparcamiento bicis
	public List<AparcamientoBicebergVO> getLstAparcamientoBiceberg() {
		List<AparcamientoBicebergVO> lstAparcmtoBiceberg = new ArrayList<AparcamientoBicebergVO>();

		AparcamientoBicebergVO biceberg = null;
		String query = "SELECT * FROM BICEBERG";
		String queryInsert = "INSERT INTO BICEBERG(LINK,TITULO,ICONO,LATITUD,LONGITUD,ID) "
				+ "VALUES(?,?,?,?,?,?)";
		String queryUpdate = "UPDATE BICEBERG SET LINK=? WHERE ID=?";
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			this.abrirConexion();
			/*stmt = connection.prepareStatement(queryInsert);
			stmt.setString(1,"linko");
			stmt.setString(2,"titulin");
			stmt.setString(3,"iconico");
			stmt.setDouble(4, 325);
			stmt.setDouble(5, 156);
			stmt.setInt(6, 4);
			rs = stmt.executeQuery();
			stmt.close();*/
			stmt = connection.prepareStatement(queryUpdate);
			stmt.setString(1,"linkITO");
			stmt.setInt(2, 4);
			int registros = stmt.executeUpdate();
			stmt.close();
			System.out.println(registros);
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				biceberg = new AparcamientoBicebergVO(rs.getInt("id"),
						rs.getDouble("latitud"), rs.getDouble("longitud"),
						rs.getString("icono"), rs.getString("titulo"),
						rs.getString("link"));

				lstAparcmtoBiceberg.add(biceberg);
			}

		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		}

		finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

		}

		this.cerrarConexion();

		return lstAparcmtoBiceberg;
	}
}
