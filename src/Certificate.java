
package projectgymsystem;


public  class Certificate {
   private String name;
      private int year;

    public Certificate(String name, int year) {
        setName(name);
         setYear(year);
    }

    public Certificate() {
        this("",0);
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
          
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nYear: %d", getName(),getYear());
                
    }
 
    
}
