package classmates.common.log;

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
    logger = Logger.getRootLogger();
    BasicConfigurator.configure();
    ConsoleAppender appender = new ConsoleAppender();
    appender.setLayout(new PatternLayout("%-5p [%t]: %m%n"));
    appender.setEncoding( "UTF-8" );
    BasicConfigurator.configure( appender );
    logger.setLevel( Level.INFO );
  }

  public static Logger log()
  {
    return logger;
  }
}
