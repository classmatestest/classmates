package com.mailru.classmates.common.ui.element;


import org.openqa.selenium.WebDriver;

import com.mailru.classmates.common.ui.element.behavior.TypeWriteElement;
import com.mailru.classmates.common.ui.element.search_strategy.ClassNameSearchStrategy;
import com.mailru.classmates.common.ui.element.wait_strategy.DisplayedElementWaitStrategy;


/**
 * Dropdown suggest, shown after typewrite some text to input, selected only if we type to input equal or empty value
 */
public class SuggestElement extends ElementBase implements TypeWriteElement
{

  public SuggestElement( WebDriver webDriver, String className, int number )
  {
    super( new ClassNameSearchStrategy(), new DisplayedElementWaitStrategy(), webDriver, className, number );
  }

  public SuggestElement( WebDriver webDriver, String className )
  {
    this( webDriver, className, 1 );
  }

  @Override
  public String getContent()
  {
    return waitAndGetWebElement().getText();
  }

  @Override
  public void typeWrite( String value )
  {
    if( !value.equals( "" ) && getContent().equals( value ) )
    {
      waitAndGetWebElement().click();
    }
  }
}
