package es.open4job.aytozgz.opendata.modelo.vo;

public class AparcamientoBicebergVO {
	private int id;
	private double latitud;
	private double longitud;
	private String icon;
	private String title;
	private String link;

	public AparcamientoBicebergVO(int id, double latitud, double longitud,
			String icon, String description, String link) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.icon = icon;
		this.title = description;
		this.link = link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String toString() {
		return ("AparcamientoBiceberVO = [ " + "id = " + id + ", "
				+ "latitud = " + latitud + ", " + "longitud = " + longitud
				+ ", " + "icon = " + icon + ", " + "title = " + title + ", "
				+ "link = " + link + " ]");
	}
}
