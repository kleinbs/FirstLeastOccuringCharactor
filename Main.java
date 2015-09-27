import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //just in case nothing is passed in
        if(args.length == 0){
            System.out.println("No string give, exiting now.....");
            System.exit(1);
        }

        try {
            System.out.println("Testing String for first non repeating char in the following file: " + args[0]);
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            StringBuilder sb = new StringBuilder();

            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            args[0] = sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read the file given " + e);
            System.exit(1);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading the file " + e);
            System.exit(1);
        }

        //time operation after we have the char array
        final long startTime = System.currentTimeMillis();

        char[] chars = args[0].toCharArray();
        int occurrence = -1;
        char value = ' ';
        for(int i = 0; i < chars.length; i++){
            int current = 0;
            for(int j = 0; j < chars.length; j++){
                if(chars[i] == chars[j]){
                    current++;
                }
            }
            if(current < occurrence || occurrence < 0){
                value = chars[i];
                occurrence = current;
            }
        }

        //opperation is over, find the end time
        final long endTime = System.currentTimeMillis();

        //System.out.println("value: " + value + " number: " + occurrence);
        System.out.println("value: " + value + " Occurrences=" + occurrence );
        System.out.println("Total execution time: " + (endTime - startTime) );
    }
}
