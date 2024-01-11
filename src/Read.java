import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Read  implements Closeable{
    private String path = "/Users/aaryamansharma/Downloads/onboarding-h.09-01-2024.0.log";
    private Scanner sc;
    private FileReader fr;
    private BufferedReader br;

    public Read()
    {
        try {
            sc = new Scanner(System.in);
            fr = new FileReader(path);
            br = new BufferedReader(fr);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("unable to find the file");// problem in the path ?
        }
    }
    public void readData() {
        System.out.println("Enter your message to be searched");
        String userMessage = sc.nextLine();

        FindMessage obj = new FindMessage();
        try
        {
            obj.find(userMessage , br);// where ever the vuln code is present we have to put try catch
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void close() throws IOException {
        fr.close();
        br.close();
    }
}
