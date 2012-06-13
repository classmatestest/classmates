package com.mailru.classmates.common.ui.element;


import org.openqa.selenium.WebDriver;

import com.mailru.classmates.common.ui.element.behavior.TypeWriteElement;
import com.mailru.classmates.common.ui.element.search_strategy.IdSearchStrategy;
import com.mailru.classmates.common.ui.element.wait_strategy.EnabledElementWaitStrategy;



/**
 * Simple inputs
 */
public class InputElement extends ElementBase implements TypeWriteElement
{

  public InputElement( WebDriver webDriver, String id )
  {
    super( new IdSearchStrategy(), new EnabledElementWaitStrategy(), webDriver, id );
  }

  @Override
  public String getContent()
  {
    return waitAndGetWebElement().getAttribute( "value" );
  }

  @Override
  public void typeWrite( String value )
  {
    waitAndGetWebElement().clear();
    waitAndGetWebElement().sendKeys( value );
  }
}
