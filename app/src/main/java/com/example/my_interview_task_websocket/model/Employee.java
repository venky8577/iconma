package com.example.my_interview_task_websocket.model;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee extends SugarRecord implements Serializable {
        String name;
        String lastName;
        String eid;
        String team;
        ArrayList<Questions> questions;

        public Employee(){
        }

        public Employee(String name, String lastName,String eid,String team,ArrayList<Questions> questions){
            this.name = name;
            this.lastName = lastName;
            this.eid = eid;
            this.team = team;
            this.questions = questions;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Questions> questions) {
        this.questions = questions;
    }
}


