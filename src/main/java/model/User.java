package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import core.db.tables.TabUsers;

public class User {

	private ResultSet rs;
	
	private int uDI;
	private String firstName;
	private String lastname;
	private String email;
	private String login;
	private HttpSession sessionID;
	private String departement;
	private int accessLevel = 0;
	
	public User(ResultSet rs, HttpSession sessionID) {
		this.sessionID = sessionID;
		this.rs = rs;
		associateData();
	}
	
	private void associateData() {
		try {
			this.uDI = rs.getInt(TabUsers.UID.toString());
			this.firstName = rs.getString(TabUsers.FIRST_NAME.toString());
			this.lastname = rs.getString(TabUsers.LAST_NAME.toString());
			this.email = rs.getString(TabUsers.EMAIL.toString());
			this.login = rs.getString(TabUsers.LOGIN.toString());
			this.departement = rs.getString(TabUsers.DEPARTEMENT.toString());
			this.accessLevel = rs.getInt(TabUsers.ACCESS_LEVEL.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getuDI() {
		return uDI;
	}

	public void setuDI(int uDI) {
		this.uDI = uDI;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public HttpSession getSessionID() {
		return sessionID;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public void setSessionID(HttpSession sessionID) {
		this.sessionID = sessionID;
	}

}
