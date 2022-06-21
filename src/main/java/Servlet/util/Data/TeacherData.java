package Servlet.util.Data;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TeacherData extends User {
    private String name;
    private Boolean sex;
    private String idcard;
    private String major;
    private String birthday;
    private String edu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getBirthday() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return new Date(ft.parse(this.birthday).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

}
