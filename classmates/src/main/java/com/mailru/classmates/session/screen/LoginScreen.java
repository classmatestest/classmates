package com.mailru.classmates.session.screen;


import org.openqa.selenium.WebDriver;

import com.mailru.classmates.common.ui.element.ButtonElement;
import com.mailru.classmates.common.ui.element.CheckboxElement;
import com.mailru.classmates.common.ui.element.InputElement;
import com.mailru.classmates.common.ui.element.search_strategy.SearchStrategySelector;
import com.mailru.classmates.common.ui.screen.ScreenBase;


/**
 * Login page, used not main page for checking drawing button somethere in code
 */
public class LoginScreen extends ScreenBase
{
  private InputElement loginInput = new InputElement( getDriver(), "field_email" );

  private InputElement passwordInput = new InputElement( getDriver(), "field_password" );

  private CheckboxElement saveSessionCheckbox = new CheckboxElement( getDriver(), "field_remember" );

  private ButtonElement loginButton = new ButtonElement( getDriver(), SearchStrategySelector.BUTTON_BY_NAME,
    "button_go" );

  public LoginScreen( WebDriver webDriver )
  {
    super( webDriver );
  }

  public DashboardViewScreen login( String login, String password, boolean saveSession )
  {
    loginInput.typeWrite( login );
    passwordInput.typeWrite( password );
    saveSessionCheckbox.set( saveSession );
    loginButton.clickAndWaitForScreen( new DashboardViewScreen( getDriver() ) );
    return new DashboardViewScreen( getDriver() );
  }

  public void validateScreen()
  {
    loginInput.waitAndGetWebElement();
    passwordInput.waitAndGetWebElement();
    saveSessionCheckbox.waitAndGetWebElement();
    loginButton.waitAndGetWebElement();
  }
}
