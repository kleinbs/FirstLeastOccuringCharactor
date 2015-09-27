import java.util.*;
import java.io.*;

public class Main2 {

    public static void main(String[] args) {

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
        
        String test = args[0];

        //time operation after we have the char array
        final long startTime = System.currentTimeMillis();
        Map<String, Integer> charMap = new LinkedHashMap<>();

        for(int i = 0; i < test.length(); i++){
            Integer currVal = charMap.put(test.charAt(i) + "", 1);

            if(currVal != null)
                charMap.put(test.charAt(i) + "", ++currVal);
        }

        String value = null;
        int lowestCount = 0;

        Set<String> keys = charMap.keySet();

        for(String key : keys){
            if(value == null){
                value = key;
                lowestCount = charMap.get(key).intValue();
            } else if(charMap.get(key).intValue() < lowestCount){
                value = key;
                lowestCount = charMap.get(key).intValue();
            }
        }

        //opperation is over, find the end time
        final long endTime = System.currentTimeMillis();

        System.out.println("Found: " + value.charAt(0) + " Occurrences=" + lowestCount );
        System.out.println("Total execution time: " + (endTime - startTime) );
    }
}
