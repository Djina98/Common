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
public class Course implements Serializable, GenericEntity{
    
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private int numberOfStudents;
    private Lecturer lecturer;
    private Location location;
    private List<CourseItem> courseItems;
    private User user;

    public Course() {
        courseItems = new ArrayList<>();
    }

    public Course(Long id, String name, Date startDate, Date endDate, int numberOfStudents, Lecturer lecturer, Location location, List<CourseItem> courseItems, User user) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfStudents = numberOfStudents;
        this.lecturer = lecturer;
        this.location = location;
        this.courseItems = courseItems;
        this.user = user;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.startDate);
        hash = 71 * hash + Objects.hashCode(this.endDate);
        hash = 71 * hash + this.numberOfStudents;
        hash = 71 * hash + Objects.hashCode(this.lecturer);
        hash = 71 * hash + Objects.hashCode(this.location);
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<CourseItem> getCourseItems() {
        return courseItems;
    }

    public void setCourseItems(List<CourseItem> courseItems) {
        this.courseItems = courseItems;
    }

    @Override
    public String getTableName() {
        return "course";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, startDate, endDate, numberOfStudents, lecturerid, locationid, userid ";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "', '" + new java.sql.Date(startDate.getTime()) + "', '" + new java.sql.Date(endDate.getTime()) + "', " + numberOfStudents + ", " + 
                     lecturer.getId() + ", " + location.getId() + ", " + user.getId();
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
        return "name='" + name + "', startDate='" + new java.sql.Date(startDate.getTime()) + "', endDate='" + new java.sql.Date(endDate.getTime()) +
                "', numberOfStudents='" + numberOfStudents + "', lecturerid=" + lecturer.getId() +
                ", locationid=" + location.getId() + ", userid=" + user.getId();
    }

    @Override
    public void setID(Long id) {
        this.id = id;
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Course course = new Course();
            Lecturer lecturer = new Lecturer();
            Location location = new Location();
            User user = new User();
            
            course.setId(rs.getLong("id"));
            course.setName(rs.getString("name"));
            Date startDate = new Date(rs.getDate("startDate").getTime());
            course.setStartDate(startDate);
            Date endDate = new Date(rs.getDate("endDate").getTime());
            course.setEndDate(endDate);
            course.setNumberOfStudents(rs.getInt("numberOfStudents"));
            lecturer.setId(rs.getLong("lecturerid"));
            location.setId(rs.getLong("locationid"));
            user.setId(rs.getLong("userid"));
            course.setLecturer(lecturer);
            course.setLocation(location);
            course.setUser(user);
            

            list.add(course);
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

   
}
