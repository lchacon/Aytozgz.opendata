package es.open4job.aytozgz.opendata;

import java.util.Iterator;
import java.util.List;

import es.open4job.aytozgz.opendata.modelo.dao.AparcamientoBicebergDAO;
import es.open4job.aytozgz.opendata.modelo.dao.AparcamientoMotoDAO;
import es.open4job.aytozgz.opendata.modelo.vo.AparcamientoBicebergVO;
import es.open4job.aytozgz.opendata.modelo.vo.AparcamientoMotoVO;

public class AparcamientosMain {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";

		String host = "54.154.192.80";
		String puerto = "1521";
		String sid = "xe";

		String user = "test";
		String password = "test";

		String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host
				+ ":" + puerto + ":" + sid;

		boolean borrarMotoCSV = true;
		boolean borrarBicebergCSV = true;

		// AparcamientoMoto
		AparcamientoMotoDAO aparcamientoMotoDAO = new AparcamientoMotoDAO(
				driver, url, user, password);

		List<AparcamientoMotoVO> motos = aparcamientoMotoDAO
				.getLstAparcamientoMoto();

		if (motos != null) {
			Iterator<AparcamientoMotoVO> iterator = motos.iterator();

			while (iterator.hasNext()) {

				AparcamientoMotoVO moto = iterator.next();
				System.out.println(moto.toString());

				// borro el CSV para que no se dupliquen los datos
				moto.borrarArchivoCSV(borrarMotoCSV);
				borrarMotoCSV = false; // para que solo se ejecute una vez

				// creo archivo CSV en local /var/www/html/aparcamientoMoto.csv
				moto.escribirCSV();
			}
		}

		// Detalles Aparcamiento Moto
		AparcamientoMotoVO motoDetalle = aparcamientoMotoDAO
				.getDetailAparcamientoMoto(222);
		System.out.println(motoDetalle.toString());

		// AparcamientoBiceberg
		AparcamientoBicebergDAO aparcamientoBicebergDAO = new AparcamientoBicebergDAO(
				driver, url, user, password);

		List<AparcamientoBicebergVO> bicebergs = aparcamientoBicebergDAO
				.getLstAparcamientoBiceberg();

		if (bicebergs != null) {
			Iterator<AparcamientoBicebergVO> iterator = bicebergs.iterator();
			while (iterator.hasNext()) {
				
				AparcamientoBicebergVO biceberg = iterator.next();
				System.out.println(biceberg.toString());
				
				// borro el CSV para que no se dupliquen los datos
				biceberg.borrarArchivoCSV(borrarBicebergCSV);
				borrarBicebergCSV = false; // para que solo se ejecute una vez

				// creo archivo CSV en local /var/www/html/aparcamientoBiceberg.csv
				biceberg.escribirCSV();
			}
		}
	}
}
