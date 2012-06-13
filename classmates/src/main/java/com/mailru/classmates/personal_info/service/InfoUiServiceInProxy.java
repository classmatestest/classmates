package com.mailru.classmates.personal_info.service;

import com.mailru.classmates.personal_info.object.IncorrectInfo;
import com.mailru.classmates.personal_info.object.Info;

/**
 * TODO Should be eliminated after Guice or some another AOP solution implemented
 */
public interface InfoUiServiceInProxy
{
  /**
   * Set personal info for user from session
   * 
   * @param info
   */
  public abstract void setInfo( Info info );

  /**
   * Try to set incorrect personal info for user and check errors according strategy
   * 
   * @param info
   * @param incorrectInfo
   * @return
   */
  public abstract boolean fillIncorrectInfoSubmitAndCancel( Info info, IncorrectInfo incorrectInfo );

  /**
   * Get personal info for user from session
   * 
   * @return
   */
  public abstract Info getInfo();
}