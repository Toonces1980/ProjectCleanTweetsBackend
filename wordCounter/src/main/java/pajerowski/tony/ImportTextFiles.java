package pajerowski.tony;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by anthonypajerowski on 2/17/17.
 */



public class ImportTextFiles {

    public String importTextFileToString(String input) throws FileNotFoundException {
        String everything = "";

        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } catch (
                IOException e)

        {
            e.printStackTrace();
        }
        System.out.println(everything.length());
        return everything;
    }
}

