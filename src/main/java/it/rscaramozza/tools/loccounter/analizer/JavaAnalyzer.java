package it.rscaramozza.tools.loccounter.analizer;

import it.rscaramozza.tools.loccounter.files.FileUtility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class JavaAnalyzer {

    public static void countLines(String startDirectory, String[] extensions){
        AtomicInteger totalLinesOfCode = new AtomicInteger();
        FileUtility.searchFilesToAnalize(startDirectory, extensions).forEach(linesOfCodeConsumer(totalLinesOfCode));
        System.out.println("Total LoC : " + totalLinesOfCode.toString());
    }

    //TODO refactor java counter method
    private static Consumer<File> linesOfCodeConsumer(AtomicInteger totalLinesOfCode) {
        Consumer<File> linesOfCodeConsumer = (File inFile) -> {
            BufferedReader br = null;
            String sCurrentLine = null;
            String func = null;

            int a = 0, b = 0, c = 0, k = 0;

            try {
                // passing the text file location for FileReader.
                br = new BufferedReader(new FileReader(inFile));

                // Looping through the text file
                while ((sCurrentLine = br.readLine()) != null) {
                    // avoid multi-line comments and one line comments and new lines.
                    if (sCurrentLine.trim().startsWith("/*")
                            || sCurrentLine.trim().startsWith("*")
                            || sCurrentLine.trim().endsWith("*/")
                            || sCurrentLine.trim().startsWith("//")
                            || sCurrentLine.trim().isEmpty()
                            || (sCurrentLine.trim().matches("[{};]+"))) {
                        // count the number of comment lines and new lines to exclude it from count.
                        b++;
                        // Getting any function in the text file that start and end with ().
                    } else if (sCurrentLine.contains("\\(\\)\\{")) {
                        func = sCurrentLine.trim();
                        // printing the functions/methods
                        System.out.println(func);
                        // counting the number of functions/ methods found
                        k++;
                    } else {
                        // printing the text file just for checking
                        //System.out.println(sCurrentLine);
                        // count the total number of lines
                        a++;
                    }
                }

                totalLinesOfCode.addAndGet(a);


                // excluding the number of lines that has comments and new lines
                c = a - b;
                // printing the number of lines excluding comments and new lines
                System.out.println("File: " + inFile.toString());
                System.out.println("Number of Lines of Code are : " + a);
                // printing the number of comment lines and new lines
                System.out.println("Number of comment lines, new lines, curly bracket are : " + b);
                // printing the number of lines of the functions/method found inside the text file.
                //System.out.println("Number of Functions are : " + k);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    // close bufferReader
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };

        return linesOfCodeConsumer;
    }
}
