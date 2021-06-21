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
public class User implements Serializable, GenericEntity{
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    public User() {
    }

    public User(Long id, String firstname, String lastname, String username, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.firstname);
        hash = 37 * hash + Objects.hashCode(this.lastname);
        hash = 37 * hash + Objects.hashCode(this.username);
        hash = 37 * hash + Objects.hashCode(this.password);
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
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "firstname, lastname, username, password ";
    }

    @Override
    public String getInsertValues() {
        return "'" + firstname + "', '" + lastname + "', '" + username + "', '" + password + "' ";
    }

    @Override
    public void setID(Long id) {
        this.id = id;
    }

    @Override
    public String getSelectContidion() {
        if (username != null) {
            return "username='" + username + "' and password='" + password + "'";
        } else {
            return "id=" + id;
        }
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
        return "firstname='" + firstname + "', lastname='" + lastname + "', username='" +
                username + "', password='" + password + "' ";
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            
            list.add(user);
        }
        return list;
    }

    @Override
    public String getDeleteContidionForItem() {
        return null;
    }
    
}
