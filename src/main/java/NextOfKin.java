import java.util.concurrent.atomic.AtomicInteger;

public class NextOfKin {

    private static final AtomicInteger count = new AtomicInteger(1000000);
    private int nokID;
    private String firstName;
    private String lastName;
    private String relationship;

    public NextOfKin() {
        nokID = count.incrementAndGet();
    }

    public String buildNK1() {
        String nk1 = "";

        nk1 += this.getLastName() + "^" + this.getFirstName() + "|" +
                this.getRelationship();

        return nk1;
    }

    public int getNokID() {
        return nokID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
