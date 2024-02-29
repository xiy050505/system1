package com.pojo;

public class Avatar {
    private String username;
    private String path;

    public Avatar() {
    }

    public Avatar(String username, String path) {
        this.username = username;
        this.path = path;
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
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    public String toString() {
        return "Avatar{username = " + username + ", path = " + path + "}";
    }
}
