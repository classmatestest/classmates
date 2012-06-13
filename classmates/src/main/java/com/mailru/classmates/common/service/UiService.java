package com.mailru.classmates.common.service;

import com.mailru.classmates.session.screen.DashboardViewScreen;

public interface UiService
{
  public abstract DashboardViewScreen openSession();

  /**
   * Close browser without logout processing, needed for accident resolving
   * 
   */
  public abstract void closeSessionBrowser();
}