package com.mailru.classmates.personal_info.element;

import java.util.Calendar;
import java.util.GregorianCalendar;


import org.openqa.selenium.WebDriver;

import com.mailru.classmates.common.ui.element.SelectElement;
import com.mailru.classmates.personal_info.object.BirthDate;


/**
 * Three dropdown lists for date selection
 */
public class BirthDateSelectGroup
{
  private WebDriver webDriver;

  SelectElement birthDaySelect;

  SelectElement birthMonthSelect;

  SelectElement birthYearSelect;

  public BirthDateSelectGroup( WebDriver webDriver )
  {
    setDriver( webDriver );

    setBirthDaySelect( new SelectElement( getDriver(), "field_bday" ) );

    setBirthMonthSelect( new SelectElement( getDriver(), "field_bmonth" ) );

    setBirthYearSelect( new SelectElement( getDriver(), "field_byear" ) );
  }

  private WebDriver getDriver()
  {
    return webDriver;
  }

  private void setDriver( WebDriver webDriver )
  {
    this.webDriver = webDriver;
  }

  private SelectElement getBirthDaySelect()
  {
    return birthDaySelect;
  }

  private void setBirthDaySelect( SelectElement birthDaySelect )
  {
    this.birthDaySelect = birthDaySelect;
  }

  private SelectElement getBirthMonthSelect()
  {
    return birthMonthSelect;
  }

  private void setBirthMonthSelect( SelectElement birthMonthSelect )
  {
    this.birthMonthSelect = birthMonthSelect;
  }

  private SelectElement getBirthYearSelect()
  {
    return birthYearSelect;
  }

  private void setBirthYearSelect( SelectElement birthYearSelect )
  {
    this.birthYearSelect = birthYearSelect;
  }

  /**
   * TODO Some magic here, need more time for not ugly solution
   * 
   * @param birthDate
   */
  public void setBirthDate( BirthDate birthDate )
  {
    if( birthDate.isEmpty() )
    {
      getBirthDaySelect().selectByIndex( 0 );
      getBirthMonthSelect().selectByIndex( 0 );
      getBirthYearSelect().selectByIndex( 0 );
    }
    else
    {
      try
      {
        getBirthDaySelect().selectByValue(
          String.valueOf( birthDate.getBirthDateCalendar().get( Calendar.DAY_OF_MONTH ) ) );
        getBirthMonthSelect().selectByValue(
          String.valueOf( birthDate.getBirthDateCalendar().get( Calendar.MONTH ) + 1 ) );
        getBirthYearSelect().selectByValue( String.valueOf( birthDate.getBirthDateCalendar().get( Calendar.YEAR ) ) );
      }
      catch( IllegalArgumentException e )
      {
        getBirthDaySelect().selectByValue( "31" );
        getBirthMonthSelect().selectByValue( "2" );
        getBirthYearSelect().selectByValue( "2006" );
      }
    }
  }

  /**
   * TODO Some magic here, need more time for not ugly solution
   * 
   * @param birthDate
   */
  public BirthDate getBirthDate()
  {
    int birthDay;
    int birthMonth;
    int birthYear;

    try
    {
      birthDay = Integer.parseInt( getBirthDaySelect().getContent() );
      birthMonth = Integer.parseInt( getBirthMonthSelect().getContent() );
      birthYear = Integer.parseInt( getBirthYearSelect().getContent() );
    }
    catch( NumberFormatException e )
    {
      return new BirthDate();
    }

    Calendar birthDate = new GregorianCalendar();
    birthDate.set( birthYear, birthMonth - 1, birthDay );
    return new BirthDate( birthDate );
  }
}
