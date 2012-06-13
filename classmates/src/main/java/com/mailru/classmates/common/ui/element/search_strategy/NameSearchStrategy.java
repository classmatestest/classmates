package com.mailru.classmates.common.ui.element.search_strategy;

import org.openqa.selenium.By;

/**
 * Search element in DOM by name attribute
 */
public class NameSearchStrategy extends SearchStrategyBase
{
  @Override
  protected By searchBy( String name )
  {
    return By.name( name );
  }
}
