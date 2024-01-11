import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindMessage {
    public void find(String UserMessage , BufferedReader br) throws IOException {
        long startTime=0 , endTime=0;
        Pattern pattern = Pattern.compile("\"message\":\"(.*?"+UserMessage+".*?)\"");
        int lineCount = 1 , matchCount =0;
        startTime= System.currentTimeMillis();
        String line;
        try (Write write = new Write())// automat.. invokes close method
        {
            while((line = br.readLine())!=null) //all io operations
            {
                lineCount++;
                Matcher matcher = pattern.matcher(line);
                //int start = 0, end = 0;
                if(matcher.find())
                {
//                start = matcher.start();
//                end = matcher.end();
//                System.out.println("msg foundddd");
//                Write writeInFile = new Write();
//                writeInFile.write(cnt , matcher.group(0));
                    write.writeData(lineCount , UserMessage);
                    matchCount++;
                }
            }
        }

//        try {
//            write.closeStream();
//        } catch (Exception e) {
//            System.out.println("wasnt opened");
//        }
        endTime= System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(matchCount);
    }
}
