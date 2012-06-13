package com.mailru.classmates.common.ui.element.behavior;

/**
 * Behavior of elements, which allow conversion of some text value to value on screen.
 */
public interface TypeWriteElement extends ContentElement
{
  public abstract void typeWrite( String value );
}
