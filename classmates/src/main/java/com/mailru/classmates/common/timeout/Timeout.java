package com.mailru.classmates.common.timeout;

/**
 * Selenium timeouts enumeration
 */
public enum Timeout
{
  DEFAULT_ELEMENT_WAIT_TIMEOUT( 10 ), 
  DEFAULT_ELEMENT_DISPLAYED_WAIT_TIMEOUT( 5 ),
  DEFAULT_ELEMENT_ENABLED_WAIT_TIMEOUT( 5 ), 
  DEFAULT_SELENIUM_IMPLICIT_TIMEOUT( 5 );

  private final int timeoutValue;

  private Timeout( int timeoutValue )
  {
    this.timeoutValue = timeoutValue;
  }

  public int getTimeoutValue()
  {
    return timeoutValue;
  }
}
