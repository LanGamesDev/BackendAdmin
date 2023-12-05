package com.langames.admin.entities.Word;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import com.langames.admin.entities.Translate.TranslateDAO;
import com.langames.admin.entities.Translate.TranslateModel;

import jakarta.persistence.*;

@Entity
@Table(name = "Word", schema = "general")
public class WordModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "content")
	private String content;

	@CreationTimestamp(source = SourceType.DB)
	private Instant createdOn;
	
	@UpdateTimestamp(source = SourceType.DB)
	private Instant lastUpdatedOn;

	@OneToMany(mappedBy = "word", cascade = CascadeType.ALL)
    private List<TranslateModel> translates;

	@Column(name = "context")
	private String context;

	public WordModel() {
		
	}
	
	public WordModel(String content, String context) {
		super();
		this.content = content;
		this.context = context;
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
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}

	public List<TranslateModel> getTranslates() {
		return translates;
	}
	public void setTranslates(List<TranslateModel> translates) {
		this.translates = translates;
	}

	public WordDAO toDao(){

		List<TranslateDAO> translatesDao = new ArrayList<>();
		for (TranslateModel translateModel : this.translates) {
			translatesDao.add(translateModel.toDao());
		}

		WordDAO word = new WordDAO(
			this.id,
			this.content,
			this.createdOn,
			this.lastUpdatedOn,
			this.context,
			translatesDao
		);

		return word;
	}

}