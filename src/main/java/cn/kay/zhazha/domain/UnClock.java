package cn.kay.zhazha.domain;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UnClock {
    private String dept;
    private String name;
    private String duty;
    private String reason;
    private Date date;
    private String type;
}
