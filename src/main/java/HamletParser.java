import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    static String hamletData;
    static String originalText = "hamlet.txt";
    static String regexText = "hamletChanged.txt";

    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {


        return hamletData;
    }

    public String regexHamlet() {
        String replacedTexts = hamletData;

        //Replacing Hamlet with Leon
        Pattern patternHamlet = Pattern.compile("\\bHamlet\\b");
        Matcher matcherHamlet = patternHamlet.matcher(replacedTexts);
        replacedTexts = matcherHamlet.replaceAll("Leon");

        //Replacing Horatio with Tariq
        Pattern patternHoratio = Pattern.compile("\\bHoratio\\b");
        Matcher matcherHoratio = patternHoratio.matcher(replacedTexts);
        replacedTexts = matcherHoratio.replaceAll("Tariq");

        return replacedTexts;
    }

    public void saveToAFile(String output) {
        try (FileWriter fileWriter = new FileWriter(output)) {
            fileWriter.write(regexHamlet());
        } catch (IOException e) {
            e.printStackTrace();
            ;
        }
    }

    public static void main(String[] args) {
       HamletParser hamletParser = new HamletParser();
       hamletParser.saveToAFile("hamletRegex.txt");
    }
}



//    public static String readFile(String fileName)throws IOException {
//        return new String(Files.readAllBytes(Paths.get(fileName)));
//
//    }
//
//    public static void writeFile(String fileName, String content) throws IOException {
//        Files.write(Paths.get(fileName), content.getBytes());
//    }



