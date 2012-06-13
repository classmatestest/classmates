package com.mailru.classmates.common.ui.element.search_strategy;

import org.openqa.selenium.By;

/**
 * Search element in DOM by id attribute
 */
public class IdSearchStrategy extends SearchStrategyBase
{
  @Override
  protected By searchBy( String id )
  {
    return By.id( id );
  }
}
