package com.mailru.classmates.common.ui.element.search_strategy;


import org.openqa.selenium.WebElement;

import com.mailru.classmates.common.ui.element.Element;


/**
 * Interface for unite on screen classes different types of elements by search strategy
 */
public interface SearchStrategy
{
  /**
   * Prepare element for WebDriverWait
   *
   * @param element
   * @return
   */
  public abstract WebElement getElement( Element element );
}
