package classmates.session.service;

import static classmates.common.log.SystemOutputLogger.log;
import classmates.common.service.UiServiceBase;
import classmates.session.object.Session;
import classmates.session.screen.DashboardViewScreen;

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
