package com.dartbony.bars_test_client.dto;

import java.time.*;

public class Document {
    private Integer number;
    private LocalDateTime date;
    private LocalDateTime updateDate;

    public Integer getNumber() {
        return this.number;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}