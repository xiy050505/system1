package com.pojo;

public class Register {
    private String username;
    private String password;
    private String rpassword;
    private String checkCode;

    public Register() {
    }

    public Register(String username, String password, String rpassword, String checkCode) {
        this.username = username;
        this.password = password;
        this.rpassword = rpassword;
        this.checkCode = checkCode;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return rpassword
     */
    public String getRpassword() {
        return rpassword;
    }

    /**
     * 设置
     * @param rpassword
     */
    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    /**
     * 获取
     * @return checkCode
     */
    public String getCheckCode() {
        return checkCode;
    }

    /**
     * 设置
     * @param checkCode
     */
    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String toString() {
        return "Register{username = " + username + ", password = " + password + ", rpassword = " + rpassword + ", checkCode = " + checkCode + "}";
    }
}
