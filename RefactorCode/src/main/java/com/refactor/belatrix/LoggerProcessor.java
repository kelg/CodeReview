package com.refactor.belatrix;

import com.refactor.belatrix.service.ConsoleLoggerService;
import com.refactor.belatrix.service.DataBaseLoggerService;
import com.refactor.belatrix.service.FileLoggerService;
import com.refactor.belatrix.util.ValidateRequest;

import java.util.Map;

public class LoggerProcessor {

  private ConsoleLoggerService consoleLoggerService;
  private DataBaseLoggerService dataBaseLoggerService;
  private FileLoggerService fileLoggerService;

  private static boolean logToFile;
  private static boolean logToConsole;
  private static boolean logToDatabase;

  private static Map dbParams;

  public LoggerProcessor(ConsoleLoggerService consoleLoggerService, DataBaseLoggerService dataBaseLoggerService,
                         FileLoggerService fileLoggerService, boolean logToFile, boolean logToConsole,
                         boolean logToDatabase, Map dbParams) {

    this.logToFile = logToFile;
    this.logToConsole = logToConsole;
    this.logToDatabase = logToDatabase;
    this.dbParams = dbParams;

    this.consoleLoggerService = consoleLoggerService;
    this.dataBaseLoggerService = dataBaseLoggerService;
    this.fileLoggerService = fileLoggerService;

  }

  public void processLogger(String messageText, boolean logMessage, boolean logWarning, boolean logError)
      throws Exception {

    ValidateRequest.validateRequest(messageText, logMessage, logWarning, logError,
        logToFile, logToConsole, logToDatabase);
    messageText = messageText.trim();

    String messageFinal = BuildLog.builMessageToLog(messageText, logError, logWarning, logMessage);

    if (logToConsole) {
      consoleLoggerService.writeMessageToConsole(messageFinal);
    }
    if (logToFile) {
      fileLoggerService.writeMessageToFile(messageFinal, dbParams);
    }
    if (logToDatabase) {
      int count = BuildLog.buildCountLogToDataBase(logError, logWarning, logMessage);
      dataBaseLoggerService.insertMessageToDatabase(messageText, count);
    }

  }

}
