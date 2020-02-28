package com.refactor.belatrix.service;

import java.util.Map;

public interface FileLoggerService {

  void writeMessageToFile(String messageText, Map dbParams);

}
