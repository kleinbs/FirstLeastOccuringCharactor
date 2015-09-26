public class Main {

    public static void main(String[] args) {

        if(args.length == 0){
            System.out.println("No string give, exiting now.....");
            System.exit(1);
        }
        System.out.println("Testing String for first non repeating char: " + args[0]);
        //just in case nothing is passed in
        char[] chars = args[0].toCharArray();

        //time operation after we have the char array
        final long startTime = System.currentTimeMillis();

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
