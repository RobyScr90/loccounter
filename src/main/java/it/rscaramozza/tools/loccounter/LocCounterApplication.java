package it.rscaramozza.tools.loccounter;


import it.rscaramozza.tools.loccounter.analyzer.Analyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocCounterApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(LocCounterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LocCounterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            logger.warn("You need to pass at least the source directory");
            logger.warn("Usage: java -jar loc-counter.jar [path_to_scan] [extension_1,extension_2..]");
//            System.out.println("You need to pass at least the source directory");
//            System.out.print("Usage: java -jar loc-counter.jar [path_to_scan] [extension_1,extension_2..]");
            System.exit(1);
        }

        String startDirectory = args[0];
        String[] extensions = args[1].split(",");

        Analyzer.analyzeFiles(startDirectory,extensions);
    }
}
