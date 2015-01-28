package es.open4job.aytozgz.opendata.modelo.dao;

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
		Statement stmt = null;
		ResultSet rs = null;

		try {
			this.abrirConexion();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);

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
/*
	// prueba: muestra el numero de filas de la bd
	public static void main(String args[]) {
		AparcamientoBicebergDAO lst = new AparcamientoBicebergDAO(
				"oracle.jdbc.driver.OracleDriver",
				"jdbc:oracle:thin:test/test@54.154.192.80:1521:XE", "test",
				"test");
		List<AparcamientoBicebergVO> lstAparcmtoBiceberg = lst
				.getLstAparcamientoBiceberg();
		System.out.println(lstAparcmtoBiceberg.size());
	}
*/
}
