package com.objis.demohibernate.simple;

public class Formation {
	
	private Long id; // Identifiant formation (Cl� primaire)
	
	private String theme; // Th�me formation
	
	// Getters et Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	// Constructeur
	public Formation(String theme) {
		super();
		this.theme = theme;
	}	
}
