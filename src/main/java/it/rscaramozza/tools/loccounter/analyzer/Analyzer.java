package it.rscaramozza.tools.loccounter.analyzer;

import it.rscaramozza.tools.loccounter.filetypes.FileType;

import java.util.Arrays;
import java.util.function.Consumer;

import static it.rscaramozza.tools.loccounter.filetypes.FileType.*;

public class Analyzer {

    private Analyzer(){
        throw new IllegalStateException("Static Class");
    }

    public static void analyzeFiles(String startDirectory, String[] extensions) {
        Arrays.stream(extensions).forEach(callExtensionAnalyzer(startDirectory));
    }

    private static Consumer<String> callExtensionAnalyzer(String startDirectory) {
        return (String extension) -> {
            FileType fileType = FileType.valueOf(extension);
            switch (fileType) {
                case JAVA -> FileAnalyzerFactory.getFileAnalyzerInstance(JAVA).countLines(startDirectory, new String[]{extension});
                case XML -> FileAnalyzerFactory.getFileAnalyzerInstance(XML).countLines(startDirectory, new String[]{extension});
                default -> System.out.println("Analyzer not yet implemented for " + extension);
            }
        };
    }
}
