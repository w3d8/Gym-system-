package projectgymsystem;

public class Trainer extends Person {

    private int experience;
    private String mainSpecialization;
    private Certificate[] certificate;

    public Trainer(int experience, int id, String name, String mainSpecialization, Certificate[] certificate) {
        super(id, name);
        setExperience(experience);
        setMainSpecialization(mainSpecialization);
        setCertificate(certificate);
    }

    public Trainer(int experience, String mainSpecialization) {
        this.experience = experience;
        this.mainSpecialization = mainSpecialization;
    }

    public Trainer(String mainSpecialization, Certificate[] certificate) {
        this.mainSpecialization = mainSpecialization;
        this.certificate = certificate;
    }

    public Trainer() {
        this(0, 0, " ", "", null);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getMainSpecialization() {
        return mainSpecialization;
    }

    public void setMainSpecialization(String mainSpecialization) {
        this.mainSpecialization = mainSpecialization;
    }

    public Certificate[] getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate[] certificate) {
        this.certificate = certificate;
    }

    public final String getcertificate() {

        String C = "";
        if (certificate == null) {
            C = "No certificates";
        } else {
            for (int i = 0; i < certificate.length; i++) {
                C += certificate[i] + "\n";

            }

        }
        return C;
    }

    @Override
    public String toString() {
        return String.format("%s\nExperience :%d\nCertificate:\n%s",
                super.toString(), getExperience(), getcertificate());
    }

}
