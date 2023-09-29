package com.langames.admin.entities.Word;

import com.langames.admin.entities.Translate.TranslateDAO;

public class WordDAO {

	public long id;
	public String content;
    public TranslateDAO[] translates;

	public WordDAO() {
		
	}
	
	public WordDAO(String content) {
		super();
		this.content = content;
	}

}