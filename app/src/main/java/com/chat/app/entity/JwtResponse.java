package com.chat.app.entity;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
//	private UserDetails userDetails;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
//		this.userDetails = userDetails;
	}

	public String getToken() {
		return this.jwttoken;
	}

//	public UserDetails getUserDetails() {
//		return userDetails;
//	}
	
}