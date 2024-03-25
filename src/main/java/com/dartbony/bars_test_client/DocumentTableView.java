package com.dartbony.bars_test_client;

import javafx.scene.control.CheckBox;

import java.time.*;
import java.util.concurrent.TimeUnit;

public class DocumentTableView {
    private Integer number;
    private CheckBox actual;
    private LocalDateTime date;
    private LocalDateTime updateDate;

    public DocumentTableView(Integer number, LocalDateTime date, LocalDateTime updateDate) {
        this.date = date;
        this.number = number;
        this.updateDate = updateDate;
        this.actual = this.initCheckBox();
    }

    private CheckBox initCheckBox() {
        var checkbox = new CheckBox();
        checkbox.setSelected(this.checkActual());
        checkbox.setDisable(true);
        return checkbox;
    }

    private boolean checkActual() {
        if(this.updateDate == null)
            return false;
        var dayDifferences = this.getDifference();
        return dayDifferences > 60;
    }

    private long getDifference() {
        var updateDateMillis = this.updateDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        var currentMillis = System.currentTimeMillis();
        var diff = Math.abs(currentMillis - updateDateMillis);
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public Integer getNumber() {
        return this.number;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }

    public CheckBox getActual() {
        return this.actual;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setActual(CheckBox actual) {
        this.actual = actual;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
