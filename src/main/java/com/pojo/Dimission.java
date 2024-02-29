package com.pojo;

public class Dimission {
    private String username;
    private String name;
    private String reason;
    private String status;

    public Dimission() {
    }

    public Dimission(String username, String name, String reason, String status) {
        this.username = username;
        this.name = name;
        this.reason = reason;
        this.status = status;
    }

    /**
     * 获取
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置
     *
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "{name : '" + name + "', reason : '" + reason + "', status : '" + status + "'}";

    }
}
