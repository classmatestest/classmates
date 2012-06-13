package com.mailru.classmates.common.ui.screen;

import com.mailru.classmates.session.screen.LoginScreen;

/**
 * Any view screen, with clickable logout link
 */
public interface ViewScreen extends Screen
{
  public abstract LoginScreen logout();
}