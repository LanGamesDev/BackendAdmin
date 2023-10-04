package com.langames.admin.entities.Translate;
import java.util.Date;

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

    @Column(name = "audi_fechaCreacion")
	private Date fechaCreacion;

	public TranslateModel() {}
	
	public TranslateModel(String content, WordModel word, Date fechaCreacion) {
		super();
		this.content = content;
		this.word = word;
		this.fechaCreacion = fechaCreacion;
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
    public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}