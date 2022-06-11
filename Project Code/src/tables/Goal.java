
package tables;


public class Goal {
    
    private int id, qCount, userId;
    
    public Goal(){
        
    }
    
    public Goal(int id, int qCount, int userId) {
        this.id = id;
        this.qCount = qCount;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

  
    
    
}
