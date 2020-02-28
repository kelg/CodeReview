package com.refactor.belatrix;

import com.refactor.belatrix.service.FileLoggerService;
import com.refactor.belatrix.service.impl.FileLoggerServiceImpl;
import com.refactor.belatrix.util.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileLoggerServiceImplTest {

  String messageText = "MENSAJE DE PRUEBA";
  Map<String,String> dbsParam = new HashMap<>();


  @Before
  public void setUp() throws Exception {
    initializeParams();
  }

  @Test
  public void testFileLoggerServiceImplOk(){


    FileLoggerService fileLoggerService = new FileLoggerServiceImpl();
    fileLoggerService.writeMessageToFile(messageText, dbsParam);

    verifyFileExist();
  }

  public void initializeParams(){
    dbsParam.put(Constants.LOG_FILE_FOLDER_KEY, "src");
  }

  public void verifyFileExist(){
    File logFile = new File("src", "logFile.txt");
    Assert.assertTrue(logFile.exists());
  }

}
