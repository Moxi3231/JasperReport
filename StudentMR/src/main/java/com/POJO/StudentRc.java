/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.POJO;

/**
 *
 * @author moxan
 */
public class StudentRc {
    public String name;
    public float percentage;
    public String university;

    public StudentRc(String name, float percentage, String university) {
        this.name = name;
        this.percentage = percentage;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "StudentRc{" + "name=" + name + ", percentage=" + percentage + ", university=" + university + '}';
    }

    public StudentRc() {
    }

   
    
}
