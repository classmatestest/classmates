package com.mailru.classmates.common.service;


import org.openqa.selenium.WebDriver;

import com.mailru.classmates.common.ui.screen.EditScreen;
import com.mailru.classmates.common.ui.screen.ViewScreen;
import com.mailru.classmates.common.ui.service.BrowserService;
import com.mailru.classmates.session.object.Session;
import com.mailru.classmates.session.screen.DashboardViewScreen;
import com.mailru.classmates.session.screen.LoginScreen;


/**
 * Shared functionality for all UI service, include open and close session with authorisation support
 */
public class UiServiceBase implements UiService
{
  private Session session;

  private BrowserService browserService = new BrowserService();

  public UiServiceBase( Session session )
  {
    setSession( session );
  }

  private Session getSession()
  {
    return session;
  }

  private void setSession( Session session )
  {
    this.session = session;
  }

  private BrowserService getBrowserService()
  {
    return browserService;
  }

  @Override
  public DashboardViewScreen openSession()
  {
    WebDriver webDriver = getBrowserService().openBrowser();

    LoginScreen loginScreen = new LoginScreen( webDriver );
    DashboardViewScreen dashboardViewScreen =
      loginScreen.login( getSession().getLogin(), getSession().getPassword(), getSession().isSaveSession() );
    return dashboardViewScreen;
  }

  public void closeSession( ViewScreen viewScreen )
  {
    viewScreen.logout();
    closeSessionBrowser();
  }

  public void closeSession( EditScreen editScreen )
  {
    ViewScreen viewScreen = editScreen.close();
    viewScreen.logout();
    closeSessionBrowser();
  }

  @Override
  public void closeSessionBrowser()
  {
    getBrowserService().closeBrowser();
  }
}
