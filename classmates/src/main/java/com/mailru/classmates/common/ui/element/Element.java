package com.mailru.classmates.common.ui.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Any element in DOM
 */
public interface Element
{
  public abstract String getSelector();
  public abstract int getNumber();
  public abstract WebElement getWebElement();
  public abstract WebDriver getWebDriver();
}
