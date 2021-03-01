package org.groupname.studyapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuizQuestion {
@Id
private int qno;
private String question;
private String optionA;
private String optionB;
private String optionC;
private String optionD;
private String correctAns;
private String difficulty;
private String section;

public int getQno() {
return qno;
}
public void setQno(int qno) {
this.qno = qno;
}
public String getOptionA() {
return optionA;
}
public void setOptionA(String optionA) {
this.optionA = optionA;
}
public String getOptionB() {
return optionB;
}
public void setOptionB(String optionB) {
this.optionB = optionB;
}
public String getOptionC() {
return optionC;
}
public void setOptionC(String optionC) {
this.optionC = optionC;
}
public String getOptionD() {
return optionD;
}
public void setOptionD(String optionD) {
this.optionD = optionD;
}
public String getCorrectAns() {
return correctAns;
}
public void setCorrectAns(String correctAns) {
this.correctAns = correctAns;
}
public String getDifficulty() {
return difficulty;
}
public void setDifficulty(String difficulty) {
this.difficulty = difficulty;
}
public String getSection() {
return section;
}
public void setSection(String section) {
this.section = section;
}
public String getQuestion() {
return question;
}
public void setQuestion(String question) {
this.question = question;
}
}

