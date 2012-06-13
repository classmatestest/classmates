package com.mailru.classmates.common.ui.element.behavior;

import com.mailru.classmates.common.ui.screen.Screen;

/**
 * Behavior of elements like Buttons, Links etc, which return new screen after click
 */
public interface ClickableElement
{
  /**
   * Click on element and wait of Some screen validation
   * 
   * @param screen
   */
  public abstract void clickAndWaitForScreen( Screen screen );
}
