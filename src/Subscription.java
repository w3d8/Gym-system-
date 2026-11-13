
package projectgymsystem;


public abstract class Subscription {
 
    private String name;
    private String id;
    private double pricePerMonth;
    private int TimeInMonth;
    private static int totalSubscriptions;

    public Subscription(String name,  String id, double pricePerMonth, int TimeInMonth) {
        setName(name);
        setId(id);
        setPricePerMonth(pricePerMonth);
        setTimeInMonth(TimeInMonth);
        totalSubscriptions++;
    }

    public Subscription() {
        this("","",0.0,0);
    }
    
    public abstract double calcPrice();
    
    
    public final void extendSubscription(int TimeInMonth ){
        this.TimeInMonth+=TimeInMonth;

    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public double getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public int getTimeInMonth() {
        return TimeInMonth;
    }

    public void setTimeInMonth(int TimeInMonth) {
        this.TimeInMonth = TimeInMonth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getTotalSubscriptions() {
        return totalSubscriptions;
    }

    public static void setTotalSubscriptions(int totalSubscriptions) {
        Subscription.totalSubscriptions = totalSubscriptions;
    }

    
    public abstract String trainerType();
    
    @Override
    public String toString() {
        return String.format("Name: %s\nId of Subscription : %s\nPrice Per Month: %.2f SAR\nNumber of Months : %d", 
                getName(),getId(),getPricePerMonth(),getTimeInMonth());
    }

    
}
