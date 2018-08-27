package cn.kay.zhazha.domain;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UnClockHtml {
    private String id;
    private String dept;
    private String name;
    private Date time;
    private String type;
}
