package com.langames.admin.entities.Word;

import java.time.Instant;
import java.util.List;

import com.langames.admin.entities.Translate.TranslateDAO;

public class WordDAO {

	public long id;
	public String content;
	public Instant createdDate;
	public Instant updatedDate;
	public String context;
    public List<TranslateDAO> translates;
    public List<TranslateDAO> deletedTranslates;

	public WordDAO() {
		
	}
	
	public WordDAO(long id, String content, Instant createdDate, Instant updatedDate, String context, List<TranslateDAO> translates) {
		super();
        this.id = id;
		this.content = content;
		this.translates = translates;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.context = context;
	}

	public WordModel toModel(){

		WordModel word = new WordModel(
			this.content,
			this.context
		);

		return word;
	}

}