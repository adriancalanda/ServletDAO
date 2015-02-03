package es.open4job.model.vo;

import java.util.Date;

public class EstacionServicioVO {
	
	private int id;
	
	private String title;
	
	private Date fecha; 
	
	private float cor_x; 
	
	private float cor_y;
	
	private String icon;
	
	public EstacionServicioVO(int id, String title, Date fecha, float cor_x, float cor_y, String icon){
		
		this.id = id;
		this.title = title;
		this.fecha = fecha;
		this.cor_x = cor_x;
		this.cor_y= cor_y;
		this.icon= icon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getCor_x() {
		return cor_x;
	}

	public void setCor_x(float cor_x) {
		this.cor_x = cor_x;
	}

	public float getCor_y() {
		return cor_y;
	}

	public void setCor_y(float cor_y) {
		this.cor_y = cor_y;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
