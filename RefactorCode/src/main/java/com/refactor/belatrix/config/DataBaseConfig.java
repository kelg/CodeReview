package com.refactor.belatrix.config;

import com.refactor.belatrix.util.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConfig {

  private static Connection connection;
  static Properties properties;

  static {
    properties = new Properties();
    properties.put(Constants.JDBC_URL,"jdbc:hsqldb:hsql://localhost/testdbase");
    properties.put(Constants.JDBC_USERNAME,"SA");
    properties.put(Constants.JDBC_PASSWORD,"");

    try {
      Class.forName("org.hsqldb.jdbc.JDBCDriver");
    }catch (ClassNotFoundException ex){
      ex.printStackTrace();
    }

  }

  public Connection getConnectionDB() {
    try{
      connection = DriverManager.getConnection(properties.getProperty(Constants.JDBC_URL), properties);
    }catch (SQLException ex){
      ex.printStackTrace();
    }

    return connection;
  }

}
