
package tables;


public class Question {
    
    private int id, qCount, tCount, fCount, eCount, userId, lessonId;
    private double net;
    private String date;
    
    public Question(){
        
    }

    public Question(int id, int qCount, int tCount, int fCount, int eCount, int userId, int lessonId, double net, String date) {
        this.id = id;
        this.qCount = qCount;
        this.tCount = tCount;
        this.fCount = fCount;
        this.eCount = eCount;
        this.userId = userId;
        this.lessonId = lessonId;
        this.net = net;
        this.date = date;
    }
    
     // methods...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getqCount() {
        return qCount;
    }

    public void setqCount(int qCount) {
        this.qCount = qCount;
    }

    public int gettCount() {
        return tCount;
    }

    public void settCount(int tCount) {
        this.tCount = tCount;
    }

    public int getfCount() {
        return fCount;
    }

    public void setfCount(int fCount) {
        this.fCount = fCount;
    }

    public int geteCount() {
        return eCount;
    }

    public void seteCount(int eCount) {
        this.eCount = eCount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
