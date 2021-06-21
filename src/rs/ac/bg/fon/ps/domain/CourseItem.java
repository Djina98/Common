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
public class CourseItem implements Serializable, GenericEntity{
    
    private Course course;
    private int id;
    private Student student;
    private double examScore;
    private double totalScore;
    private String status  = "";

    public CourseItem() {
    }

    public CourseItem(Course course, int id, Student student, double examScore) {
        this.course = course;
        this.id = id;
        this.student = student;
        this.examScore = examScore;
    }
    
    

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getExamScore() {
        return examScore;
    }

    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }

    @Override
    public String toString() {
        return "CourseItem{" + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.course);
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.student);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.examScore) ^ (Double.doubleToLongBits(this.examScore) >>> 32));
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
        final CourseItem other = (CourseItem) obj;
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String getTableName() {
        return "course_item";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, studentid, examScore, totalScore, courseid";
    }

    @Override
    public String getInsertValues() {
        return id + ", " + student.getId() + ", " + 
                examScore + ", " + totalScore + ", " + course.getId();
    }

    @Override
    public void setID(Long id) {
        course.setId(id);
    }

    @Override
    public String getSelectContidion() {
        if (course != null) {
            return "courseid= " + course.getId();
        } else {
            return "id = " + id + " and courseid= " + course.getId();
        }
    }

    @Override
    public String getDeleteContidion() {
        return "id = " + id + " and courseid= " + course.getId();     
    }

    @Override
    public String getUpdateCondition() {
        return "id = " + id + " and courseid= " + course.getId();
    }

    @Override
    public String setAttributes() {
        return "id=" + id + ", studentid=" + student.getId() + 
                ", examScore=" + examScore + ", totalScore=" + totalScore +
                ", courseid=" + course.getId();
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();

        while (rs.next()) {
            CourseItem item = new CourseItem();
            Student student = new Student();
            Course course = new Course();
            item.setId(rs.getInt("id")); 
            student.setId(rs.getLong("studentid"));
            item.setStudent(student);
            item.setExamScore(rs.getDouble("examScore"));
            item.setTotalScore(rs.getDouble("totalScore"));
            course.setId(rs.getLong("courseid"));
            item.setCourse(course);
           
                    

            list.add(item);
        }
        return list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getDeleteContidionForItem() {
        return "studentid=" + student.getId();
    }

    
    
    
    
    
}
