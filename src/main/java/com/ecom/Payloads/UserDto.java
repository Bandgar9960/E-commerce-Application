package com.ecom.Payloads;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private Integer userId;

	@NotEmpty
	@Size(min = 3, message = "Name must be Atleast 3 Charater!!")
	private String name;

	// IN PROJECT WE TAKE EMAIL AS USERNAME

	@Email(message = "Email Id Is not Valid")
	private String email;

	@NotEmpty
	private String address;

	@NotEmpty
	@Size(min = 8, max = 12, message = "Password must be min of 8 chars and max 12 chars")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Insert Valid Password")
	private String password;

	@NotEmpty
	private String about;

	private String gender;

	private Date createAt;

	private Date updateAt;

	@NotBlank
	private String phone;

	private boolean active;

}
