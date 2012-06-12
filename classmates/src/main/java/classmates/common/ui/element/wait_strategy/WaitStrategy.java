package classmates.common.ui.element.wait_strategy;


import org.openqa.selenium.WebElement;

import classmates.common.ui.element.Element;
import classmates.common.ui.element.search_strategy.SearchStrategy;


/**
 * Waiting strategy for any element in DOM
 */
public interface WaitStrategy
{
  public abstract WebElement waitWith( Element element, SearchStrategy searchStrategy );
}
