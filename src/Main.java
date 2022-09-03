import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;


public class Main {
    public static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("FAIL!");
        }
        return content.toString();
    }
    public static char[] symbolList(String someFact) {
        String fact = someFact.toUpperCase();
        int len = fact.length();
        char[] chars = new char[len];
        for (int i = 0; i < fact.length(); i++) {
            chars[i] = fact.charAt(i);
            // System.out.println(chars[i]);
        }
        return chars;
    }
    public static void countingChars(char[] myChars) {

        char myChar = myChars[0];
        int count = 0;
        int symbolsCounter = 0;
        int sumOfFrequencies = 0;

        for (int i = 0; i < myChars.length; i++) {

            if (myChar == myChars[i]) {
                count++;

            }

            else {
                System.out.println("[Frequency of symbol  '" + myChar + "' is: " + count + "]");
                symbolsCounter += 1;
                sumOfFrequencies += count;

                myChar = myChars[i];
                count = 0;
                count++;
            }
        }


        System.out.println("");
        double meanFrequency = (double)sumOfFrequencies / (double)symbolsCounter;
        System.out.println("MEAN FREQUENCY IS: " + meanFrequency);
        System.out.println("");
        System.out.println("NUMBER OF UNIQUE SYMBOLS: " + symbolsCounter);
        System.out.println("");
    }

    public static void main(String[] args) {
        String urlAdress1 = "http://numbersapi.com/random/trivia";
        String interestingFact = getUrlContent(urlAdress1);
        System.out.println("");
        System.out.println("INTERESTING FACT: " + interestingFact);

        char[] chars = symbolList(interestingFact);

        Arrays.sort(chars);

        System.out.println("NUMBER OF SYMBOLS: " + (chars.length - 1));
        System.out.println("");

        countingChars(chars);
    }
}



