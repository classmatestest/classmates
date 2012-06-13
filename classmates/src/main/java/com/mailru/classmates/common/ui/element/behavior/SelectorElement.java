package com.mailru.classmates.common.ui.element.behavior;

/**
 * Behavior of elements, which provide selection from list possibility, like dropdown selectors
 */
public interface SelectorElement extends ContentElement
{
  public abstract void selectByValue( String value );

  public abstract void selectByIndex( int index );
}
