package com.mailru.classmates.common.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Singleton with WebDriver parameters
 */
public class BrowserParameters
{
  private final static BrowserParameters instance;

  static
  {
    instance = new BrowserParameters();
  }

  /**
   * Constructor setup default parameters, provided by SauceLabs
   */
  private BrowserParameters()
  {
    setDesiredCapabilities( DesiredCapabilities.firefox() );
    getDesiredCapabilities().setCapability( "name", "Testing odnoklassniki.ru with Java on Sauce" );
  }

  public final static BrowserParameters getInstance()
  {
    return instance;
  }

  private URL webDriverUrl;

  private DesiredCapabilities desiredCapabilities;

  public DesiredCapabilities getDesiredCapabilities()
  {
    return desiredCapabilities;
  }

  private void setDesiredCapabilities( DesiredCapabilities desiredCapabilities )
  {
    this.desiredCapabilities = desiredCapabilities;
  }

  public URL getWebDriverUrl()
  {
    return webDriverUrl;
  }

  public void setWebDriverUrl( String webDriverUrl ) throws MalformedURLException
  {
    this.webDriverUrl = new URL( webDriverUrl );
  }

  public void setFirefoxVersion( String firefoxVersion )
  {
    getDesiredCapabilities().setCapability( "version", firefoxVersion );
  }

  public void setPlatform( String firefoxPlatform )
  {
    getDesiredCapabilities().setCapability( "platform", Platform.extractFromSysProperty( firefoxPlatform ) );
  }
}
