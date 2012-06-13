package com.mailru.classmates.common.ui.element.search_strategy;

import org.openqa.selenium.By;

/**
 * Search element in DOM by class attribute
 */
public class ClassNameSearchStrategy extends SearchStrategyBase
{
  @Override
  protected By searchBy( String className )
  {
    return By.className( className );
  }
}
