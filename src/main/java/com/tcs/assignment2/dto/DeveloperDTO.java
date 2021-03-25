package com.tcs.assignment2.dto;

import lombok.Data;

@Data
public class DeveloperDTO {
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String skills="Java";

	public DeveloperDTO() {    }

}
