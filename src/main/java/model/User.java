package model;

import enums.Authorities;

import java.util.List;

public class User {

    private String login;
    private String password;
    private List<Authorities> authorizations;

    public User() {
    }

    public User(String login, String password, List<Authorities> authorizations) {
        this.login = login;
        this.password = password;
        this.authorizations = authorizations;
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

    public List<Authorities> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(List<Authorities> authorizations) {
        this.authorizations = authorizations;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", authorizations=" + authorizations +
                '}';
    }
}