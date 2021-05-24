package it.rscaramozza.tools.loccounter;

import it.rscaramozza.tools.loccounter.analizer.Analyzer;

public class LocCounter {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("You need to pass at least the source directory");
            System.out.print("Usage: java -jar loc-counter.jar [path_to_scan] [extension_1,extension_2..]");
            System.exit(1);
        }

        String startDirectory = args[0];
        String[] extensions = args[1].split(",");

        Analyzer.analyzeFiles(startDirectory,extensions);

    }
}
