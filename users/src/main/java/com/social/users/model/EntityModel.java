package com.social.users.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EntityModel {
    private String createdTimestamp;
    private String modifiedTimestamp;
    public EntityModel() {
        this.createdTimestamp = getCurrentDateTime();
        this.modifiedTimestamp = getCurrentDateTime();
    }
    public String getCreatedTimestamp() {
        return createdTimestamp;
    }
    public void setCreatedTimestamp(String createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
    public String getModifiedTimestamp() {
        return modifiedTimestamp;
    }
    public void setModifiedTimestamp(String modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }
    
    public String getCurrentDateTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentDateTime.format(formatter);
    }
}
