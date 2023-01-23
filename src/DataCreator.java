import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataCreator {
    private Scanner scfirstname = new Scanner(new File("firstnames"));
    private Scanner sclastnames = new Scanner(new File("lastnames"));

    private ArrayList<String> firstnames = serialize(scfirstname);
    private ArrayList<String> lastnames = serialize(sclastnames);
    private String[] departement = {"Cardiology", "Radiology", "Pediatrics", "Geriatrics","Pulmonology"};
    private boolean[] appointments = {true,false};

    private static ArrayList<String> serialize(Scanner sc){
        ArrayList<String>out = new ArrayList<>();
        while(sc.hasNextLine()){
            out.add(sc.nextLine());
        }
        return out;
    }

    public DataCreator() throws FileNotFoundException {
    }

    private String generateEntry(){
        RandomSelector rand = new RandomSelector();
        String first = (String) rand.randomElement(firstnames);
        String last = (String) rand.randomElement(lastnames);
        ArrayList departements = new ArrayList<String>();
        Collections.addAll(departements,departement);
        ArrayList appointment = new ArrayList();
        Collections.addAll(appointment,appointments);
        int aptmt = rand.randomNumber(100);
        String dept;
        String type;
        if (aptmt%2 == 0 ) {
            dept = (String) rand.randomElement(departements);
            type = "Appointement";
        }
        else {
            dept = "None";
            type = "visit";

        }
        int day = rand.randomNumber(31);
        String date = day + "/11/2023";
        return (first+","+last+","+dept+","+type+","+date);




    }

    public ArrayList<String> makeDataset(int entrys) {
        int count = 0;
        ArrayList<String> dataset = new ArrayList<>();
        while(count < entrys){
            dataset.add(generateEntry());
            count++;

        }
        return dataset;
    }
}
