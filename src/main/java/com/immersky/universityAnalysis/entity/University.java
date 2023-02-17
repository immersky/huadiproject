package com.immersky.universityAnalysis.entity;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class University {
    private Integer university_id/*高校ID*/;
    private Integer university_province;
    private String university_name/*高校登录名*/;
    private String university_type;
    private String university_location;
    private String university_ranks;
    private Integer university_popularity;
    private String university_majors;
    private String university_desc;

    public University(Integer university_id, Integer university_province, String university_name, String university_type, String university_location, String university_ranks, Integer university_popularity, String university_majors, String university_desc) {
        this.university_id = university_id;
        this.university_province = university_province;
        this.university_name = university_name;
        this.university_type = university_type;
        this.university_location = university_location;
        this.university_ranks = university_ranks;
        this.university_popularity = university_popularity;
        this.university_majors = university_majors;
        this.university_desc = university_desc;
    }

    public University() {

    }

    public Integer getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(Integer university_id) {
        this.university_id = university_id;
    }

    public Integer getUniversity_province() {
        return university_province;
    }

    public void setUniversity_province(Integer university_province) {
        this.university_province = university_province;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public University setUniversity_name(String university_name) {
        this.university_name = university_name;
        return this;
    }

    public String getUniversity_type() {
        return university_type;
    }

    public void setUniversity_type(String university_type) {
        this.university_type = university_type;
    }

    public String getUniversity_location() {
        return university_location;
    }

    public void setUniversity_location(String university_location) {
        this.university_location = university_location;
    }

    public String getUniversity_ranks() {
        return university_ranks;
    }

    public void setUniversity_ranks(String university_ranks) {
        this.university_ranks = university_ranks;
    }

    public Integer getUniversity_popularity() {
        return university_popularity;
    }

    public void setUniversity_popularity(Integer university_popularity) {
        this.university_popularity = university_popularity;
    }

    public String getUniversity_majors() {
        return university_majors;
    }

    public void setUniversity_majors(String university_majors) {
        this.university_majors = university_majors;
    }

    public String getUniversity_desc() {
        return university_desc;
    }

    public void setUniversity_desc(String university_desc) {
        this.university_desc = university_desc;
    }

    @Override
    public String toString() {
        return "University{" +
                "university_id=" + university_id +
                ", university_province=" + university_province +
                ", university_name='" + university_name + '\'' +
                ", university_type='" + university_type + '\'' +
                ", university_location='" + university_location + '\'' +
                ", university_ranks='" + university_ranks + '\'' +
                ", university_popularity=" + university_popularity +
                ", university_majors='" + university_majors + '\'' +
                ", university_desc='" + university_desc + '\'' +
                '}';
    }
    public String getUniversity_address()
    {
        switch (this.university_id)
        {
            case 11:return "北京";
            case 12:return "天津";
            case 13:return "河北";
            case 14:return "山西";
            case 15:return "内蒙古";
            case 21:return "辽宁";
            case 22:return "吉林";
            case 23:return "黑龙江";
            case 31:return "上海";
            case 32:return "江苏";
            case 33:return "浙江";
            case 34:return "安徽";
            case 35:return "福建";
            case 36:return "江西";
            case 37:return "山东";
            case 41:return "河南";
            case 42:return "湖北";
            case 43:return "湖南";
            case 44:return "广东";
            case 45:return "广西";
            case 46:return "海南";
            case 50:return "重庆";
            case 51:return "四川";
            case 52:return "贵州";
            case 53:return "云南";
            case 54:return "西藏";
            case 61:return "陕西";
            case 62:return "甘肃";
            case 63:return "青海";
            case 64:return "宁夏";
            case 65:return "新疆";
            case 71:return "台湾";
            case 81:return "香港";
            case 82:return "澳门";


            default: return "暂无地址";
        }




    }
}

