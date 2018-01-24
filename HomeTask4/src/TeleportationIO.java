import java.io.*;

public class TeleportationIO {
    String input;
    String output;
    int lines;

    public TeleportationIO(String input, String output, int lines) {
        this.input = input;
        this.output = output;
        this.lines = lines;
    }

    public void doJob() {
        FileInputStream inStream = null;
        FileOutputStream outStream = null;
        try {
            inStream = new FileInputStream(input);
            BufferedReader br = new BufferedReader(new InputStreamReader(inStream));

            outStream = new FileOutputStream(output);

            String strLine;
            int i = 0;

            while (i < lines) {
                if ((strLine = br.readLine()) != null) {
                    System.out.println(strLine);
                    byte[] strToBytes = (strLine + "\n").getBytes();
                    outStream.write(strToBytes);
                    i++;
                } else {
                    System.out.println("Number of lines you want to be transferred is more than file has.");
                    break;
                }
            }

            outStream.close();
            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
