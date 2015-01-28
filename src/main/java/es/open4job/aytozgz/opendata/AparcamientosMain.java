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

			}
		}

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
			}
		}
	}
}
