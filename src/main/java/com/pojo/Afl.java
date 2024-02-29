package com.pojo;

import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSessionFactory;

public class Afl {
    private String username;
    private String name;
    private String date;
    private String startTime;
    private String endTime;
    private String reason;
    private String status;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Afl() {

    }

    public Afl(String username, String name, String startTime, String endTime, String reason, String status) {
        this.username = username;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
        this.status = status;
    }

    public Afl(String username, String name, String date, String startTime, String endTime, String reason, String status) {
        this.username = username;
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
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
     * @return startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置
     *
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取
     *
     * @return endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置
     *
     * @param endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
        return "{name : '" + name + "', startTime : '" + startTime + "', endTime : '" + endTime + "', reason : '" + reason + "',type:'" + type + "', status : '" + status + "'}";
    }

    /**
     * 获取
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
}
