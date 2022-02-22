package it.rscaramozza.tools.loccounter.analyzer;

import it.rscaramozza.tools.loccounter.filetypes.FileType;

public class FileAnalyzerFactory {

    private FileAnalyzerFactory(){
        throw new IllegalStateException("Factory Class");
    }

    public static IFileAnalyzer getFileAnalyzerInstance(FileType fileType) {
        return (switch (fileType) {
            case JAVA -> new JavaAnalyzer();
            case XML -> new XmlAnalyzer();
            default -> throw new IllegalStateException("Unexpected value: " + fileType);
        });

    }
}
