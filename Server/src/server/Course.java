/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author admin
 */
public class Course {
    String Subject,username,firstname,lastname;
    int Section;

    public Course(String Subject, String username, String firstname, String lastname, int Section) {
        this.Subject = Subject;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.Section = Section;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getSection() {
        return Section;
    }

    public void setSection(int Section) {
        this.Section = Section;
    }

        
}
