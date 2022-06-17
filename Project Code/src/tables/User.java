
package tables;

import dbConnection.DBConnection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class User {
    
    private int id, depId, queue;
    private String name, surName, mail, class_,school, password;
    
    private ArrayList<String> tyt = new ArrayList<String>();
    private ArrayList<String> sayisal = new ArrayList<String>();
    private ArrayList<String> sozel = new ArrayList<String>();
    private ArrayList<String> esitAgirlik = new ArrayList<String>();
    
    DBConnection db = new DBConnection(); 
    
    
    public User(){
        
        addEsitAgirlik();
        addSayisal();
        addSozel();
        addTYT();
        
    }

    public User(int id, int depId, int queue, String name, String surName, String mail, String class_, String school, String password) {
        this.id = id;
        this.depId = depId;
        this.queue = queue;
        this.name = name;
        this.surName = surName;
        this.mail = mail;
        this.class_ = class_;
        this.school = school;
        this.password = password;
        
        addEsitAgirlik();
        addSayisal();
        addSozel();
        addTYT();
        
            
    }
    
      // methods...
    
    
    // secili okuldaki ya da herkesi iceren bilgi soru
    // ve net sayilarini sıraya sokan bir methods
    
    
    public ArrayList<Compare> getCompareList (String kind){
        
        ArrayList <Compare> compare_list = new ArrayList<Compare>();
         
        String query1 = "SELECT u.id, u.name , u.surname,u.school, SUM(q.qcount) AS qcount , SUM(q.netc) AS netc "
                      + " FROM User u  , Questions q "
                      + " WHERE u.id = q.user_id "
                      + " GROUP BY u.id, u.name, u.surname, u.school "
                      + " ORDER BY netc DESC";
        
        String query2 = "SELECT u.id, u.name , u.surname,u.school, SUM(q.qcount) AS qcount , SUM(q.netc) AS netc "
                      + " FROM User u  , Questions q "
                      + " WHERE u.id = q.user_id AND u.school = '"+kind+"' "
                      + " GROUP BY u.id, u.name, u.surname, u.school "
                      + " ORDER BY netc DESC";
        
        
        String query="";
        
        
        if(kind.equals("All Users")){
            
            query = query1;
        }
        else{
            
            query = query2;
            
        }
        
        
        int i = 1; // elimizle sira verecegiz :)
        
        try {
            
            db.sqlquery = db.con.createStatement();
            db.rs = db.sqlquery.executeQuery(query);
            
            while(db.rs.next()){
                
                Compare compare = new Compare();
                
                compare.setName(db.rs.getString("name"));
                compare.setNetc(db.rs.getDouble("netc"));
                compare.setQcount(db.rs.getInt("qcount"));
                compare.setSchool(db.rs.getString("school"));
                compare.setSequence(i);
                i=i+1;
                compare.setSurName(db.rs.getString("surname"));
                compare.setUser_id(db.rs.getInt("id"));
                
                
                compare_list.add(compare);
                
                
            }
            
            return  compare_list;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
            System.out.println("getCompareList ' da bir hata olustu");
            
            return null;
        }
        
       
    } 
    
    
    
    // bu metod bize o gun icersindeki farklı derslerle ilgili
    // toplam soru bilgilerini icerir
    
    public ArrayList<Question> getTotalLessonsQuestionNowCount(){
        
        
        ArrayList<Question> questions = new ArrayList<Question>();
        
        
        
        Date nowtime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String nowtime2=df.format(nowtime);
        
        
        
        String query = "SELECT user_id , lessons_id , udate , SUM(qcount) AS qcount , SUM(truec) AS truec ,"
                       + " SUM(falsec) AS falsec , SUM(emptyc) AS emptyc , SUM(netc) AS netc "
                       + " FROM Questions"
                       + " WHERE user_id = "+getId()+" AND udate = '"+nowtime2+"'"
                        + " GROUP BY user_id , lessons_id , udate";
        
        
        try {
            
            db.sqlquery = db.con.createStatement();
            db.rs = db.sqlquery.executeQuery(query);
            
            while(db.rs.next()){
                
                Question q = new Question();
                
                q.setDate(db.rs.getString("udate"));
                q.setLessonId(db.rs.getInt("lessons_id"));
                q.setNet(db.rs.getDouble("netc"));
                q.setUserId(db.rs.getInt("user_id"));
                q.seteCount(db.rs.getInt("emptyc"));
                q.setfCount(db.rs.getInt("falsec"));
                q.setqCount(db.rs.getInt("qcount"));
                q.settCount(db.rs.getInt("truec"));
                
                
               questions.add(q);
                
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
            System.out.println("getTotalLessonsQuestionNowCount ' da hata var ya da sorgu null dondu");
            
            return  null;
        }
                
    
        return questions;
        
    }
    
    // gecmisten bu gune gun icinde cozdugu toplam soru sayisini verir
    
    public ArrayList<Question> getDeeptoHighTotalQuestionsCount(){
        
        
        ArrayList<Question> questions = new ArrayList<Question>();
        
        
        
        Date nowtime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String nowtime2=df.format(nowtime);
        
        
        
        String query = "SELECT user_id , udate , SUM(qcount) AS qcount "               
                       + " FROM Questions"
                       + " WHERE user_id = "+getId()
                        + " GROUP BY user_id , udate";
        
        
        try {
            
            db.sqlquery = db.con.createStatement();
            db.rs = db.sqlquery.executeQuery(query);
            
            while(db.rs.next()){
                
                Question q = new Question();
                
                q.setDate(db.rs.getString("udate"));
               // q.setLessonId(db.rs.getInt("lessons_id"));
               // q.setNet(db.rs.getDouble("netc"));
                q.setUserId(db.rs.getInt("user_id"));
               // q.seteCount(db.rs.getInt("emptyc"));
               // q.setfCount(db.rs.getInt("falsec"));
                q.setqCount(db.rs.getInt("qcount"));
               // q.settCount(db.rs.getInt("truec"));
                
                
               questions.add(q);
                
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
            System.out.println("getDeeptoHighTotalQuestionsCount ' da hata var ya da sorgu null dondu");
            
            return  null;
        }
                
    
        return questions;
        
    } 
    
    
    // gunluk targetların dagilimini verecek metod
    
    public ArrayList<Goal> getTotalLessonsGoalNowCount(){
        
        
        ArrayList<Goal> goals = new ArrayList<Goal>();
        
        
        
        Date nowtime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String nowtime2=df.format(nowtime);
        
        
        
        String query = "SELECT user_id , lesson_id , gdate , SUM(qcount) AS qcount "
                       + " FROM Goals"
                       + " WHERE user_id = "+getId()+" AND gdate = '"+nowtime2+"'"
                        + " GROUP BY user_id , lesson_id , gdate";
        
        
        try {
            
            db.sqlquery = db.con.createStatement();
            db.rs = db.sqlquery.executeQuery(query);
            
            while(db.rs.next()){
                
                Goal q = new Goal();
                
                
                q.setLesson_id(db.rs.getInt("lessons_id"));
                
                q.setUserId(db.rs.getInt("user_id"));
                
                q.setqCount(db.rs.getInt("qcount"));
                
                q.setGdate(db.rs.getString("gdate"));
                
                
                
               goals.add(q);
                
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
            System.out.println("getTotalLessonsGoalNowCount ' da hata var ya da sorgu null dondu");
            
            return  null;
        }
                
    
        return goals;
        
    }
    
    
    
    
    public boolean addQuestionCount(String lessonName , int trueCount, int falseCount, int blankCount){
        
        String get_id_query = "SELECT id"
                            + " FROM Lessons l"
                            + " WHERE l.Lessons = '"+lessonName+"'";
        
        int lessonId = 0;
        
        int qCount = trueCount+falseCount+blankCount;
        
        double netCount = trueCount - (falseCount * 0.25)-falseCount; // restore
        
        Date nowtime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String nowtime2=df.format(nowtime);
        
        
        
        try {
            
             db.sqlquery = db.con.createStatement();
             db.rs = db.sqlquery.executeQuery(get_id_query);
             
             if(db.rs.next()){
                 
                 lessonId = db.rs.getInt("id");
             }
            
        } catch (Exception e) {
            
            System.out.println("addQuestionCount ' da id alinirken hata olustu");
            
            return false;
        }
        
        System.out.println("lesson name : "+lessonName);
        System.out.println("lesson id = "+lessonId);
        
        
        String main_query = "INSERT INTO Questions (user_id, lessons_id, qcount, truec, falsec, emptyc, netc, udate)"
                            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            
            db.psqlquery = db.con.prepareStatement(main_query);
            
            db.psqlquery.setInt(1, getId());
            db.psqlquery.setInt(2, lessonId);
            db.psqlquery.setInt(3, qCount);
            db.psqlquery.setInt(4, trueCount);
            db.psqlquery.setInt(5, falseCount);
            db.psqlquery.setInt(6, blankCount);
            db.psqlquery.setDouble(7, netCount);
            db.psqlquery.setString(8, nowtime2);
            
            db.psqlquery.executeUpdate();
            
            return true;
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
            System.out.println("addQuestionCount ' da veri eklerken hata");
        }
        
        
        return false ;
    }
    
    public int addTotalTYTtargetCount(){
        
        Date nowtime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String nowtime2=df.format(nowtime);
        
        // query sadece tyt leri alacak sekilde guncellendi
        
        String query = "SELECT SUM(g.qcount) as sum"
                       + " FROM Goals g"
                        + " WHERE g.user_id = "+getId()+" AND"
                        + " g.lesson_id < 10 AND gdate = '"+nowtime2+"'";
        int total = 0;
        try {
            
             db.sqlquery = db.con.createStatement();
             db.rs = db.sqlquery.executeQuery(query);
             
             if(db.rs.next()){
                 
                  total = db.rs.getInt("sum");
             }
             
             return total;
            
        } catch (Exception e) {
            
            System.out.println("addTotalTYTtargetCount ' da  hata olustu veya veri bulunmadi 0");
            
            return 0;
        }
   
    }
    
    // ayt icin eklendi
    
    public int addTotalAYTtargetCount(){
        
        Date nowtime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String nowtime2=df.format(nowtime);
        
        // query sadece tyt leri alacak sekilde guncellendi
        
        String query = "SELECT SUM(g.qcount) as sum"
                       + " FROM Goals g"
                        + " WHERE g.user_id = "+getId()+" AND"
                        + " g.lesson_id > 9 AND gdate = '"+nowtime2+"'";
        int total = 0;
        try {
            
             db.sqlquery = db.con.createStatement();
             db.rs = db.sqlquery.executeQuery(query);
             
             if(db.rs.next()){
                 
                  total = db.rs.getInt("sum");
             }
             
             return total;
            
        } catch (Exception e) {
            
            System.out.println("addTotalAYTtargetCount ' da  hata olustu veya veri bulunmadi 0");
            
            return 0;
        }
   
    }
    
    
    public boolean addTYTTargetCount(int turkce,int matematik,int tarih,int cografya,int felse,int din,int fizik,int kimya,int biyoloji){
        
        // ders id lerini elle otomatik ekliyorum hepsi icin sorgu dondurmeyecegim hem program yavaslar
        // hem de gerek yok dersler belli id ler belli static bir yapi zaten dinamik yapilar icin
        // sorgu dondurecegim
        
        Date nowtime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String nowtime2=df.format(nowtime);
        
        try {
            
             if(turkce!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
                   db.psqlquery = db.con.prepareStatement(query);
                   
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, turkce);
                   db.psqlquery.setInt(3, 1);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
             }
             
             if(matematik!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
                   db.psqlquery = db.con.prepareStatement(query);
                   
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, matematik);
                   db.psqlquery.setInt(3, 2);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
             }
             
             if(tarih!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
                   db.psqlquery = db.con.prepareStatement(query);
                   
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, tarih);
                   db.psqlquery.setInt(3, 3);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
             }
             
             if(cografya!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
                   db.psqlquery = db.con.prepareStatement(query);
                   
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, cografya);
                   db.psqlquery.setInt(3, 4);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
             }
             
             if(felse!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
                   db.psqlquery = db.con.prepareStatement(query);
                   
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, felse);
                   db.psqlquery.setInt(3, 5);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
             }
             
             if(din!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ? ,?, ?)";
            
                   db.psqlquery = db.con.prepareStatement(query);
                   
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, din);
                   db.psqlquery.setInt(3, 6);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
             }
             
             if(fizik!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ? ,?, ?)";
            
                   db.psqlquery = db.con.prepareStatement(query);
                   
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, fizik);
                   db.psqlquery.setInt(3, 7);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
             }
             
             if(kimya!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
                   db.psqlquery = db.con.prepareStatement(query);
                   
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, kimya);
                   db.psqlquery.setInt(3, 8);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
             }
             
             if(biyoloji!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ? ,?, ?)";
            
                   db.psqlquery = db.con.prepareStatement(query);
                   
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, biyoloji);
                   db.psqlquery.setInt(3, 9);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
             }
            
             
             return true;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("addTYTTargetCount ' da hata var");
            
            return false;
        }
        
        
        
    }
    
     public boolean addSayisalAYTTargetCount(int matematik,int fizik,int kimya,int biyoloji){
            
        Date nowtime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String nowtime2=df.format(nowtime);
        
        try{
        
         if(matematik!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, matematik);
                   db.psqlquery.setInt(3, 10);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
         if(fizik!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, fizik);
                   db.psqlquery.setInt(3, 11);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
         if(kimya!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, kimya);
                   db.psqlquery.setInt(3, 12);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
         if(biyoloji!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2, biyoloji);
                   db.psqlquery.setInt(3, 13);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
          
             } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
  
            return true;
            
        }

          
     
     public boolean addEsitAgirlikAYTTargetCount(int turkce,int matematik,int tarih,int cografya,int felsefe){
            
        Date nowtime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String nowtime2=df.format(nowtime);
        
        try{
        
         if(turkce!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2,turkce);
                   db.psqlquery.setInt(3, 14);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
         if(matematik!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2,matematik);
                   db.psqlquery.setInt(3, 10);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
         if(tarih!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2,tarih);
                   db.psqlquery.setInt(3, 17);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
         if(cografya!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2,cografya);
                   db.psqlquery.setInt(3, 15);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
         
             if(felsefe!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2,felsefe);
                   db.psqlquery.setInt(3, 16);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
          
             } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
  
            return true;
            
        }
        public boolean addSozelAYTTargetCount(int turkce,int cografya,int felsefe,int tarih){
            
        Date nowtime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String nowtime2=df.format(nowtime);
        
        try{
        
         if(turkce!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2,turkce);
                   db.psqlquery.setInt(3, 14);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
         if(tarih!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2,tarih);
                   db.psqlquery.setInt(3, 17);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
         if(cografya!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2,cografya);
                   db.psqlquery.setInt(3, 15);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
         
             if(felsefe!=0){
                  String query = "INSERT INTO Goals (user_id, qcount, lesson_id, gdate)"
                                + " VALUES (?, ?, ?, ?)";
            
            
                db.psqlquery = db.con.prepareStatement(query);
                         
                   db.psqlquery.setInt(1,getId());
                   db.psqlquery.setInt(2,felsefe);
                   db.psqlquery.setInt(3, 16);
                   db.psqlquery.setString(4, nowtime2);
            
           
                   db.psqlquery.executeUpdate();
            }
          
             } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
  
            return true;
            
        }
    
    
    public void addSayisal(){
        
        sayisal.add("AYT Matematik");
        sayisal.add("AYT Fizik");
        sayisal.add("AYT Kimya");
        sayisal.add("AYT Biyoloji");
        
    }
    
    public void addSozel(){
        
        sozel.add("AYT Türkçe");
        sozel.add("AYT Coğrafya");
        sozel.add("AYT Felsefe");
        sozel.add("AYT Tarih");
        
    }
    
    public void addTYT(){
        
        tyt.add("TYT Türkçe");
        tyt.add("TYT Matematik");
        tyt.add("TYT Tarih");
        tyt.add("TYT Coğrafya");
        tyt.add("TYT Felsefe");
        tyt.add("TYT Din Kültürü");
        tyt.add("TYT Fizik");
        tyt.add("TYT Kimya");
        tyt.add("TYT Biyoloji");
         
    }
    
    public void addEsitAgirlik(){
        
        esitAgirlik.add("AYT Türkçe");
        esitAgirlik.add("AYT Matematik");
        esitAgirlik.add("AYT Tarih");
        esitAgirlik.add("AYT Coğrafya");
        esitAgirlik.add("AYT Felsefe");
       
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    
    
   
    
}
