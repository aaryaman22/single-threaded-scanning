import java.io.*;

public class Write implements Closeable{
    private String path = "/Users/aaryamansharma/Downloads/output.txt";
    private FileWriter writer;
    private BufferedWriter buffer;

    public Write() throws IOException {
       writer = new FileWriter(path);
       buffer = new BufferedWriter(writer);
    }

    public void writeData(int lineCount , String s)
    {
        try
        {
            buffer.write("message "+ s + " Found at line " + lineCount);
        }catch (Exception e)
        {
            e.getMessage();
            System.out.println(e.getMessage());
        }
    }
//    public void closeStream() throws Exception
//    {
//        try
//        {
//              buffer.close();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Stream was not opened");
//        }
//    }

    @Override
    public void close() throws IOException {
        buffer.close();
        writer.close();
    }
}
