
package projectgymsystem;


public abstract class Person {
    
    private int id;
    private String name;

    public Person( int id, String name) {
        setId(id);
        setName(name);
    }

    public Person() {
        this(0,"");
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nName:%s",getId(),getName());
    }
    
  
}
