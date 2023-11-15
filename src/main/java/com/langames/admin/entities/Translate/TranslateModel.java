package com.langames.admin.entities.Translate;
import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import com.langames.admin.entities.Word.WordModel;

import jakarta.persistence.*;

@Entity
@Table(name = "Translate", schema = "general")
public class TranslateModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @ManyToOne
    @JoinColumn(name = "word_id")
    private WordModel word;
	
	@Column(name = "content")
	private String content;

    @CreationTimestamp(source = SourceType.DB)
	private Instant createdOn;
	
	@UpdateTimestamp(source = SourceType.DB)
	private Instant lastUpdatedOn;

	public TranslateModel() {}
	
	public TranslateModel(long id, String content, WordModel word) {
		super();
		this.id = id;
		this.content = content;
		this.word = word;
	}

	public long getId() {
		return id;
	}
	public void setWord(WordModel word) {
		this.word = word;
	}
    public WordModel getWord() {
		return word;
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

	public TranslateDAO toDao(){

		TranslateDAO translate = new TranslateDAO(
			this.id,
			this.content,
			this.createdOn,
			this.lastUpdatedOn
		);

		return translate;
	}

	public String printModel()
	{ 
		return (this.content + ", " + this.id + ", " + this.word.getId());
	}

}