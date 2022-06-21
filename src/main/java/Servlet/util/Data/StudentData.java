package Servlet.util.Data;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentData extends User {
    private String name;
    private Boolean sex;
    private String birthday;
    private String idcard;


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

    public java.sql.Date getBirthday() {
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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

}
