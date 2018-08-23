package cn.kay.zhazha.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private String dept;

    private String name;
    private String duty;
    private String reason;
    private Date date;
    private String type;

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId() {
        return id;
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
