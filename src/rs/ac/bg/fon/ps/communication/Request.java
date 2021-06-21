/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.communication;

import java.io.Serializable;

/**
 *
 * @author Djina
 */
public class Request  implements Serializable{
    private Operation operation;
    private Object argument;

    public Request() {
    }

    public Request(Operation operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    
    
}
