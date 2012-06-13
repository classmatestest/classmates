package com.mailru.classmates.common.ui.element.search_strategy;

import org.openqa.selenium.By;

/**
 * Search element in DOM by CSS selector
 */
public class CssSearchStrategy extends SearchStrategyBase
{
  @Override
  protected By searchBy( String cssSelector )
  {
    return By.cssSelector( cssSelector );
  }
}
