package classmates.session.screen;

import org.openqa.selenium.WebDriver;

import classmates.common.ui.element.LinkElement;
import classmates.common.ui.screen.ViewScreenBase;
import classmates.personal_info.screen.InfoViewScreen;

/**
 * Screen for user dashboard view
 */
public class DashboardViewScreen extends ViewScreenBase
{

  private LinkElement personalLink = new LinkElement( getDriver(), "FatFooter_userProfile" );

  public DashboardViewScreen( WebDriver webDriver )
  {
    super( webDriver );
  }

  /**
   * TODO should be used dropdown in right of screen in future
   * 
   * @return
   */
  public InfoViewScreen openPersonalInfo()
  {
    personalLink.clickAndWaitForScreen( new InfoViewScreen( getDriver() ) );
    return new InfoViewScreen( getDriver() );
  }
}
