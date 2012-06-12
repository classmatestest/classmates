package classmates.personal_info.factory;

import java.util.Calendar;
import java.util.GregorianCalendar;

import classmates.personal_info.object.BirthDate;
import classmates.personal_info.object.Gender;
import classmates.personal_info.object.Info;


/**
 * Factory for different types of personal info
 * TODO rewrite to get data from file or some persistence objects for correct support of data driven testing 
 */
public class InfoFactory
{
  public Info getDefaultPersonalInfo()
  {
    Calendar birthDate = new GregorianCalendar();
    birthDate.set( 1981, Calendar.JANUARY, 1 );
    return new Info( "Вася", "Петров", new BirthDate( birthDate ), Gender.MALE, "пгт. Прибрежный (г. Самара), Россия",
      "Екатеринбург, Россия" );
  }

  public Info getCorrectPersonalInfo()
  {
    Calendar birthDate = new GregorianCalendar();
    birthDate.set( 1989, Calendar.DECEMBER, 31 );
    return new Info( "Лена", "Сидорова", new BirthDate( birthDate ), Gender.FEMALE, "Москва, Россия",
      "Баку, Азербайджан" );
  }

  public Info getNotValidPersonalInfo()
  {
    Calendar birthDate = new GregorianCalendar();
    birthDate.setLenient( false );
    birthDate.set( 2006, Calendar.FEBRUARY, 31 );
    return new Info( "<!-- -->", "$%^", new BirthDate( birthDate ), Gender.FEMALE, "123", "456" );
  }

  public Info getEmptyPersonalInfo()
  {
    return new Info( "", "", new BirthDate(), Gender.MALE, "", "" );
  }
}
