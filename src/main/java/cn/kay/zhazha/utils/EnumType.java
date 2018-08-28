package cn.kay.zhazha.utils;

/**
 * TODO java-doc
 * Created by gongchen on 2018-1-15.
 */
public enum EnumType {
    NEW(0, "新建"),
    VALID(1, "有效"),
    INVALID(2, "无效");

    private Integer type;
    private String desc;
    private String code;

    EnumType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
