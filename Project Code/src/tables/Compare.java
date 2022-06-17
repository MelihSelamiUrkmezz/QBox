
package tables;


public class Compare {
    
   private int user_id, sequence , qcount ;
   private double  netc ;
   private String name, surName , school;

    public Compare(int sequence, int qcount, double netc, String name, String surName, String school, int user_id) {
        this.sequence = sequence;
        this.qcount = qcount;
        this.netc = netc;
        this.name = name;
        this.surName = surName;
     
        this.school = school;
        this.user_id = user_id;
    }
    
    public Compare(){
        
//        sequence = 0;
//        qcount = 0;
//        netc = 0.0;
//        name="";
//        surName = "";
//        eclass = "";
//        school = "";
  //        user_id = 0;
        
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getQcount() {
        return qcount;
    }

    public void setQcount(int qcount) {
        this.qcount = qcount;
    }

    public double getNetc() {
        return netc;
    }

    public void setNetc(double netc) {
        this.netc = netc;
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


    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
   
   
   
    
}
