package com.langames.admin.entities.Translate;

import java.util.Date;

public class TranslateDAO {

    public long id;
	public String content;
	public Date fechaCreacion;
	public int typeState;

	public TranslateDAO() {}

	public TranslateDAO(long id, String content, Date fechaCreacion) {
		super();
		this.id = id;
		this.content = content;
		this.fechaCreacion = fechaCreacion;
	}

	public TranslateModel toModel(){

		long newId = (this.typeState == 0)?0:this.id;

		TranslateModel word = new TranslateModel(
			newId,
			this.content,
			null,
			this.fechaCreacion
		);

		return word;
	}

	public String printDAO()
	{ 
		return (this.content + ", " + this.id + ", " + this.fechaCreacion + ", " + this.typeState);
	}

}
