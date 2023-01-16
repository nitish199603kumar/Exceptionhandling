package com.nitish.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class UserRequest {

	@NotNull(message="username should not be null")
//	@JsonProperty("UserName")
	private String name;
	
	@Email(message="Invalid email address")
//	@JsonProperty("UserEmail")
	private String email;
	
	@NotNull
	@Pattern(regexp="^\\d{10}$",message="Invalid mobile no")
//	@JsonProperty("UserMobileNo")
	private String mobile;
	
//	@JsonProperty("gender")
	private String gender;
	
	@Min(18)
	@Max(60)
//	@JsonProperty("UserAge")
	private Integer age;
	
	@NotBlank
//	@JsonProperty("UserNationality")
	private String nationality;
}
