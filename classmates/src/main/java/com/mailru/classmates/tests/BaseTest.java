package com.mailru.classmates.tests;

import static com.mailru.classmates.common.log.SystemOutputLogger.log;
import static com.mailru.classmates.common.log.SystemOutputLogger.outputLoggerconfigure;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.mailru.classmates.common.config.BrowserParameters;
import com.mailru.classmates.common.config.SessionParameters;


/**
 * Common configuration steps, all parameters get from testng XML
 */
public class BaseTest
{
  @Parameters( {"webDriverURL", "classmatesUrl", "firefoxVersion", "firefoxPlatform"} )
  @BeforeSuite
  public void prepareConfig( String webDriverURL, String classmatesURL, String firefoxVersion, String firefoxPlatform )
    throws Exception
  {
    outputLoggerconfigure();
    BrowserParameters.getInstance().setWebDriverUrl( webDriverURL );
    BrowserParameters.getInstance().setFirefoxVersion( firefoxVersion );
    BrowserParameters.getInstance().setPlatform( firefoxPlatform );
    log().info( "Set WebDriver URL to: " + webDriverURL );
    SessionParameters.getInstance().setUrl( classmatesURL );
    log().info( "Set test host URL to: " + classmatesURL );
  }
}
