package es.open4job.aytozgz.opendata;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import es.open4job.aytozgz.opendata.modelo.dao.AparcamientoMotoDAO;
import es.open4job.aytozgz.opendata.modelo.vo.AparcamientoMotoVO;
import junit.framework.TestCase;

public class AparcamientoMotoDAOTest extends TestCase {
	public static final Logger logger = Logger
			.getLogger(AparcamientoMotoDAO.class.getName());
	String driver = "oracle.jdbc.driver.OracleDriver";

	String host = "54.154.192.80";
	String puerto = "1521";
	String sid = "xe";

	String user = "test";
	String password = "test";

	String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host + ":"
			+ puerto + ":" + sid;

	// AparcamientoMoto
	AparcamientoMotoDAO aparcamientoMotoDAO = new AparcamientoMotoDAO(driver,
			url, user, password);

	public void testGetLstAparcamientoMoto() {

		List<AparcamientoMotoVO> motos = aparcamientoMotoDAO
				.getLstAparcamientoMoto();

		if (motos != null) {
			Iterator<AparcamientoMotoVO> iterator = motos.iterator();

			while (iterator.hasNext()) {

				AparcamientoMotoVO moto = iterator.next();
				System.out.println(moto.toString());

			}
		}

	}

	public void testGetDetailAparcamientoMoto() {

		// Detalles Aparcamiento Moto
		AparcamientoMotoDAO aparcamientoMotoDAO = new AparcamientoMotoDAO(
				driver, url, user, password);

		AparcamientoMotoVO motoDetalle = aparcamientoMotoDAO
				.getDetailAparcamientoMoto(222);
		
		String detalles = "Descripción: " + motoDetalle.getDescripcion() + " "
				+ "Icono: " + motoDetalle.getIcon() + " " + "Id: "
				+ motoDetalle.getId() + " " + "Ultima Actualización: "
				+ motoDetalle.getLastUpdated() + " " + "Latitud: "
				+ motoDetalle.getLatitud() + " " + "Longitud: "
				+ motoDetalle.getLongitud() + " " + "Plazas: "
				+ motoDetalle.getPlazas() + " " + "Titulo: "
				+ motoDetalle.getTitle();

		logger.info(detalles);

		/*
		 * System.out.println( "Descripción: "+motoDetalle.getDescripcion()+" "+
		 * "Icono: "+motoDetalle.getIcon()+" "+ "Id: "+motoDetalle.getId()+" "+
		 * "Ultima Actualización: "+motoDetalle.getLastUpdated()+" "+
		 * "Latitud: "+motoDetalle.getLatitud()+" "+
		 * "Longitud: "+motoDetalle.getLongitud()+" "+
		 * "Plazas: "+motoDetalle.getPlazas()+" "+
		 * "Titulo: "+motoDetalle.getTitle());
		 */

	}

}
