package com.mailru.classmates.common.service;

import static com.mailru.classmates.common.log.SystemOutputLogger.log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

import com.mailru.classmates.common.service.UiService;


/**
 * Simple proxy through native reflection mechanism for automaticaly logging and browser closing support
 * Unsafe, not contain any type checking
 * TODO Should be eliminated after Guice or some another AOP solution implemented 
 */
public class UiServiceProxyFactory
{
  @SuppressWarnings( "unchecked" )
  public static <T> T getUiServiceProxy( Class<T> wrappedUiServiceClass, final T wrappedUiService )
  {
    return ( T ) Proxy.newProxyInstance( wrappedUiService.getClass().getClassLoader(),
      new Class[] {wrappedUiServiceClass}, new UiServiceInvocationHandler<T>( wrappedUiService )
      {
      } );
  }

  private static class UiServiceInvocationHandler<T> implements InvocationHandler
  {
    final T wrappedUiService;

    public UiServiceInvocationHandler( T underlying )
    {
      this.wrappedUiService = underlying;
    }

    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable
    {
      StringBuffer beforeMessage = new StringBuffer();
      beforeMessage.append( "------> " );
      beforeMessage.append( method.getName() );
      beforeMessage.append( "(" );
      for( int i = 0; args != null && i < args.length; i++ )
      {
        if( i != 0 )
          beforeMessage.append( ", " );
        beforeMessage.append( args[i] );
      }
      beforeMessage.append( ")" );
      log().info( beforeMessage );
      Object returnValue;
      try
      {
        returnValue = method.invoke( wrappedUiService, args );
      }
      catch( Exception e )
      {
        log().info( "----------------EXCEPTION----------------" );
        log().info( e.getMessage() );
        log().info( "----------------EXCEPTION----------------" );
        ( ( UiService ) wrappedUiService ).closeSessionBrowser();
        throw e;
      }
      StringBuffer afterMessage = new StringBuffer();
      afterMessage.append( "------------> " );
      if( returnValue != null )
      {
        afterMessage.append( returnValue );
      }
      else
      {
        afterMessage.append( " EXECUTED " );
      }
      log().info( afterMessage );
      return returnValue;
    }
  }
}
