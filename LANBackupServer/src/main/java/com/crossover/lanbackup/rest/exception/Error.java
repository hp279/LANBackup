package com.crossover.lanbackup.rest.exception;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class Error implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int statusCode;
    private String statusDescription;
    private String errorMessage;

    public Error() {}
    
    public Error(int statusCode, String statusDescription, String errorMessage) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
