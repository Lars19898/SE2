package com.example.dto;

import java.io.Serializable;

public class Hotel implements Serializable {
	
	
	private String name;
	private int id;
	private String ort;
	private String beschreibung;
	
	
	
	public Hotel(String name, int id, String ort, String beschreibung) {
		
		this.name = name;
		this.id = id;
		this.ort = ort;
		this.beschreibung = beschreibung;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Hotel(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	

}
