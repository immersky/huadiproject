package com.immersky.universityAnalysis.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.core.ReactiveAdapterRegistry;

public class Grade
{
    private String grade_universityName;
    private String grade_year;
    private String grade_rank;
    private String grade_location;
    private String grade_type;
    private String grade_predict;
    public String getGrade_predict() {
        return grade_predict;
    }

    public void setGrade_predict(String grade_predict) {
        this.grade_predict = grade_predict;
    }


    public Grade(String grade_universityName, String grade_year, String grade_rank) {
        this.grade_universityName = grade_universityName;
        this.grade_year = grade_year;
        this.grade_rank = grade_rank;
    }

    public Grade()
    {
    grade_location="11";
     grade_type="理科";
     grade_rank="-1/-1";
    }

    public String getGrade_universityName() {
        return grade_universityName;
    }

    public Grade setGrade_universityName(String grade_universityName) {
        this.grade_universityName = grade_universityName;
        return this;
    }

    public String getGrade_year() {
        return grade_year;
    }

    public void setGrade_year(String grade_year) {
        this.grade_year = grade_year;
    }

    public String getGrade_rank() {
        return grade_rank;
    }

    public void setGrade_rank(String grade_rank) {
        this.grade_rank = grade_rank;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade_universityName='" + grade_universityName + '\'' +
                ", grade_year='" + grade_year + '\'' +
                ", grade_rank='" + grade_rank + '\'' +
                ", grade_location='" + grade_location + '\'' +
                ", grade_type='" + grade_type + '\'' +
                ", grade_predict='" + grade_predict + '\'' +
                '}';
    }


    public void create(String grade_location)
    {
        JSONObject object =JSONObject.parseObject(this.grade_rank);
        String value64 = object.getString(grade_location);
        System.out.println(this.grade_rank);
        if (value64==null)
        {
            this.grade_rank="-1/-1";
        }
        else
        {
            this.grade_rank=value64;
        }
        String[] parts = this.getGrade_rank().split("/");
        System.out.println(parts[0]);
        this.setGrade_predict(String.valueOf( Integer.valueOf(parts[0].trim())+Double.valueOf(parts[0].trim())/300.1));
        this.grade_location=get_address(grade_location);


    }
    public String get_address(String grade_location)
    {
        switch (Integer.valueOf(grade_location))
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

    public int getTrueValue()
    {
        String[] parts = this.getGrade_rank().split("/");
        System.out.println(parts[0]);

        return Integer.valueOf(parts[0].trim());
    }

    public String getGrade_location() {
        return grade_location;
    }

    public void setGrade_location(String grade_location) {
        this.grade_location = grade_location;
    }

    public String getGrade_type() {
        return grade_type;
    }

    public void setGrade_type(String grade_type) {
        this.grade_type = grade_type;
    }
}
