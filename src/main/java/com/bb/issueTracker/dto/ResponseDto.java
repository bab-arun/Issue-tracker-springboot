package com.bb.issueTracker.dto;

public class ResponseDto {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ResponseDto(int id, String name, String message) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
	}
	public ResponseDto() {
		super();
	}
	
	
	
}
