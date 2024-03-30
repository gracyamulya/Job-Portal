package org.jsp.jobportal.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

 @Data
 @Component
 @Entity
public class PortalUser {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Size(min=3,max=15,message = "Enter between 3-15 characters")
	private String name;
	@NotNull(message = "* This is required field")
	@Email(message = "*Enter Proper Email Format")
	private String email;
	@DecimalMin(value = "6000000000",message = "Enter Proper Mobile Number")
	@DecimalMax(value = "9999999999",message = "Enter Proper Mobile Number")
	private long mobile;
	@NotNull(message ="* This is required field")
	private LocalDate dob;
	@Size(min = 8,max =15,message = "* Enter between 8~15 characters")
	private String password;
	@Size(min = 8,max =15,message = "* Enter between 8~15 characters")
	private String confirmpassword;
	@NotEmpty(message = "role Should not be empty")
	private String role;

}
