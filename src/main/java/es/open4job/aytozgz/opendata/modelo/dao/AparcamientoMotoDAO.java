package es.open4job.aytozgz.opendata.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import es.open4job.aytozgz.opendata.modelo.vo.AparcamientoMotoVO;

/**
 * Hello world!
 *
 */
public class AparcamientoMotoDAO {

	List<AparcamientoMotoVO> getLstAparcamientoMoto() {
		List<AparcamientoMotoVO> l = new ArrayList<AparcamientoMotoVO>();

		Connection conn = CrearConexion();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt
					.executeQuery("SELECT * FROM APARCAMIENTOSMOTOS");
			while (rset.next()) {
				AparcamientoMotoVO apMoto = new AparcamientoMotoVO(
						rset.getDouble("latitud"), rset.getDouble("longitud"),
						rset.getString("titulo"), rset.getString("icono"),
						rset.getString("descripcion"),
						rset.getString("last_update"), rset.getInt("plazas"),
						rset.getInt("id"));
				l.add(apMoto);
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	AparcamientoMotoVO getDetailAparcamientoMoto(AparcamientoMotoVO moto) {
		AparcamientoMotoVO motito = null;

		return motito;
	}

	public static void main(String args[]) {
		AparcamientoMotoDAO motoDAO = new AparcamientoMotoDAO();
		List<AparcamientoMotoVO>  list = motoDAO.getLstAparcamientoMoto();
		
		Iterator iter = list.iterator();
		while (iter.hasNext())
		  System.out.println(iter.next());
	}

	public static Connection CrearConexion() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:test/test@54.154.192.80:1521:XE", "test",
					"test");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
