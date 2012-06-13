package com.mailru.classmates.common.ui.element.css_wrapper;

/**
 * Wrapper of CSS selector for cancel link on edit screens
 */
public class LinkFromContainerWithClassCssWrapper implements CssWrapper
{
  private static final String LINK_FROM_CONTAINER_WITH_CLASS = "div.%s > span > a";

  @Override
  public String wrapToCssSelector( String className )
  {
    return String.format( LINK_FROM_CONTAINER_WITH_CLASS, className );
  }
}
