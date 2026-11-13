package projectgymsystem;

public class Registration implements Payable {

    private int id;
    private Subscription subscription;
    private Member member;
    private static int num0fRegistration;
    private String status;

    public Registration(int id, Subscription subscription, Member member, String status) {
        setId(id);
        setSubscription(subscription);
        setMember(member);
        setStatus(status);
        num0fRegistration++;
    }

    public Registration() {
        this(0, null, null, "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Member getMemeber() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public static int getNum0fRegistration() {
        return num0fRegistration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public double pay() {
        double amount = subscription.calcPrice();
        //System.out.println(amount + "SAR.");
        return amount;
    }

    public final void confirmReg() {
        setStatus("CONFIRMED");
        System.out.println("the registration is done");
    }

    public final void canceReg() {
        setStatus("CANCELED");
        System.out.println("cancel registration ");

    }

    @Override
    public String toString() {
        return String.format("Id: %d\nSubscription: %s\nMember: %s\nStatus: %s ",
                getId(),getSubscription(),getMemeber(),getStatus());
                
    }

}
