package org.groupname.studyapp;

public class QuizSession {
private int qNo;
private String section;
private String question;
private String optionA;
private String optionB;
private String optionC;
private String optionD;
private boolean quizCompleted;
private int score;

public QuizSession(int qNo, String section, String question, String optionA, String optionB, String optionC,
String optionD, boolean quizCompleted, int score) {
this.qNo = qNo;
this.section = section;
this.question = question;
this.optionA = optionA;
this.optionB = optionB;
this.optionC = optionC;
this.optionD = optionD;
this.quizCompleted = quizCompleted;
this.score = score;
}
public int getqNo() {
return qNo;
}
public void setqNo(int qNo) {
this.qNo = qNo;
}
public String getQuestion() {
return question;
}
public void setQuestion(String question) {
this.question = question;
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
public boolean isQuizCompleted() {
return quizCompleted;
}
public void setQuizCompleted(boolean quizCompleted) {
this.quizCompleted = quizCompleted;
}
public int getScore() {
return score;
}
public void setScore(int score) {
this.score = score;
}
public String getSection() {
return section;
}
public void setSection(String section) {
this.section = section;
}
}