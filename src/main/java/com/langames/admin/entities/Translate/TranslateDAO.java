package com.langames.admin.entities.Translate;

import java.time.Instant;

public class TranslateDAO {

    public long id;
	public String content;
	public int typeState;
	public Instant createdDate;
	public Instant updatedDate;

	public TranslateDAO() {}

	public TranslateDAO(long id, String content, Instant createdDate, Instant updatedDate) {
		super();
		this.id = id;
		this.content = content;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public TranslateModel toModel(){

		long newId = (this.typeState == 0)?0:this.id;

		TranslateModel word = new TranslateModel(
			newId,
			this.content,
			null
		);

		return word;
	}

	public String printDAO()
	{ 
		return (this.content + ", " + this.id + ", " + this.createdDate + ", " + this.typeState);
	}

}
