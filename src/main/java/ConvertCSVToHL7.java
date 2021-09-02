import java.io.*;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ConvertCSVToHL7 {

    public static List<Patient> patients;

    public static void main(String[] args) {

        processCSV();

        for (Patient patient : patients) {
            generateHL7(patient);

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void processCSV () {

        BufferedReader reader = null;
        List<Patient> patientList = new ArrayList<>();

        try {

            reader = new BufferedReader(new FileReader("C:\\Users\\Jovan\\Desktop\\CSV\\Patients.csv"));
            String line = reader.readLine();

            while (line != null) {

                String[] info = line.split(",");

                Patient patient = new Patient();

                patient.setFirstName(info[0]);
                patient.setLastName(info[1]);
                patient.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(info[2]));
                patient.setAddress(info[3]);
                patient.setCity(info[4]);
                patient.setState(info[5]);
                patient.setZip(info[6]);
                patient.setGender(info[7]);
                patient.setRace(info[8]);
                patient.setHomePhone(info[9]);
                patient.setWorkPhone1(info[10]);
                patient.setWorkPhone2(info[11]);

                List<NextOfKin> nextOfKins = new ArrayList<>();

                if (info[12] != "") {
                    NextOfKin nok1 = new NextOfKin();
                    nok1.setFirstName(info[12]);
                    nok1.setLastName(info[13]);
                    nok1.setRelationship(info[14]);
                    nextOfKins.add(nok1);
                }

                if (info[15] != "") {
                    NextOfKin nok2 = new NextOfKin();
                    nok2.setFirstName(info[15]);
                    nok2.setLastName(info[16]);
                    nok2.setRelationship(info[17]);
                    nextOfKins.add(nok2);
                }

                patient.setNextOfKins((nextOfKins));

                patientList.add(patient);

                line = reader.readLine();
            }

        } catch (Exception e) {

            System.out.println(e);

        } finally {
            try {
                reader.close();
                patients = patientList;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void generateHL7 (Patient patient) {

        BufferedWriter output = null;

        try {

            File file = new File("C:\\Users\\Jovan\\Desktop\\HL7\\" +
                    patient.getPatientID() + "_" +
                    new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +
                    ".hl7");
            FileWriter writer = new FileWriter(file);
            output = new BufferedWriter(writer);

            HL7Message hl7 = new HL7Message(patient);

            output.write(hl7.buildHL7());

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                output.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }

}
