package personal.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import jakarta.persistence.Table;

@Entity(name="language")
@Table(name="language")
public class Language {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="lang_name", unique=true)
	private String langName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}
	
}
