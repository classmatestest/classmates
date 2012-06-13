package com.mailru.classmates.common.ui.element.css_wrapper;

/**
 * Wrapper of CSS selector for most part of links
 */
public class LinkWithHrefattrsSuffixCssWrapper implements CssWrapper
{
  private static final String LINK_WITH_HREFATTRS_SUFFIX = "a[hrefattrs$=%s]";

  @Override
  public String wrapToCssSelector( String hrefattrsSuffix )
  {
    return String.format( LINK_WITH_HREFATTRS_SUFFIX, hrefattrsSuffix );
  }
}
