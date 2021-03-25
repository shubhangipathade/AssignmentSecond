package com.tcs.assignment2.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "DEVELOPER_ENTITY")
public class DeveloperEntityTable {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
	private String skills;
}
