package classmates.common.ui.element.wait_strategy;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import classmates.common.timeout.Timeout;
import classmates.common.ui.element.Element;
import classmates.common.ui.element.search_strategy.SearchStrategy;


/**
 * Wait, then element presented in DOM
 */
public class DomWithElementWaitStrategy implements WaitStrategy
{

  @Override
  public WebElement waitWith( final Element element, final SearchStrategy searchStrategy )
  {
    WebDriverWait wait =
      new WebDriverWait( element.getWebDriver(), Timeout.DEFAULT_ELEMENT_WAIT_TIMEOUT.getTimeoutValue() );
    WebElement webElement = element.getWebElement();
    if( webElement == null )
    {
      webElement = wait.until( new ExpectedCondition<WebElement>()
      {
        @Override
        public WebElement apply( WebDriver d )
        {
          return searchStrategy.getElement( element );
        }
      } );
    }
    return webElement;
  }

}
