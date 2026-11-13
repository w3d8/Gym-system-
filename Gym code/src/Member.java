
package projectgymsystem;


public class Member extends Person{
    
    private String phoneNumber;
      
    public Member( int id, String name,String phoneNumber) {
        super(id, name);
        setPhoneNumber(phoneNumber);
    }

    public Member() {
        this(0," ","");
        
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
     @Override
    public String toString() {
        return String.format("%s\nPhone Number:%s ",super.toString(),getPhoneNumber());
    } 
          
}
