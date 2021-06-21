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
public class Location implements Serializable, GenericEntity{
    private Long id;
    private String streetAddress;
    private String city;

    public Location() {
    }

    public Location(Long id, String streetAddress, String city) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return streetAddress + ", " + city;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.streetAddress);
        hash = 37 * hash + Objects.hashCode(this.city);
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "location";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "streetAddress, city";
    }

    @Override
    public String getInsertValues() {
        return "'" + streetAddress + "', '" + city + "' ";
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
        return "streetAddress='" + streetAddress + "', city='" + city + "'" ;
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Location location = new Location();
            location.setId(rs.getLong("id"));
            location.setStreetAddress(rs.getString("streetAddress"));
            location.setCity(rs.getString("city")); 

            list.add(location);
        }
        return list;
    }

    @Override
    public String getDeleteContidionForItem() {
        return null;
    }
    
    
    
    
}
