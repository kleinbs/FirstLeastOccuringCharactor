import java.io.*;
import java.lang.Character;
import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main3 {

    public static void main(String[] args) {

        if (args.length == 0) {
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

        //System.out.println(test);
        Map<String, Long> groupedList = Arrays.asList(args[0].split("")).stream()
                .collect(groupingBy(count -> )
                .collect(groupingBy(character -> character.toString(), LinkedHashMap::new, counting()));

        System.out.println(groupedList);

        Iterator it = groupedList.entrySet().iterator();

        if(it.hasNext()){
            Map.Entry<String, Long> result = (Map.Entry<String, Long>)it.next();


            System.out.println("Found: " + result.getKey() + " Occurrences=" + result.getValue() );

        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );

    }
}