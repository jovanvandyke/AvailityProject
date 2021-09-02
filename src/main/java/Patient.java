import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Patient {
    private static final AtomicInteger count = new AtomicInteger(1000000);
    private int patientID;
    private String gender;
    private String race;
    private String homePhone;
    private String workPhone1;
    private String workPhone2;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String Address;
    private String City;
    private String State;
    private String Zip;
    private List<NextOfKin> nextOfKins;

    public Patient() {
        patientID = count.incrementAndGet();
    }

    public String buildPID(){

        String pid = "PID|||" +
                    this.getPatientID() + "||" +
                    this.getLastName() + "^" + this.getFirstName() + "||" +
                    this.getDateOfBirth() + "|" +
                    this.getGender() + "||" +
                    this.getRace() + "|" +
                    this.getAddress() + "^^" + this.getCity() + "^" + this.getState() + "^" + this.getZip() + "||" +
                    this.getHomePhone() + "|" +
                    this.getWorkPhone1() + "~" + this.getWorkPhone2();

        return pid;

    }

    public List<NextOfKin> getNextOfKins() {
        return nextOfKins;
    }

    public void setNextOfKins(List<NextOfKin> nextOfKins) {
        this.nextOfKins = nextOfKins;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone1() {
        return workPhone1;
    }

    public void setWorkPhone1(String workPhone1) {
        this.workPhone1 = workPhone1;
    }

    public String getWorkPhone2() {
        return workPhone2;
    }

    public void setWorkPhone2(String workPhone2) {
        this.workPhone2 = workPhone2;
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

    public String getDateOfBirth() {
        return new SimpleDateFormat("yyyyMMdd").format(dateOfBirth);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }
}
