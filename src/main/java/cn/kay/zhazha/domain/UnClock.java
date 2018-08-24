package cn.kay.zhazha.domain;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

public class UnClock {
    private String dept;
    private String name;
    private String duty;
    private String reason;
    private Date date;
    private String type;

    public UnClock() {
    }

    public UnClock(String dept, String name, String duty, String reason, Date date, String type) {
        this.dept = dept;
        this.name = name;
        this.duty = duty;
        this.reason = reason;
        this.date = date;
        this.type = type;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDept() {
        return dept;
    }

    public String getName() {
        return name;
    }

    public String getDuty() {
        return duty;
    }

    public String getReason() {
        return reason;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
