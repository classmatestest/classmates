package com.mailru.classmates.session.service;

import static com.mailru.classmates.common.log.SystemOutputLogger.log;

import com.mailru.classmates.common.service.UiServiceBase;
import com.mailru.classmates.session.object.Session;
import com.mailru.classmates.session.screen.DashboardViewScreen;

public class SessionUiService extends UiServiceBase implements SessionUiServiceInProxy
{
  public SessionUiService( Session session )
  {
    super( session );
  }

  @Override
  public boolean isSessionPrepared()
  {
    try
    {
      DashboardViewScreen dashboardViewScreen = openSession();
      closeSession( dashboardViewScreen );
      return true;
    }
    catch( Exception e )
    {
      log().info( e.getMessage() );
      closeSessionBrowser();
      return false;
    }
  }
}
