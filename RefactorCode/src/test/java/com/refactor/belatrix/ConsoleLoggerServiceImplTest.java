package com.refactor.belatrix;

import com.refactor.belatrix.service.ConsoleLoggerService;
import com.refactor.belatrix.service.impl.ConsoleLoggerServiceImpl;
import org.junit.Test;

import java.util.logging.Logger;

public class ConsoleLoggerServiceImplTest {

  private static Logger logger = Logger.getLogger("Logger");

  @Test
  public void testConsoleLoggerServiceImpl(){

    ConsoleLoggerService consoleLoggerService = new ConsoleLoggerServiceImpl();

    LogHandler handler = new LogHandler();
    logger.addHandler(handler);

    consoleLoggerService.writeMessageToConsole("MENSAJE DE PRUEBA");

    handler.getLevel();

  }

}
