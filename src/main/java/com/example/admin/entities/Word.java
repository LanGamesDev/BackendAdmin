package com.example.admin;

import jakarta.persistence.*;

@Entity
@Table(name = "Word", schema = "general")
public class Word {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "content")
	private String content;

	public Word() {
		
	}
	
	public Word(String content) {
		super();
		this.content = content;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getcontent() {
		return content;
	}
	public void setcontent(String content) {
		this.content = content;
	}

}