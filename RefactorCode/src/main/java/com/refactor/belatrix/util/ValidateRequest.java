package com.refactor.belatrix.util;

public class ValidateRequest {

  public static void validateRequest(String messageText, boolean logMessage, boolean logWarning, boolean logError,
                                        boolean logToConsole, boolean logToFile, boolean logToDatabase) throws Exception{

    if (messageText == null || messageText.trim().isEmpty()) {
      return;
    }
    if (!logToConsole && !logToFile && !logToDatabase) {
      throw new Exception("Invalid configuration");
    }
    if ((!logError && !logMessage && !logWarning)) {
      throw new Exception("Error or Warning or Message must be specified");
    }
  }

}
