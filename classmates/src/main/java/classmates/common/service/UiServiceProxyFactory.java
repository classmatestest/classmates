package classmates.common.service;

import static classmates.common.log.SystemOutputLogger.log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

import classmates.common.service.UiService;

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
      StringBuffer message = new StringBuffer();
      message.append( "------> " );
      message.append( method.getName() );
      message.append( "(" );
      for( int i = 0; args != null && i < args.length; i++ )
      {
        if( i != 0 )
          message.append( ", " );
        message.append( args[i] );
      }
      message.append( ")" );
      Object returnValue;
      try
      {
        returnValue = method.invoke( wrappedUiService, args );
      }
      catch( Exception e )
      {
        log().info( e.getMessage() );
        ( ( UiService ) wrappedUiService ).closeSessionBrowser();
        throw e;
      }
      if( returnValue != null )
      {
        message.append( " -> " );
        message.append( returnValue );
      }
      log().info( message );
      return returnValue;
    }
  }
}
