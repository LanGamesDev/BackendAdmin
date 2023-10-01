package com.langames.admin.entities.Translate;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Translate", schema = "general")
public class TranslateModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "content")
	private String content;

    @Column(name = "audi_fechaCreacion")
	private Date fechaCreacion;

	public TranslateModel() {
		
	}
	
	public TranslateModel(String content) {
		super();
		this.content = content;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}