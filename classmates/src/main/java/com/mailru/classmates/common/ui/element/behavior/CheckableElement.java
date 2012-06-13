package com.mailru.classmates.common.ui.element.behavior;

/**
 * Behaviors of element, which can be disabled or enabled, like checkboxes, radiobuttons, etc.
 */
public interface CheckableElement
{
  public abstract void set( boolean status );

  public abstract void enable();

  public abstract void disable();

  public abstract boolean isChecked();
}
