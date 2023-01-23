import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Write lines to csv file
public class CsvWriter {
    public CsvWriter(ArrayList<String> input, String filename) {
        this.input = input;
        this.filename = filename;
    }

    ArrayList<String> input;
    String filename;
    public void writeToCsv() {


            this.input.forEach(entry->{
                try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(this.filename, true));
                writer.append("\n");
                writer.append(entry);
                System.out.println(entry);
                    writer.flush();
                    writer.close();}
                catch (IOException e) {
                throw new RuntimeException(e);
            }


            });



    }
}
