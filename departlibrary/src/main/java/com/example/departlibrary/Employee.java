package com.example.departlibrary;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee extends SugarRecord implements Serializable {
        String name;
        String lastName;
        String eid;
        String team;

        public Employee(){
        }

        public Employee(String name, String lastName, String eid, String team){
            this.name = name;
            this.lastName = lastName;
            this.eid = eid;
            this.team = team;
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

}


