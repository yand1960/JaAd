package my.logging;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingJdkDemo {

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(
                //new FileInputStream("E:\\USER_FILES\\JaAd\\JaAd10_Logging_Gradle\\src\\main\\resources\\logging.properties")
                LoggingJdkDemo.class.getResourceAsStream("../../logging.properties")
        );

        Logger logger = Logger.getLogger(LoggingJdkDemo.class.getName());
        logger.info("It is info");
        logger.warning("It is warning");
        logger.severe("It is severe");
    }
}
