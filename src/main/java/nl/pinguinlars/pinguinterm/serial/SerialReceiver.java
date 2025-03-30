package nl.pinguinlars.pinguinterm.serial;

public class SerialReceiver extends Thread {
    private static String[] Input = new String[5];
    private static int StringIndex = 0;

    /* public static char[] SerialInput = new char[1024 * 4];

     public static void Input(String input) {
         char[] Input = input.toCharArray();
         int emptyCharIndex = 0;
         for (int i = 0; i < SerialInput.length; i++) {
             if (SerialInput[i] == ' ') {
                 emptyCharIndex = i;
                 break;
             }
         }
         for (int i = 0; i < Input.length; i++) {
             SerialInput[emptyCharIndex + i] = Input[i];
             if (SerialInput[emptyCharIndex + i] == ';') {
                 String RefinedData = Arrays.toString(SerialInput).substring(0, emptyCharIndex + i);
                 System.out.println(RefinedData);
             }
         }
     }*/
    @SuppressWarnings("CommentedOutCode")//It is above this lol
    public static void CleanInput(String input) { //Starts a thread to avoid missed data
        SerialReceiver thread = new SerialReceiver();
        Input[StringIndex] = input;
        StringIndex++;
        if (StringIndex == 5) StringIndex = 0;
        if (!thread.isAlive()) thread.start();
    }

    public void run() {
        int indexIterator = 0;
        int arrayIterator = 0;
        do {
            indexIterator++;
            if (indexIterator > Input[arrayIterator].length()) {
                arrayIterator++;
            }
        } while (Input[arrayIterator].charAt(indexIterator) == ';');
    }
}