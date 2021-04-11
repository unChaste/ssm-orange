package io.toya.request;

import io.toya.entity.User;

public class RegisterRequest extends User {
    private String passwordTwo;

    public String getPasswordTwo() {
        return passwordTwo;
    }

    public void setPasswordTwo(String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "passwordTwo='" + passwordTwo + '\'' +
                '}';
    }
}
