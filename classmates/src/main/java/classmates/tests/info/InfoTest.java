package classmates.tests.info;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import classmates.common.service.UiServiceProxyFactory;
import classmates.personal_info.factory.InfoFactory;
import classmates.personal_info.object.IncorrectInfo;
import classmates.personal_info.object.Info;
import classmates.personal_info.service.InfoUiService;
import classmates.personal_info.service.InfoUiServiceInProxy;
import classmates.session.factory.SessionFactory;
import classmates.tests.BaseTest;

public class InfoTest extends BaseTest
{
  private SessionFactory sessionFactory = new SessionFactory();

 
  /**
   * Very ugly
   * TODO Should be eliminated after Guice or some another AOP solution implemented
   */
private InfoUiServiceInProxy infoUiService = UiServiceProxyFactory.getUiServiceProxy( InfoUiServiceInProxy.class,
    new InfoUiService( sessionFactory.getDefaultSession() ) );

  InfoFactory infoFactory = new InfoFactory();

  private Info defaultPersonalInfo = infoFactory.getDefaultPersonalInfo();

  @BeforeMethod
  public void prepareAccount() throws Exception
  {
    infoUiService.setInfo( defaultPersonalInfo );
  }

  @Test( enabled = true )
  public void testSuccesfullSaveCorrectInfo() throws Exception
  {
    Info correctPersonalInfo = infoFactory.getCorrectPersonalInfo();
    infoUiService.setInfo( correctPersonalInfo );
    Info actualPersonalInfo = infoUiService.getInfo();
    assertEquals( correctPersonalInfo, actualPersonalInfo );
  }

  @Test( enabled = true )
  public void testNotSaveNotValidInfo() throws Exception
  {
    Info notValidPersonalInfo = infoFactory.getNotValidPersonalInfo();
    assertTrue(infoUiService.fillIncorrectInfoSubmitAndCancel( notValidPersonalInfo, IncorrectInfo.NOT_VALID ) );
    Info actualPersonalInfo = infoUiService.getInfo();
    assertEquals( defaultPersonalInfo, actualPersonalInfo );
  }

  @Test( enabled = true )
  public void testNotSaveEmptyInfo() throws Exception
  {
    Info emptyPersonalInfo = infoFactory.getEmptyPersonalInfo();
    assertTrue( infoUiService.fillIncorrectInfoSubmitAndCancel( emptyPersonalInfo, IncorrectInfo.EMPTY ) );
    Info actualPersonalInfo = infoUiService.getInfo();
    assertEquals( defaultPersonalInfo, actualPersonalInfo );
  }
}
