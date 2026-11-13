
package projectgymsystem;


public class General extends Subscription{
   
    private final int MAX_ACCESS;

    public General(int MAX_ACCESS, String name, String id, double pricePerMonth, int TimeInMonth) {
        super(name, id, pricePerMonth, TimeInMonth);
        this.MAX_ACCESS = MAX_ACCESS;
    }

   
    public General() {
       this(0,"","",0.0,0) ;
    }

    public int getMAX_ACCESS() {
        return MAX_ACCESS;
    }
    

    @Override
    public double calcPrice() {
        
        double totalPrice = getPricePerMonth();
        return totalPrice*getTimeInMonth();
        
    }
    @Override
    public String trainerType() {
        return "General Group Trainer";
    }
    public String inviteFriend(){
    
        return "You can invite a friend to gym once a month !";
    }
    
    @Override
    public String toString() {
        return String.format("%s\nMAX GYM ACCESS per month : %d times",
                super.toString(),getMAX_ACCESS());
    }

   
    
   
}
