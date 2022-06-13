
package tables;

import java.util.ArrayList;


public class User {
    
    private int id, depId, queue;
    private String name, surName, mail, class_,school, password;
    
    private ArrayList<String> tyt = new ArrayList<String>();
    private ArrayList<String> sayisal = new ArrayList<String>();
    private ArrayList<String> sozel = new ArrayList<String>();
    private ArrayList<String> esitAgirlik = new ArrayList<String>();
    
    
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
