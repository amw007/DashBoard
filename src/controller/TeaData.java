package controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TeaData {
    private final SimpleIntegerProperty sno;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty email;
    private final SimpleStringProperty StaffPost;
    private final SimpleStringProperty year;
    private final SimpleStringProperty sec;

    public TeaData(int sno, String name, String email, String staffPost, String year, String sec) {
        this.sno = new SimpleIntegerProperty(sno);
        this.Name =new SimpleStringProperty(name);
        this.email =new SimpleStringProperty(email);
        this.StaffPost = new SimpleStringProperty(staffPost);
        this.year = new SimpleStringProperty(year);
        this.sec = new SimpleStringProperty(sec);
    }

    public int getSno() {
        return sno.get();
    }

    public SimpleIntegerProperty snoProperty() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno.set(sno);
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getStaffPost() {
        return StaffPost.get();
    }

    public SimpleStringProperty staffPostProperty() {
        return StaffPost;
    }

    public void setStaffPost(String staffPost) {
        this.StaffPost.set(staffPost);
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
}
