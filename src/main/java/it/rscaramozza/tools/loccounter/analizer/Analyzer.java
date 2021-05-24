package it.rscaramozza.tools.loccounter.analizer;

import java.util.Arrays;
import java.util.function.Consumer;

public class Analyzer {

    public static void analyzeFiles(String startDirectory, String[] extensions) {
        Arrays.stream(extensions).iterator().forEachRemaining(callExtensionAnalyzer(startDirectory));
    }

    private static Consumer<String> callExtensionAnalyzer(String startDirectory) {
        return (String extension) -> {
            switch (extension) {
                case "java":
                    JavaAnalyzer.countLines(startDirectory, new String[]{extension});
                    break;
                default:
                    System.out.println("Analyzer not yet implemented for " + extension);
                    break;
            }
        };
    }
}
