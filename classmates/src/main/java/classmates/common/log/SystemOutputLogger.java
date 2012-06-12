package classmates.common.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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
    logger.setLevel( Level.INFO );
  }

  public static Logger log()
  {
    return logger;
  }
}
