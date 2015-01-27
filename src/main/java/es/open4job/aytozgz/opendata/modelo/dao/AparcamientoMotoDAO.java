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
		List<AparcamientoMotoVO> l = null;

		return l;
	}

	AparcamientoMotoVO getDetailAparcamientoMoto(AparcamientoMotoVO moto) {
		AparcamientoMotoVO motito = null;

		return motito;
	}

	public static void main(String args[]) {
		try {
			Conexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Conexion() throws SQLException, ClassNotFoundException {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:test/test@54.154.192.80:1521:XE", "test",
					"test");
			// driver@machineName:port:SID , userid, password

			Statement stmt = conn.createStatement();
			ResultSet rset = stmt
					.executeQuery("SELECT * FROM APARCAMIENTOSMOTOS");
			while (rset.next()){
				//System.out.println(rset.getString(0)); // Print col 1
				System.out.println(rset.getString(1)); 
				System.out.println(rset.getString(2)); 
				System.out.println(rset.getString(3)); 
				System.out.println(rset.getString(4));
				System.out.println(rset.getString(5)); 
				System.out.println("______"); 
			}
			stmt.close();
	}
}
