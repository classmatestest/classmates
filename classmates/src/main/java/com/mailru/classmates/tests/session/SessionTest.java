package com.mailru.classmates.tests.session;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.mailru.classmates.common.service.UiServiceProxyFactory;
import com.mailru.classmates.session.factory.SessionFactory;
import com.mailru.classmates.session.service.SessionUiService;
import com.mailru.classmates.session.service.SessionUiServiceInProxy;
import com.mailru.classmates.tests.BaseTest;


public class SessionTest extends BaseTest
{
  private SessionFactory sessionFactory = new SessionFactory();

  /**
   * Very ugly
   * TODO Should be eliminated after Guice or some another AOP solution implemented
   */
  private SessionUiServiceInProxy sessionUiService = UiServiceProxyFactory.getUiServiceProxy( SessionUiServiceInProxy.class, new SessionUiService( sessionFactory.getDefaultSession() ) );

  @Test( enabled = true )
  public void testSuccesfullAuthorisation() throws Exception
  {
    assertTrue( sessionUiService.isSessionPrepared() );
  }
}
