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
public class Faculty implements Serializable, GenericEntity{
    private Long id;
    private String name;
    private String city;
    private String country;

    public Faculty() {
    }

    public Faculty(Long id, String name, String city, String country) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name + " (" + country + " ," + city + ")";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.city);
        hash = 29 * hash + Objects.hashCode(this.country);
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
        final Faculty other = (Faculty) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "faculty";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, city, country ";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "', '" + city + "', '" + country + "' ";
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
        return "name='" + name + "', city='" + city + "', country='" + country + "' ";
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Faculty faculty = new Faculty();
            faculty.setId(rs.getLong("id"));
            faculty.setName(rs.getString("name"));
            faculty.setCity(rs.getString("city"));
            faculty.setCountry(rs.getString("country"));
            

            list.add(faculty);
        }
        return list;
    }

    @Override
    public String getDeleteContidionForItem() {
        return null;
    }
    
    
    
}
