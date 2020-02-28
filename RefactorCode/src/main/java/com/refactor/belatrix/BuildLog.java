package com.refactor.belatrix;

import com.refactor.belatrix.util.Constants;

import java.text.DateFormat;
import java.util.Date;

public class BuildLog {

  public static String builMessageToLog(String messageText, boolean logError, boolean logWarning, boolean logMessage) {

    StringBuilder sb = new StringBuilder();

    if (logError) {
      sb.append(Constants.LEVEL_LOG_ERROR).append(Constants.WHITE_SPACE)
          .append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date())).append(Constants.WHITE_SPACE)
          .append(messageText).append(Constants.NEW_LINE);
    }

    if (logWarning) {
      sb.append(Constants.LEVEL_LOG_WARNING).append(Constants.WHITE_SPACE)
          .append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date())).append(Constants.WHITE_SPACE)
          .append(messageText).append(Constants.NEW_LINE);
    }

    if (logMessage) {
      sb.append(Constants.LEVEL_LOG_MESSAGE).append(Constants.WHITE_SPACE)
          .append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date())).append(Constants.WHITE_SPACE)
          .append(messageText).append(Constants.NEW_LINE);
    }

    return sb.toString();
  }

  public static int buildCountLogToDataBase(boolean logError, boolean logWarning, boolean logMessage) {
    int count = 0;
    if (logMessage) {
      count++;
    }

    if (logError) {
      count++;
    }

    if (logWarning) {
      count++;
    }
    return count;
  }

}
