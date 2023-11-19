package org.example;

import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {

    final private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
    logger.info("Program is start!");
        System.out.println(LocalDateTime.now(ZoneId.of("UTC+4")));
    logger.info("Program is end!");
    }
}