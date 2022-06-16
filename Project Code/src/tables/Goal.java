
package tables;


public class Goal {
    
    private int id, qCount, userId, lesson_id;
    
    private  String gdate;

    
    
    public Goal(){
        
    }
    
    public Goal(int id, int qCount, int userId, int lesson_id, String gdate) {
        this.id = id;
        this.qCount = qCount;
        this.userId = userId;
        this.lesson_id = lesson_id;
        this.gdate = gdate;
    }
    
    // methods...

    public String getGdate() {
        return gdate;
    }

    public void setGdate(String gdate) {
        this.gdate = gdate;
    }
    
    
    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

  
    
    
}
