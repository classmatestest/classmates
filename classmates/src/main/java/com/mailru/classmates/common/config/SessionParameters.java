package com.mailru.classmates.common.config;

public class SessionParameters
{
  /**
   * Singleton with session URL
   */
  private final static SessionParameters instance;

  static
  {
    instance = new SessionParameters();
  }

  public final static SessionParameters getInstance()
  {
    return instance;
  }

  private String url;

  public String getUrl()
  {
    return url;
  }

  public void setUrl( String url )
  {
    this.url = url;
  }
}
