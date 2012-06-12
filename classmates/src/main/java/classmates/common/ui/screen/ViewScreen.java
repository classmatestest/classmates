package classmates.common.ui.screen;

import classmates.session.screen.LoginScreen;

/**
 * Any view screen, with clickable logout link
 */
public interface ViewScreen extends Screen
{
  public abstract LoginScreen logout();
}