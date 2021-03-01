package org.groupname.studyapp;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Service;

@Service
public class StudyAppService {
Configuration con=new Configuration().configure().addAnnotatedClass(QuizQuestion.class);
ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
SessionFactory sf=con.buildSessionFactory(reg);
Session session=sf.openSession();
Transaction tx=session.beginTransaction();

Query q1 = session.createQuery("from QuizQuestion where section='Section 1' and difficulty='Easy'");
List<QuizQuestion> s1EQList=q1.list();
Query q2 = session.createQuery("from QuizQuestion where section='Section 1' and difficulty='Medium'");
List<QuizQuestion> s1MQList=q2.list();
Query q3 = session.createQuery("from QuizQuestion where section='Section 1' and difficulty='Hard'");
List<QuizQuestion> s1HQList=q3.list();
Query q4 = session.createQuery("from QuizQuestion where section='Section 2' and difficulty='Easy'");
List<QuizQuestion> s2EQList=q4.list();
Query q5 = session.createQuery("from QuizQuestion where section='Section 2' and difficulty='Medium'");
List<QuizQuestion> s2MQList=q5.list();
Query q6 = session.createQuery("from QuizQuestion where section='Section 2' and difficulty='Hard'");
List<QuizQuestion> s2HQList=q6.list();
Query q7 = session.createQuery("from QuizQuestion where section='Section 3' and difficulty='Easy'");
List<QuizQuestion> s3EQList=q7.list();
Query q8 = session.createQuery("from QuizQuestion where section='Section 3' and difficulty='Medium'");
List<QuizQuestion> s3MQList=q8.list();
Query q9 = session.createQuery("from QuizQuestion where section='Section 3' and difficulty='Hard'");
List<QuizQuestion> s3HQList=q9.list();

//QuizSession qs=new QuizSession();
int score=0;
int currQNo=1;
String currDifficulty="Easy";
String currSection="Section 1";
QuizQuestion currQ=new QuizQuestion();

QuizSession generateQuestion() {
score=0;
currQNo=1;
currDifficulty="Easy";
currSection="Section 1";
Random rand = new Random();
int randomIndex=rand.nextInt(s1EQList.size());
currQ=s1EQList.get(randomIndex);
s1EQList.remove(randomIndex);
return new QuizSession(currQNo,currQ.getSection(),currQ.getQuestion(),currQ.getOptionA(),currQ.getOptionB(),currQ.getOptionC(),currQ.getOptionD(),false,0);
}

QuizSession generateQuestion(String response) {
boolean currQResult=returnResult(response);
if(currQResult) {
score += generateCurrQScore();
}
currQNo++;
currDifficulty=adjustDifficulty(currQResult);
Random rand = new Random();
if(currQNo<11) {
if(currDifficulty.equals("Easy")) {
int randomIndex=rand.nextInt(s1EQList.size());
currQ=s1EQList.get(randomIndex);
s1EQList.remove(randomIndex);
}
else if(currDifficulty.equals("Medium")) {
int randomIndex=rand.nextInt(s1MQList.size());
currQ=s1MQList.get(randomIndex);
s1MQList.remove(randomIndex);
}
else {
int randomIndex=rand.nextInt(s1HQList.size());
currQ=s1HQList.get(randomIndex);
s1HQList.remove(randomIndex);
}
return new QuizSession(currQNo,currQ.getSection(),currQ.getQuestion(),currQ.getOptionA(),currQ.getOptionB(),currQ.getOptionC(),currQ.getOptionD(),false,score);
}
else if((currQNo>=11) && (currQNo<21)) {
if(currDifficulty.equals("Easy")) {
int randomIndex=rand.nextInt(s2EQList.size());
currQ=s2EQList.get(randomIndex);
s2EQList.remove(randomIndex);
}
else if(currDifficulty.equals("Medium")) {
int randomIndex=rand.nextInt(s2MQList.size());
currQ=s2MQList.get(randomIndex);
s2MQList.remove(randomIndex);
}
else {
int randomIndex=rand.nextInt(s2HQList.size());
currQ=s2HQList.get(randomIndex);
s2HQList.remove(randomIndex);
}
return new QuizSession(currQNo,currQ.getSection(),currQ.getQuestion(),currQ.getOptionA(),currQ.getOptionB(),currQ.getOptionC(),currQ.getOptionD(),false,score);
}
else if((currQNo>=21) && (currQNo<31)) {
if(currDifficulty.equals("Easy")) {
int randomIndex=rand.nextInt(s3EQList.size());
currQ=s3EQList.get(randomIndex);
s3EQList.remove(randomIndex);
}
else if(currDifficulty.equals("Medium")) {
int randomIndex=rand.nextInt(s3MQList.size());
currQ=s3MQList.get(randomIndex);
s3MQList.remove(randomIndex);
}
else {
int randomIndex=rand.nextInt(s3HQList.size());
currQ=s3HQList.get(randomIndex);
s3HQList.remove(randomIndex);
}
return new QuizSession(currQNo,currQ.getSection(),currQ.getQuestion(),currQ.getOptionA(),currQ.getOptionB(),currQ.getOptionC(),currQ.getOptionD(),false,score);
}
else {
return new QuizSession(0,"","","","","","",true,score);
}
}

private int generateCurrQScore() {
if(currDifficulty.equals("Easy")) {
return 10;
}
else if(currDifficulty.equals("Medium")) {
return 15;
}
else return 20;
}

private String adjustDifficulty(boolean currQResult) {
if(currQResult) {
if(currDifficulty.equals("Easy")) {
currDifficulty="Medium";
}
else if(currDifficulty.equals("Medium")) {
currDifficulty="Hard";
}
else;
}
else {
if(currDifficulty.equals("Hard")) {
currDifficulty="Medium";
}
else if(currDifficulty.equals("Medium")) {
currDifficulty="Easy";
}
else;
}
return currDifficulty;
}

private boolean returnResult(String response) {
if(response.equals(currQ.getCorrectAns())) {
return true;
}
return false;
}

}