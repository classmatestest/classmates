package com.mailru.classmates.common.ui.screen;

/**
 * Any edit screen, which can close edit popup
 */
public interface EditScreen extends Screen
{
  /**
   * TODO Should check cancel cross in right-upper corner in shared edit class in future
   * 
   * @return
   */
  public abstract ViewScreen close();
}