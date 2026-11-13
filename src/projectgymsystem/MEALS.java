
package projectgymsystem;


public  final class  MEALS {
    private String mealName;
    private double price;

    public MEALS(String mealName, double price) {
        setMealName(mealName);
        setPrice(price);
    }

    public MEALS(){
        this("",0.0);
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        
    }
  

    @Override
    public String toString() {
        return String.format("Meal Name: %s\nPrice: %f\n", getMealName(),getPrice());
              
    }
    
    
}
