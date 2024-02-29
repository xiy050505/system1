package com.pojo;

public class Attendance {
    private String year;
    private String lastYear;
    private String month;
    private String username;
    private String late;
    private String early;
    private String absence;
    private String afl;
    private String type;
    private String date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Attendance() {
    }

    public Attendance(String username, String late, String early, String absence, String afl) {
        this.username = username;
        this.late = late;
        this.early = early;
        this.absence = absence;
        this.afl = afl;
    }

    public Attendance(String year, String month, String username, String late, String early, String absence, String afl) {
        this.year = year;
        this.month = month;
        this.username = username;
        this.late = late;
        this.early = early;
        this.absence = absence;
        this.afl = afl;
    }

    public Attendance(String year, String lastYear, String month, String username, String late, String early, String absence, String afl) {
        this.year = year;
        this.lastYear = lastYear;
        this.month = month;
        this.username = username;
        this.late = late;
        this.early = early;
        this.absence = absence;
        this.afl = afl;
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
     * @return late
     */
    public String getLate() {
        return late;
    }

    /**
     * 设置
     * @param late
     */
    public void setLate(String late) {
        this.late = late;
    }

    /**
     * 获取
     * @return early
     */
    public String getEarly() {
        return early;
    }

    /**
     * 设置
     * @param early
     */
    public void setEarly(String early) {
        this.early = early;
    }

    /**
     * 获取
     * @return absence
     */
    public String getAbsence() {
        return absence;
    }

    /**
     * 设置
     * @param absence
     */
    public void setAbsence(String absence) {
        this.absence = absence;
    }

    /**
     * 获取
     * @return afl
     */
    public String getAfl() {
        return afl;
    }

    /**
     * 设置
     * @param afl
     */
    public void setAfl(String afl) {
        this.afl = afl;
    }



    /**
     * 获取
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取
     * @return month
     */
    public String getMonth() {
        return month;
    }

    /**
     * 设置
     * @param month
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * 获取
     * @return lastYear
     */
    public String getLastYear() {
        return lastYear;
    }

    /**
     * 设置
     * @param lastYear
     */
    public void setLastYear(String lastYear) {
        this.lastYear = lastYear;
    }

    public String toString() {
        return "{year:" + year +", month:" + month + ", username :" + username + ", late: " + late + ", early :" + early + ", absence : " + absence + ", afl : " + afl + "}";
    }
}
