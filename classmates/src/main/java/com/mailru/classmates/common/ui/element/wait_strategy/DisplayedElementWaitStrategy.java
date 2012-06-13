package com.mailru.classmates.common.ui.element.wait_strategy;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mailru.classmates.common.timeout.Timeout;
import com.mailru.classmates.common.ui.element.Element;
import com.mailru.classmates.common.ui.element.search_strategy.SearchStrategy;



/**
 * Wait, then element was displayed
 */
public class DisplayedElementWaitStrategy extends DomWithElementWaitStrategy
{

  @Override
  public WebElement waitWith( final Element element, final SearchStrategy searchStrategy )
  {
    final WebElement webElement = super.waitWith( element, searchStrategy );
    if( webElement == null )
    {
      return null;
    }

    WebDriverWait wait = new WebDriverWait( element.getWebDriver(), Timeout.DEFAULT_ELEMENT_DISPLAYED_WAIT_TIMEOUT.getTimeoutValue() );
    wait.until( new ExpectedCondition<Boolean>()
    {
      @Override
      public Boolean apply( WebDriver d )
      {
        return webElement.isDisplayed();
      }
    } );

    return webElement;
  }
}
