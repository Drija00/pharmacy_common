/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Cartman
 */
public class Request implements Serializable{
    private Operation operation;
    private Object request;

    public Request() {
    }

    public Request(Operation operation, Object request) {
        this.operation = operation;
        this.request = request;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getRequest() {
        return request;
    }

    public void setRequest(Object request) {
        this.request = request;
    }

    
    
    
}
