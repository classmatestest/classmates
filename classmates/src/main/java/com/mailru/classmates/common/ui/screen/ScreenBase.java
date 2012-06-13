package com.mailru.classmates.common.ui.screen;

import org.openqa.selenium.WebDriver;

/**
 * Shared screens functionality
 */
public abstract class ScreenBase implements Screen
{
  private WebDriver webDriver;

  protected ScreenBase( WebDriver webDriver )
  {
    setDriver( webDriver );
  }

  protected WebDriver getDriver()
  {
    return webDriver;
  }

  private void setDriver( WebDriver webDriver )
  {
    this.webDriver = webDriver;
  }

  @Override
  public abstract void validateScreen();
}
