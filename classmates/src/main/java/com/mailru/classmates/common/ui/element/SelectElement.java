package com.mailru.classmates.common.ui.element;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mailru.classmates.common.ui.element.behavior.SelectorElement;
import com.mailru.classmates.common.ui.element.search_strategy.IdSearchStrategy;
import com.mailru.classmates.common.ui.element.wait_strategy.DisplayedElementWaitStrategy;



/**
 * Simple single selectors (dropdown lists)
 */
public class SelectElement extends ElementBase implements SelectorElement
{

  public SelectElement( WebDriver webDriver, String id )
  {
    super( new IdSearchStrategy(), new DisplayedElementWaitStrategy(), webDriver, id );
  }

  @Override
  public String getContent()
  {
    return new Select( waitAndGetWebElement() ).getFirstSelectedOption().getAttribute( "value" );
  }

  @Override
  public void selectByValue( String value )
  {
    new Select( waitAndGetWebElement() ).selectByValue( value );
  }

  @Override
  public void selectByIndex( int index )
  {
    new Select( waitAndGetWebElement() ).selectByIndex( index );
  }
}
