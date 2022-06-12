
package tables;


public class User {
    
    private int id, depId, queue;
    private String name, surName, mail, class_,school, password;
    
    public User(){
        
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
    }
    
      // methods...

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
