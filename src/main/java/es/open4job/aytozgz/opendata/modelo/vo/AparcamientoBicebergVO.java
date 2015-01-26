package es.open4job.aytozgz.opendata.modelo.vo;

public class AparcamientoBicebergVO {
	int id;
	double latitud;
	double longitud;
	String icon;
	String title;
	String link;
	
	public AparcamientoBicebergVO(int id, double latitud, double longitud,
			String icon, String description, String link) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.icon = icon;
		this.title = description;
		this.link= link;
	}
}
