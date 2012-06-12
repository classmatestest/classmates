package classmates.common.ui.element;


import org.openqa.selenium.WebDriver;

import classmates.common.ui.element.behavior.ClickableElement;
import classmates.common.ui.element.search_strategy.IdSearchStrategy;
import classmates.common.ui.element.search_strategy.SearchStrategySelector;
import classmates.common.ui.element.wait_strategy.DisplayedElementWaitStrategy;
import classmates.common.ui.screen.Screen;

/**
 * Simple and draw buttons
 */
public class ButtonElement extends ElementBase implements ClickableElement
{
  public ButtonElement( WebDriver webDriver, String id )
  {
    super( new IdSearchStrategy(), new DisplayedElementWaitStrategy(), webDriver, id );
  }

  public ButtonElement( WebDriver webDriver, SearchStrategySelector searchStrategySelector, String id )
  {
    super( searchStrategySelector.getSearchStrategyForButtonValue(), new DisplayedElementWaitStrategy(), webDriver, id );
  }

  @Override
  public void clickAndWaitForScreen( Screen screen )
  {
    waitAndGetWebElement().click();
    screen.validateScreen();
  }
}
