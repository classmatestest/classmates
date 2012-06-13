package com.mailru.classmates.common.ui.screen;


import org.openqa.selenium.WebDriver;

import com.mailru.classmates.common.ui.element.LinkElement;


/**
 * Shared edit screen functionality, close popup functionality should be described in each edit screen separately
 */
public abstract class EditScreenBase extends ScreenBase implements EditScreen
{
  private LinkElement logoutLink = new LinkElement( getDriver(), "MRGT_Logoff" );

  protected EditScreenBase( WebDriver webDriver )
  {
    super( webDriver );
  }

  @Override
  public void validateScreen()
  {
    logoutLink.waitAndGetWebElement();
  }
}
