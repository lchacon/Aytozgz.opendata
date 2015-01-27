package es.open4job.aytozgz.opendata.modelo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import es.open4job.aytozgz.opendata.modelo.vo.AparcamientoBicebergVO;

public class AparcamientoBicebergDAO {
	
	
	public List<AparcamientoBicebergVO> getLstAparcamientoBiceberg(){
		List<AparcamientoBicebergVO> lstAparcmtoBiceberg= new ArrayList<AparcamientoBicebergVO>();
		AparcamientoBicebergVO biceberg = null;
		try {
			Connection conn = Conexion();
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt
					.executeQuery("SELECT * FROM BICEBERG");
			while (rset.next()){
				biceberg = new AparcamientoBicebergVO(rset.getInt("id"), rset.getDouble("latitud"), 
						rset.getDouble("longitud"), rset.getString("icono"), rset.getString("titulo"), rset.getString("link"));
				lstAparcmtoBiceberg.add(biceberg);
			}
			stmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstAparcmtoBiceberg;
	}
	
	/*public static void main(String args[]) {
		AparcamientoBicebergDAO lst = new AparcamientoBicebergDAO();
		List<AparcamientoBicebergVO> lstAparcmtoBiceberg= lst.getLstAparcamientoBiceberg();
		System.out.println(lstAparcmtoBiceberg.size()); 
		
	}*/

	public Connection Conexion() throws SQLException, ClassNotFoundException {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:test/test@54.154.192.80:1521:XE", "test",
					"test");
			// driver@machineName:port:SID , userid, password
			return conn;
			
	}
}
