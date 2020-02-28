package com.refactor.belatrix.service.impl;

import com.refactor.belatrix.service.FileLoggerService;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.refactor.belatrix.util.Constants.*;

public class FileLoggerServiceImpl implements FileLoggerService {

  private static Logger logger = Logger.getLogger("Logger");

  @Override
  public void writeMessageToFile(String messageText, Map dbParams)  {

    File logFile = new File(dbParams.get(LOG_FILE_FOLDER_KEY) + LOG_FILE_NAME);

    try {
      if (!logFile.exists()) {
        logFile.createNewFile();
      }

      FileHandler fileHandler = new FileHandler(dbParams.get(LOG_FILE_FOLDER_KEY) + LOG_FILE_NAME);

      logger.addHandler(fileHandler);
      logger.log(Level.INFO, messageText);
    }catch (IOException ex){
      logger.log(Level.SEVERE,ex.getMessage(),ex);
    }

  }
}
