
package projectgymsystem;


public class ExtraService implements Payable {
    
    private MEALS meals;
    private double weight;
    private int hight;
    private int age;
    

    public ExtraService(MEALS meals,double weight,int hight,int Age){
        setMeals(meals);
        setWeight(weight);
        setHight(hight);
        setAge(Age);
    
    }

    public ExtraService(double weight, int hight,int Age) {
       setWeight(weight);
       setHight(hight);
       setAge(Age);
    }
    

    public ExtraService() {
        this(null,0.0,0,0);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    public MEALS  getMeals() {
        return meals;
    }

    public void setMeals(MEALS  meals) {
        this.meals = meals;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }
    
    
    
    public double calcCalories()  {
        //معدل الايض 655.1 + (9.563 x الوزن بالكيلوغرام) + (1.850 x الطول بالسنتمتر) - (4.676 x العمر بالسنوات).
       double calories= 655.1+(9.563 * getWeight() )+(1.850 * getHight() ) - (4.676 * getAge());
        
       
         return calories;
        
    }
    
    @Override
    public double pay() {
         
   double serviceCost = 5+((5*1)+VAT);
    
      return serviceCost;
    }

   
    
     
}
