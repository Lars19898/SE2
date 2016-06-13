package com.example.dto;

public class User {
	private String password;
	private String username;
	private int id;
	private int id2;
	
	

	public User(String password, String username, int id) {

		this.password = password;
		this.username = username;
		this.id = id;
	}

	public String getName() {
		return password;
	}

	public void setName(String name) {
		this.password = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
