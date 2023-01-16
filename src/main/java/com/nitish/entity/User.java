package com.nitish.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Table(name="user_exception_tbl")
public class User {

	@Id
	@GeneratedValue
	private Integer userId;
	
	@JsonProperty("UserName")
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private Integer age;
	private String nationality;
}
