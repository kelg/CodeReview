package com.refactor.belatrix;

import com.refactor.belatrix.service.impl.ConsoleLoggerServiceImpl;
import com.refactor.belatrix.service.impl.DataBaseLoggerServiceImpl;
import com.refactor.belatrix.service.impl.FileLoggerServiceImpl;
import com.refactor.belatrix.util.Constants;

import java.util.HashMap;
import java.util.Map;


public class App {
  public static void main(String[] args) {
    Map<String, String> mapDbs = new HashMap<>();
    mapDbs.put(Constants.LOG_FILE_FOLDER_KEY, "src");

    LoggerProcessor loggerProcessor = new LoggerProcessor(
        new ConsoleLoggerServiceImpl(),
        new DataBaseLoggerServiceImpl(),
        new FileLoggerServiceImpl(),
        false,
        true,
        false,
        mapDbs
    );

    try {

      loggerProcessor.processLogger("MENSAJE DE PRUEBA", true, true, true);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
