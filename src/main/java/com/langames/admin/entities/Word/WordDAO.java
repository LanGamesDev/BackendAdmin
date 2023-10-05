package com.langames.admin.entities.Word;

import java.util.List;

import com.langames.admin.entities.Translate.TranslateDAO;

public class WordDAO {

	public long id;
	public String content;
    public List<TranslateDAO> translates;

	public WordDAO() {
		
	}
	
	public WordDAO(long id, String content, List<TranslateDAO> translates) {
		super();
        this.id = id;
		this.content = content;
		this.translates = translates;
	}

}