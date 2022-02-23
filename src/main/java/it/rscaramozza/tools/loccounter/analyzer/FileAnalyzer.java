package it.rscaramozza.tools.loccounter.analyzer;

import it.rscaramozza.tools.loccounter.files.FileUtility;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public abstract class FileAnalyzer implements IFileAnalyzer{

    public void countLines(String startDirectory, String[] extensions){
        AtomicInteger totalLinesOfCode = new AtomicInteger();
        FileUtility.searchFilesToAnalyze(startDirectory, extensions).forEach(linesOfCodeConsumer(totalLinesOfCode));
        System.out.println("Total LoC : " + totalLinesOfCode);
    }

    protected abstract Consumer<File> linesOfCodeConsumer(AtomicInteger totalLinesOfCode);
}
