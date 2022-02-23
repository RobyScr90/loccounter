package it.rscaramozza.tools.loccounter.files;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

public class FileUtility {

    public static Collection<File> searchFilesToAnalyze(String startDirectory, String[] extensions){

        File inFile = new File(startDirectory);

        Collection<File> filesToAnalyze = FileUtils.listFiles(inFile, extensions, true);

        System.out.println("Number of file with extensions " + Arrays.toString(extensions) + " : " + filesToAnalyze.size());

        return filesToAnalyze;
    }

}
