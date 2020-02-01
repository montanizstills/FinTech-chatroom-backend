package com.github.nez.Model;

public class AccountBuilder {
    private String username;
    private String password;
    private String email;
    private String id;
    private String token;


    public AccountBuilder setUsername(String usernameInput) {
        this.username = usernameInput;
        return this;
    }

    public AccountBuilder setPassword(String passwordInput) {
        this.password = passwordInput;
        return this;
    }

    public AccountBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public AccountBuilder setId(String id){
        this.id=id;
        return this;
    }

    public AccountBuilder setToken(String token){
        this.token=token;
        return this;
    }

    public Account createAccount() {
        return new Account(username,password,email);
    }

}