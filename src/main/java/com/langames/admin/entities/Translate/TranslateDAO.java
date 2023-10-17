package com.langames.admin.entities.Translate;

import java.util.Date;

public class TranslateDAO {

    public long id;
	public String content;
	public Date fechaCreacion;

	public TranslateModel toModel(){

		TranslateModel word = new TranslateModel(
			this.content,
			null,
			this.fechaCreacion
		);

		return word;
	}

}
