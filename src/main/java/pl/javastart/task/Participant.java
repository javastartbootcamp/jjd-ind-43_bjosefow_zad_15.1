package pl.javastart.task;

import java.util.prefs.PreferenceChangeListener;

public class Participant {
    private String firstname;
    private String lastname;
    private int result;

    public Participant(String firstname, String lastname, int result) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.result = result;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String toCsv() {
        return firstname + " " + lastname + ";" + result;
    }
}
