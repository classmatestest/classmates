package com.mailru.classmates.personal_info.screen;


import org.openqa.selenium.WebDriver;

import com.mailru.classmates.common.ui.element.LinkElement;
import com.mailru.classmates.common.ui.screen.ViewScreenBase;



/**
 * Screen for persona info dashboard
 * TODO shold be added check of some personal info parameters, like ages or name
 */
public class InfoViewScreen extends ViewScreenBase
{
  public InfoViewScreen( WebDriver webDriver )
  {
    super( webDriver );
  }

  LinkElement editLink = new LinkElement( getDriver(), "UserProfile_editOwn" );

  public InfoEditScreen edit()
  {
    editLink.clickAndWaitForScreen( new InfoEditScreen( getDriver() ) );
    return new InfoEditScreen( getDriver() );
  }
}
