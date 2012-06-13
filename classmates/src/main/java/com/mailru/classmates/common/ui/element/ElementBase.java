package com.mailru.classmates.common.ui.element;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mailru.classmates.common.ui.element.search_strategy.SearchStrategy;
import com.mailru.classmates.common.ui.element.wait_strategy.WaitStrategy;


/**
 * Shared functional for any element in DOM
 */
public class ElementBase implements Element
{
  private SearchStrategy searchStrategy;

  private WaitStrategy waitStrategy;

  private String selector;

  private int number;

  private WebElement webElement;

  private WebDriver webDriver;

  protected ElementBase( SearchStrategy searchStrategy, WaitStrategy waitStrategy, WebDriver webDriver,
    String selector, int number )
  {
    setSearchStrategy( searchStrategy );
    setWaitStrategy( waitStrategy );
    setWebDriver( webDriver );
    setSelector( selector );
    setNumber( number );
  }

  protected ElementBase( SearchStrategy searchStrategy, WaitStrategy waitStrategy, WebDriver webDriver, String selector )
  {
    this( searchStrategy, waitStrategy, webDriver, selector, 1 );
  }

  public SearchStrategy getSearchStrategy()
  {
    return searchStrategy;
  }

  private void setSearchStrategy( SearchStrategy searchStrategy )
  {
    this.searchStrategy = searchStrategy;
  }

  public WaitStrategy getWaitStrategy()
  {
    return waitStrategy;
  }

  private void setWaitStrategy( WaitStrategy waitStrategy )
  {
    this.waitStrategy = waitStrategy;
  }

  @Override
  public String getSelector()
  {
    return selector;
  }

  private void setSelector( String selector )
  {
    this.selector = selector;
  }

  @Override
  public int getNumber()
  {
    return number;
  }

  private void setNumber( int number )
  {
    this.number = number;
  }

  @Override
  public WebElement getWebElement()
  {
    return webElement;
  }

  private void setWebElement( WebElement webElement )
  {
    this.webElement = webElement;
  }

  @Override
  public WebDriver getWebDriver()
  {
    return webDriver;
  }

  private void setWebDriver( WebDriver webDriver )
  {
    this.webDriver = webDriver;
  }

  public WebElement waitAndGetWebElement()
  {
    WebElement webElement = getWaitStrategy().waitWith( this, getSearchStrategy() );
    setWebElement( webElement );
    return getWebElement();
  }
}
