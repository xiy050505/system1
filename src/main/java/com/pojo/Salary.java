package com.pojo;

public class Salary {
    private String username;
    private String year;
    private String month;
    private String basicSalary;
    private String award;
    private String performance;

    public Salary() {
    }

    public Salary(String username, String year, String month, String basicSalary, String award, String performance) {
        this.username = username;
        this.year = year;
        this.month = month;
        this.basicSalary = basicSalary;
        this.award = award;
        this.performance = performance;
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
     * @return basicSalary
     */
    public String getBasicSalary() {
        return basicSalary;
    }

    /**
     * 设置
     * @param basicSalary
     */
    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * 获取
     * @return award
     */
    public String getAward() {
        return award;
    }

    /**
     * 设置
     * @param award
     */
    public void setAward(String award) {
        this.award = award;
    }

    /**
     * 获取
     * @return performance
     */
    public String getPerformance() {
        return performance;
    }

    /**
     * 设置
     * @param performance
     */
    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String toString() {
        return "{username: " + username + ", year: " + year + ", month :" + month + ", basicSalary :" + basicSalary + ", award : " + award + ", performance : " + performance + "}";
    }
}
