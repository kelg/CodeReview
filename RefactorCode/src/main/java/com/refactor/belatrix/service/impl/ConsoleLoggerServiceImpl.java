package com.refactor.belatrix.service.impl;

import com.refactor.belatrix.service.ConsoleLoggerService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleLoggerServiceImpl implements ConsoleLoggerService {

  private static Logger logger = Logger.getLogger("Logger");

  @Override
  public void writeMessageToConsole(String messageText) {

    logger.log(Level.INFO, messageText);

  }
}
