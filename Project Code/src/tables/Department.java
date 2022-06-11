
package tables;


public class Department {
    
    private int id;
    private String dName;
    
    public Department(){
        
    }

    public Department(int id, String dName) {
        this.id = id;
        this.dName = dName;
    }
    
     // methods...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
    
    
    
}
