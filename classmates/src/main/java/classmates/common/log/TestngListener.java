package classmates.common.log;

import static classmates.common.log.SystemOutputLogger.log;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Simple TestNG listener
 */
public class TestngListener implements ITestListener
{

  private void logTestMethodMessage( String message )
  {
    log().info( "====> " + message );
  }

  private void logTestClassMessage( String message )
  {
    log().info( "===================================================================" );
    log().info( "==> " + message );
    log().info( "===================================================================" );
  }

  @Override
  public void onTestStart( ITestResult result )
  {
    logTestMethodMessage( "Method " + result.getName() + " STARTED" );
  }

  @Override
  public void onTestSuccess( ITestResult result )
  {
    logTestMethodMessage( "Method " + result.getName() + " SUCCESS" );
  }

  @Override
  public void onTestFailure( ITestResult result )
  {
    logTestMethodMessage( "Method " + result.getName() + " FAILED" );
  }

  @Override
  public void onTestSkipped( ITestResult result )
  {
    logTestMethodMessage( "Method " + result.getName() + " SKIPPED" );
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage( ITestResult result )
  {
    logTestMethodMessage( "Method " + result.getName() + " FAILED but has been annotated with successPercentage" );
  }

  @Override
  public void onStart( ITestContext context )
  {
    logTestClassMessage( "Test Class " + context.getName() + " STARTED" );
  }

  @Override
  public void onFinish( ITestContext context )
  {
    logTestClassMessage( "Test Class " + context.getName() + " FINISHED" );
  }
}
