/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Djina
 */
public class Student implements Serializable, GenericEntity{
    private Long id;
    private String firstname;
    private String lastname;
    private String studentIDNumber;
    private int yearOfStudy;
    private Double averageGrade;
    private Faculty faculty;
    private User user;
    private ArrayList<CourseItem> items;

    public Student() {
    }

    public Student(Long id, String firstname, String lastname, String studentIDNumber, int yearOfStudy, Double averageGrade, Faculty faculty, User user, ArrayList<CourseItem> items) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentIDNumber = studentIDNumber;
        this.yearOfStudy = yearOfStudy;
        this.averageGrade = averageGrade;
        this.faculty = faculty;
        this.user = user;
        this.items = items;
    }

    
    


    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStudentIDNumber() {
        return studentIDNumber;
    }

    public void setStudentIDNumber(String studentIDNumber) {
        this.studentIDNumber = studentIDNumber;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }
    
    

    @Override
    public String toString() {
        return firstname  + " " + lastname;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.firstname);
        hash = 29 * hash + Objects.hashCode(this.lastname);
        hash = 29 * hash + Objects.hashCode(this.studentIDNumber);
        hash = 29 * hash + this.yearOfStudy;
        hash = 29 * hash + Objects.hashCode(this.averageGrade);
        hash = 29 * hash + Objects.hashCode(this.faculty);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "student";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "firstname, lastname, studentIDNumber, yearOfStudy, averageGrade, facultyid, userid";
    }

    @Override
    public String getInsertValues() {
        return "'" + firstname + "', '" + lastname + "', '" + studentIDNumber + "', " + 
                     yearOfStudy + ", " + averageGrade + ", " + faculty.getId() + ", " + user.getId();
    }

    @Override
    public void setID(Long id) {
        this.id = id;
    }

    @Override
    public String getSelectContidion() {
        return "id=" + id;
    }

    @Override
    public String getDeleteContidion() {
        return "id=" + id;
    }

    @Override
    public String getUpdateCondition() {
        return "id=" + id;
    }

    @Override
    public String setAttributes() {
        return "firstname='" + firstname + "', lastname='" + lastname + "', studentIDNumber='" +
                studentIDNumber + "', yearOfStudy=" + yearOfStudy + ", averageGrade=" + averageGrade +
                ", facultyid=" + faculty.getId() + ", userid=" + user.getId();
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            Faculty faculty = new Faculty();
            User user = new User();
            student.setId(rs.getLong("id"));
            student.setFirstname(rs.getString("firstname"));
            student.setLastname(rs.getString("lastname"));
            student.setStudentIDNumber(rs.getString("studentIDNumber"));
            student.setAverageGrade(rs.getDouble("averageGrade"));
            student.setYearOfStudy(rs.getInt("yearOfStudy"));
            faculty.setId(rs.getLong("facultyid"));
            user.setId(rs.getLong("userid"));
            student.setFaculty(faculty);
            student.setUser(user);

            list.add(student);
        }
        return list;
        
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String getDeleteContidionForItem() {
        return null;
    }

    public ArrayList<CourseItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CourseItem> items) {
        this.items = items;
    }

}
