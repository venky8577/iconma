package com.example.my_interview_task_websocket.model;

import com.orm.SugarRecord;

public class Questions extends SugarRecord {
    String question;
    String answer;
    String eid;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }
}
