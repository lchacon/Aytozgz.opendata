package es.open4job.aytozgz.opendata;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import es.open4job.aytozgz.opendata.modelo.dao.AparcamientoBicebergDAO;
import es.open4job.aytozgz.opendata.modelo.dao.AparcamientoMotoDAO;
import es.open4job.aytozgz.opendata.modelo.vo.AparcamientoBicebergVO;
import es.open4job.aytozgz.opendata.modelo.vo.AparcamientoMotoVO;

public class AparcamientosMain {
	public static void main(String[] args) throws JRException {

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
			}
		}

		JasperReport reporte = (JasperReport) JRLoader
				.loadObjectFromFile("plantillas/plantillaBiceberg.jasper");
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,
				new JRBeanCollectionDataSource(bicebergs));

		JRExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE,
				new java.io.File("reporteBiceberg.pdf"));
		exporter.exportReport();

	}
}
