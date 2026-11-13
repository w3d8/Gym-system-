package projectgymsystem;

public class VIP extends Subscription {

    private Trainer tranier;

    public VIP(Trainer tranier, String name, String id, double pricePerMonth, int TimeInMonth) {
        super(name, id, pricePerMonth, TimeInMonth);
        setTranier(tranier);
    }

    public VIP() {
        this(null, "", "", 0.0, 0);

    }

    public Trainer getTranier() {
        return tranier;
    }

    public void setTranier(Trainer tranier) {
        this.tranier = tranier;
    }

    @Override
    public double calcPrice() {

        double totalPrice = getPricePerMonth();

        return totalPrice * getTimeInMonth();

    }

    @Override
    public String trainerType() {
        return "Personal Trainer.";
    }

    public String VIPfreeParking() {
        return "VIP Subscription has free parking !";
    }

    @Override
    public String toString() {
        return String.format("%s\nTrainer: %s",
                super.toString(), getTranier() );
    }

}
