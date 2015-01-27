package es.open4job.aytozgz.opendata.modelo.vo;

import java.util.Date;

public class AparcamientoMotoVO 
{
	
	private double latitud;
	private double longitud; 
   	String title;
   	String icon;
   	String descripcion;
   	Date lastUpdated;
   	int plazas; 
   	int id;
   	
	public AparcamientoMotoVO(double latitud, double longitud, String title,
			String icon, String descripcion, Date lastUpdated, int plazas,
			int id) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.title = title;
		this.icon = icon;
		this.descripcion = descripcion;
		this.lastUpdated = lastUpdated;
		this.plazas = plazas;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
   	
   	
   	
}
