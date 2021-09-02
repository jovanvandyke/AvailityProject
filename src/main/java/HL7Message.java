import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class HL7Message {

    private static final AtomicInteger count = new AtomicInteger(0);
    private Patient patient;

    public HL7Message(Patient patient) {

        this.setPatient(patient);

    }

    public String buildHL7() {

        String hl7 = "";

        hl7 += this.buildMSH() + "\n";

        hl7 += this.getPatient().buildPID() + "\n";

        var i = 1;

        for (NextOfKin nextOfKin : this.getPatient().getNextOfKins()) {

            hl7 += "NK1|" + i + "|" + nextOfKin.buildNK1() + "\n";

            i++;

        }

        return hl7;
    }

    private String buildMSH() {

        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

        String msh = "MSH|^~\\&|Jovan|Van Dyke|Availity|Availity||";
        msh = msh + format.format(now);
        msh = msh + "|ADT^A08|";
        msh = msh + count.incrementAndGet() + "|P|2.4";

        return msh;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
