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

    public Double percentage;
    public String university;
    public String background;

    public StudentRc(Double percentage, String university, String background) {
        this.percentage = percentage;
        this.university = university;
        this.background = background;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
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
        return "StudentRc{ percentage=" + percentage + ", university=" + university + '}';
    }

    public StudentRc() {
    }

}
