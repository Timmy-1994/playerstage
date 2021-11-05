package com.playerstage.playerstage.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class SignUpRequest {
	@NotBlank(message = "username cannot be blank")
	private String username;

	@NotBlank(message = "password cannot be blank")
	@Size(min = 8,max = 18,message = "the password must between 8 and 18")
	private String password;
}
