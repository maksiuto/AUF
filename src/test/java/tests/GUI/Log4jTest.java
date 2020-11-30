package tests.GUI;

import models.Bar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jTest {
    private static final Logger logger = LogManager.getLogger(Log4jTest.class);

    @Test
    public void mainTest() {
        logger.fatal("Test message - FATAL");
        logger.error("Test message - ERROR");
        logger.warn("Test message - WARN");
        logger.info("Test message - INFO");
        logger.debug("Test message - DEBUG");
        logger.trace("Test message - TRACE");

        logger.trace("Entering application");

        Bar bar = new Bar();
        if (!Bar.doIt()) {
            logger.error("Didn't do it");
        }
        logger.trace("Exit application");
    }
}
