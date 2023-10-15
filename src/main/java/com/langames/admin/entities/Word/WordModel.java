package com.langames.admin.entities.Word;

import java.util.ArrayList;
import java.util.List;

import com.langames.admin.entities.Translate.TranslateDAO;

import jakarta.persistence.*;

@Entity
@Table(name = "Word", schema = "general")
public class WordModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "content")
	private String content;

	public WordModel() {
		
	}
	
	public WordModel(String content) {
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

	public WordDAO toDao(){

		List<TranslateDAO> translates = new ArrayList<>();

		WordDAO word = new WordDAO(
			this.id,
			this.content,
			translates
		);

		return word;
	}

}