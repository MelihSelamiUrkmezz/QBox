
package tables;

import dbConnection.DBConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


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
    
    public boolean addQuestionCount(String lessonName , int trueCount, int falseCount, int blankCount){
        
        String get_id_query = "SELECT id"
                            + " FROM Lessons"
                            + " WHERE Lessons = '"+lessonName+"'";
        
        int lessonId = 0;
        
        int qCount = trueCount+falseCount+blankCount;
        
        double netCount = trueCount - (falseCount * 0.25);
        
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
        
        String query = "SELECT SUM(qcount) as sum"
                       + " FROM Goals"
                        + " WHERE user_id = "+getId()+" AND"
                        + " gdate = '"+nowtime2+"'";
        int total = 0;
        try {
            
             db.sqlquery = db.con.createStatement();
             db.rs = db.sqlquery.executeQuery(query);
             
             if(db.rs.next()){
                 
                  total = db.rs.getInt("sum");
             }
             
             return total;
            
        } catch (Exception e) {
            
            System.out.println("addQuestionCount ' da id alinirken hata olustu");
            
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
    
    public void addSayisal(){
        
        sayisal.add("AYT Matematik");
        sayisal.add("AYT Fizik");
        sayisal.add("AYT Kimya");
        sayisal.add("AYT Biyoloji");
        
    }
    
    public void addSozel(){
        
        sozel.add("AYT Turkce");
        sozel.add("AYT Cografya");
        sozel.add("AYT Felsefe");
        sozel.add("AYT Tarih");
        
    }
    
    public void addTYT(){
        
        tyt.add("TYT Turkce");
        tyt.add("TYT Matematik");
        tyt.add("TYT Tarih");
        tyt.add("TYT Cografya");
        tyt.add("TYT Felsefe");
        tyt.add("TYT Din Kulturu");
        tyt.add("TYT Fizik");
        tyt.add("TYT Kimya");
        tyt.add("TYT Biyoloji");
         
    }
    
    public void addEsitAgirlik(){
        
        esitAgirlik.add("AYT Turkce");
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
