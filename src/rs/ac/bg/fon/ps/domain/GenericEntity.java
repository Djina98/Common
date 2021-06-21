/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Djina
 */
public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();

    void setID(Long id);
    
    public String getSelectContidion();

    public String getDeleteContidion();
    
    public String getDeleteContidionForItem();

    public String getUpdateCondition();

    public String setAttributes();

    public List<GenericEntity> getList(ResultSet resultSet) throws Exception;

}
