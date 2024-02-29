package com.pojo;

import java.io.Serializable;

public class Activity implements Serializable {
    private static final long serialVersionUID=4390482518182625971L;
    private String username;
    private String name;
    private String startTime;
    private String endTime;
    private String content;
    private String count;
    private String currentRow;

    public Activity() {
    }


    public Activity(String username, String name, String startTime, String endTime, String content, String count, String currentRow) {
        this.username = username;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.content = content;
        this.count = count;
        this.currentRow = currentRow;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(String currentRow) {
        this.currentRow = currentRow;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取
     *
     * @return count
     */
    public String getCount() {
        return count;
    }

    /**
     * 设置
     *
     * @param count
     */
    public void setCount(String count) {
        this.count = count;
    }

    public String toString() {
        return "{name : '" + name + "', startTime :'" + startTime + "', endTime : '" + endTime + "', content : '" + content + "',count:'" + count + "',username:'" + username + "',currentRow:'" + currentRow + "'}";
    }

}
