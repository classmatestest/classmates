package com.mailru.classmates.common.log;

import java.io.OutputStreamWriter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * Trivial logger to system output
 */
public class SystemOutputLogger
{
  private static Logger logger;

  public static void outputLoggerconfigure()
  {
    ConsoleAppender appender = new ConsoleAppender();
    appender.setWriter(new OutputStreamWriter(System.out));
    appender.setLayout(new PatternLayout("%d %-5p %m%n"));
    appender.setEncoding( "UTF-8" );
    BasicConfigurator.configure(appender);
    logger = Logger.getRootLogger();
    logger.setLevel( Level.INFO );
  }

  public static Logger log()
  {
    return logger;
  }
}
