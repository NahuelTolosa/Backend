package com.coder;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class App {

    final static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        App app = new App();

        if (logger.isDebugEnabled()) {
            logger.debug("debug:");
        }

        if (logger.isInfoEnabled()) {
            logger.info("info");
        }

        logger.warn("warn");

        logger.error("error");
    }

}
