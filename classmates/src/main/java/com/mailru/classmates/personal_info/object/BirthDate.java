package com.mailru.classmates.personal_info.object;

import java.util.Calendar;

/**
 * Class for user birth date representation, contain some ugly magic, not safe, can return null calendar for empty
 * element 
 * TODO rewrite after find nicely solution
 */
public class BirthDate
{
  private Calendar birthDateCalendar;

  private boolean isEmpty;

  public BirthDate( Calendar birthDate )
  {
    setBirthDateCalendar( birthDate );
    setEmpty( false );
  }

  public BirthDate()
  {
    setEmpty( true );
  }

  /**
   * BE CAREFUL!!! Can be null, check for empty before
   * 
   * @return
   */
  public Calendar getBirthDateCalendar()
  {
    return birthDateCalendar;
  }

  private void setBirthDateCalendar( Calendar birthDateCalendar )
  {
    this.birthDateCalendar = birthDateCalendar;
  }

  public boolean isEmpty()
  {
    return isEmpty;
  }

  private void setEmpty( boolean isEmpty )
  {
    this.isEmpty = isEmpty;
  }

  @Override
  public boolean equals( Object obj )
  {
    BirthDate comparingBirthDate = ( BirthDate ) obj;
    if( isEmpty() && comparingBirthDate.isEmpty() )
    {
      return true;
    }
    else if( isEmpty() || comparingBirthDate.isEmpty() )
    {
      return false;
    }
    return ( getBirthDateCalendar().get( Calendar.DAY_OF_MONTH ) == comparingBirthDate.getBirthDateCalendar().get(
      Calendar.DAY_OF_MONTH )
      && getBirthDateCalendar().get( Calendar.MONTH ) == comparingBirthDate.getBirthDateCalendar().get( Calendar.MONTH ) && getBirthDateCalendar()
      .get( Calendar.YEAR ) == comparingBirthDate.getBirthDateCalendar().get( Calendar.YEAR ) );
  }

  @Override
  public String toString()
  {
    if( isEmpty() )
    {
      return "День/Месяц/Год";
    }
    try
    {
      return String.valueOf( getBirthDateCalendar().get( Calendar.DAY_OF_MONTH ) ) + "/"
        + String.valueOf( getBirthDateCalendar().get( Calendar.MONTH ) + 1 ) + "/"
        + String.valueOf( getBirthDateCalendar().get( Calendar.YEAR ) );
    }
    catch( IllegalArgumentException e )
    {
      return "31/02/2006";
    }

  }
}
