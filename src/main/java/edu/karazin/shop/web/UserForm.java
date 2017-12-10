package edu.karazin.shop.web;

import edu.karazin.shop.entity.Role;
import edu.karazin.shop.entity.User;

public class UserForm {
    private Role role;
    private String login;
    private String password;

    public UserForm() {
    }

    public UserForm(Role role) {
        this.role = role;
    }

    public UserForm(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User convertToUser() {
        return new User(getLogin(), getPassword(), getRole());
    }
}
