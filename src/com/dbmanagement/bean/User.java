/*
 * User.java
 *
 * Created on February 25, 2010, 10:44 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.dbmanagement.bean;

/**
 *
 * @author bishnu
 */
public class User {
    
    private  String userid=null;
    private  String password=null;
    private  String email=null;
    private  String contactno=null;
    
    
    /** Creates a new instance of User */
    public User() {
    }

    /**
     * Getter for property userid.
     * @return Value of property userid.
     */
    public String getUserid() {
        return this.userid;
    }

    /**
     * Setter for property userid.
     * @param userid New value of property userid.
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Getter for property password.
     * @return Value of property password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter for property password.
     * @param password New value of property password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for property email.
     * @return Value of property email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter for property email.
     * @param email New value of property email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for property contactno.
     * @return Value of property contactno.
     */
    public String getContactno() {
        return this.contactno;
    }

    /**
     * Setter for property contactno.
     * @param contactno New value of property contactno.
     */
    public void setContactno(String contactno) {
        this.contactno = contactno;
    }
    
    
    
}
