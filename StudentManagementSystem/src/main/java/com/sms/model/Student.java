package com.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO )
	private Integer id;  //Id as a Roll
	@NotNull(message = "Name should not be null")
	private String name;
	@NotNull(message = "Marks should not be null")
	private Integer marks;
	private String address;

}
