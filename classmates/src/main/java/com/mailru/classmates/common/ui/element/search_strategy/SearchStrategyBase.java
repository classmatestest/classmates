package com.mailru.classmates.common.ui.element.search_strategy;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mailru.classmates.common.ui.element.Element;



/**
 * Shared functional for all search strategies
 */
public abstract class SearchStrategyBase implements SearchStrategy
{
  private int toIndex( int number )
  {
    return number - 1;
  }

  public WebElement getElement( Element element )
  {
    List<WebElement> elements = element.getWebDriver().findElements( searchBy( element.getSelector() ) );
    if( elements.size() < element.getNumber() )
    {
      return null;
    }
    else
    {
      return elements.get( toIndex( element.getNumber() ) );
    }
  }
  
  protected abstract By searchBy( String selector);
}