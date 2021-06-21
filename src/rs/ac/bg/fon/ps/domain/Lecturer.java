/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Djina
 */
public class Lecturer implements Serializable, GenericEntity{
    private Long id;
    private String firstname;
    private String lastname;
    private String profession;

    public Lecturer() {
    }

    public Lecturer(Long id, String firstname, String lastname, String profession) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profession = profession;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.firstname);
        hash = 79 * hash + Objects.hashCode(this.lastname);
        hash = 79 * hash + Objects.hashCode(this.profession);
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
        final Lecturer other = (Lecturer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "lecturer";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "firstName, lastName, profession";
    }

    @Override
    public String getInsertValues() {
        return "'" + firstname + "', '" + lastname + "', '" + profession + "' ";
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
        return "firstName='" + firstname + "', lastname='" + lastname + "', profession='" + profession + "' ";
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Lecturer lecturer = new Lecturer();
            lecturer.setId(rs.getLong("id"));
            lecturer.setFirstname(rs.getString("firstName"));
            lecturer.setLastname(rs.getString("lastName"));
            lecturer.setProfession(rs.getString("profession"));
   
            list.add(lecturer);
        }
        return list;
    }

    @Override
    public String getDeleteContidionForItem() {
        return null;
    }
    
    
    
}
