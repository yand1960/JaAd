package my.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Log4jDemo.class);

        logger.info("It is info");
        logger.warn("It is warning");
        logger.fatal("It is severe");
    }

}
