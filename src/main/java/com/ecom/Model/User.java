package com.ecom.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_DETAILS")
@Setter
@Getter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "USER_NAME", nullable = false)
	private String name;

	// IN PROJECT WE TAKE EMAIL AS USERNAME
	@Column(unique = true)
	private String email;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ABOUT")
	private String about;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "CREATE_AT")
	@CreationTimestamp
	private Date createAt;
	
	@Column(name = "UPDATE_AT")
	@UpdateTimestamp
	private Date updateAt;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "ACTIVE")
	private boolean active;

	/**
	 * One User Have Only one Cart
	 */
	
	@OneToOne
	private Cart cart;
}
