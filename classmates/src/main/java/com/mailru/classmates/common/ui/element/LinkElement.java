package com.mailru.classmates.common.ui.element;


import org.openqa.selenium.WebDriver;

import com.mailru.classmates.common.ui.element.behavior.ClickableElement;
import com.mailru.classmates.common.ui.element.css_wrapper.CssWrapperSelector;
import com.mailru.classmates.common.ui.element.search_strategy.CssSearchStrategy;
import com.mailru.classmates.common.ui.element.wait_strategy.DomWithElementWaitStrategy;
import com.mailru.classmates.common.ui.element.wait_strategy.EnabledElementWaitStrategy;
import com.mailru.classmates.common.ui.screen.Screen;


/**
 * Different types of links
 */
public class LinkElement extends ElementBase implements ClickableElement
{
  public LinkElement( WebDriver webDriver, String hrefattrsSuffix )
  {
    super( new CssSearchStrategy(), new DomWithElementWaitStrategy(), webDriver,
      CssWrapperSelector.LINK_WITH_HREFATTRS_SUFFIX.getLinkCssWrapper().wrapToCssSelector( hrefattrsSuffix ) );
  }

  public LinkElement( WebDriver webDriver, CssWrapperSelector cssWrapperSelector, String cssSelectorPart )
  {
    super( new CssSearchStrategy(), new EnabledElementWaitStrategy(), webDriver, cssWrapperSelector.getLinkCssWrapper()
      .wrapToCssSelector( cssSelectorPart ) );
  }

  @Override
  public void clickAndWaitForScreen( Screen screen )
  {
    waitAndGetWebElement().click();
    screen.validateScreen();
  }
}
