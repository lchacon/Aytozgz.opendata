package es.open4job.aytozgz.opendata.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.open4job.aytozgz.opendata.modelo.vo.AparcamientoMotoVO;

public class AparcamientoMotoDAO extends GenericDAO {

	public static final Logger logger = Logger
			.getLogger(AparcamientoMotoDAO.class.getName());

	public AparcamientoMotoDAO(String driver, String url, String user,
			String password) {
		super(driver, url, user, password);
	}

	// listado de aparcamiento de motos
	public List<AparcamientoMotoVO> getLstAparcamientoMoto() {
		List<AparcamientoMotoVO> lsitAparcamientoMotos = new ArrayList<AparcamientoMotoVO>();

		AparcamientoMotoVO motoVO = null;
		String query = "SELECT * FROM APARCAMIENTOSMOTOS";
		Statement stmt = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				motoVO = new AparcamientoMotoVO(rs.getDouble("latitud"),
						rs.getDouble("longitud"), rs.getString("titulo"),
						rs.getString("icono"), rs.getString("descripcion"),
						rs.getString("last_update"), rs.getInt("plazas"),
						rs.getInt("id"));

				lsitAparcamientoMotos.add(motoVO);
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

		return lsitAparcamientoMotos;
	}

	// Detalles de Aparcamiento de motos

	public AparcamientoMotoVO getDetailAparcamientoMoto(int motoId) {

		AparcamientoMotoVO aptoMoto = null;
		String query = "SELECT * FROM APARCAMIENTOSMOTOS WHERE id = " + motoId;
		ResultSet rset = null;
		Statement stmt = null;

		try {
			this.abrirConexion();
			stmt = connection.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				aptoMoto = new AparcamientoMotoVO(
						rset.getDouble("latitud"), rset.getDouble("longitud"),
						rset.getString("titulo"), rset.getString("icono"),
						rset.getString("descripcion"),
						rset.getString("last_update"), rset.getInt("plazas"),
						rset.getInt("id"));
				
			}
			stmt.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());

		} finally {

			if (rset != null) {
				try {
					rset.close();
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
		return aptoMoto;

	}

	/*
	 * // prueba: muestra el numero de filas de la bd public static void
	 * main(String args[]) { AparcamientoMotoDAO motoDAO = new
	 * AparcamientoMotoDAO( "oracle.jdbc.driver.OracleDriver",
	 * "jdbc:oracle:thin:test/test@54.154.192.80:1521:XE", "test", "test");
	 * List<AparcamientoMotoVO> list = motoDAO.getLstAparcamientoMoto();
	 * System.out.println(list.size()); }
	 */
}
