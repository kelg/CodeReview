package com.refactor.belatrix.service.impl;

import com.refactor.belatrix.config.DataBaseConfig;
import com.refactor.belatrix.service.DataBaseLoggerService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseLoggerServiceImpl implements DataBaseLoggerService {

  private static Logger logger = Logger.getLogger("Logger");

  private DataBaseConfig dataBaseConfig;

  private static final String INSERT_QUERY = "insert into LOG_VALUES (MESSAGE,COUNT) VALUES ('%s', %d); ";

  @Override
  public void insertMessageToDatabase(String message, int count) {

    dataBaseConfig = new DataBaseConfig();

    try {
      Connection connection = dataBaseConfig.getConnectionDB();

      Statement stmt = connection.createStatement();

      stmt.executeUpdate(String.format(INSERT_QUERY, message, count));
    } catch (SQLException ex) {
      logger.log(Level.SEVERE, ex.getMessage(), ex);
    }

  }
}
