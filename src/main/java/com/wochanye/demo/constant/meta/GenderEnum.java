package com.wochanye.demo.constant.meta;

/**
 * 性别枚举
 *
 * @author cuijie
 * @since 2018-06-27
 */
public enum GenderEnum {

    //男女
    MALE("M", "男"), FEMALE("F", "女");

    private String gender;

    private String genderDesc;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGenderDesc() {
        return genderDesc;
    }

    public void setGenderDesc(String genderDesc) {
        this.genderDesc = genderDesc;
    }

    GenderEnum(String gender, String genderDesc) {
        this.gender = gender;
        this.genderDesc = genderDesc;
    }
}
