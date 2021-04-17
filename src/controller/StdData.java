package controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StdData {
    public int getSno() {
        return Sno.get();
    }

    public SimpleIntegerProperty snoProperty() {
        return Sno;
    }

    public void setSno(int sno) {
        this.Sno.set(sno);
    }

    public String getStdName() {
        return stdName.get();
    }

    public SimpleStringProperty stdNameProperty() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName.set(stdName);
    }

    public int getRollno() {
        return rollno.get();
    }

    public SimpleIntegerProperty rollnoProperty() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno.set(rollno);
    }

    public String getDept() {
        return dept.get();
    }

    public SimpleStringProperty deptProperty() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept.set(dept);
    }

    public String getYear() {
        return year.get();
    }

    public SimpleStringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getSec() {
        return sec.get();
    }

    public SimpleStringProperty secProperty() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec.set(sec);
    }

    private final SimpleIntegerProperty Sno;
    private final SimpleStringProperty stdName;
    private final SimpleIntegerProperty rollno;
    private final SimpleStringProperty dept;
    private final SimpleStringProperty year;
    private final SimpleStringProperty sec;

    public StdData(Integer Sno, String stdname, Integer rollno, String dept, String year, String sec)
    {
        System.out.println(Sno+stdname);
        this.Sno=new SimpleIntegerProperty(Sno);
        this.rollno=new SimpleIntegerProperty(rollno);
        this.stdName=new SimpleStringProperty(stdname);
        this.dept=new SimpleStringProperty(dept);
        this.year=new SimpleStringProperty(year);
        this.sec=new SimpleStringProperty(sec);
    }
}
