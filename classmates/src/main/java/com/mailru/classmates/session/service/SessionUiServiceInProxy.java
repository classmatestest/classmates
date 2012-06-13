package com.mailru.classmates.session.service;

/**
 * TODO Should be eliminated after Guice or some another AOP solution implemented
 */
public interface SessionUiServiceInProxy
{
  /**
   * True if user from session can login correctly
   * 
   * @return
   */
  public abstract boolean isSessionPrepared();
}