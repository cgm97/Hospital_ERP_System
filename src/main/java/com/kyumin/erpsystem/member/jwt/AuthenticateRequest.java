package com.kyumin.erpsystem.member.jwt;

public class AuthenticateRequest {
	private String userid;
	private String password;
	
	public AuthenticateRequest() {
	}
	
	public AuthenticateRequest(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}
	
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
