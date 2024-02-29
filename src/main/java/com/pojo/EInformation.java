package com.pojo;

public class EInformation {
    private String username;
    private String name;
    private String cellphoneNumber;
    private String email;
    private String address;
    private String description;
    private String currentRow;

    public String getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(String currentRow) {
        this.currentRow = currentRow;
    }

    public EInformation() {
    }

    public EInformation(String name, String cellphoneNumber, String email, String address, String description) {
        this.username = name;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
        this.address = address;
        this.description = description;
    }

    public EInformation(String username, String name, String cellphoneNumber, String email, String address, String description) {
        this.username = username;
        this.name = name;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
        this.address = address;
        this.description = description;
    }

    /**
     * 获取
     *
     * @return name
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
     * @return cellphoneNumber
     */
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    /**
     * 设置
     *
     * @param cellphoneNumber
     */
    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    /**
     * 获取
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "{username:'" + username + "',name :'" + name + "', cellphoneNumber : '" + cellphoneNumber + "', email : '" + email + "', address :'" + address + "', description :'" + description + "'}";
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
}
