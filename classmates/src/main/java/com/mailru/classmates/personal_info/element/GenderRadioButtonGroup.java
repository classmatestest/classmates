package com.mailru.classmates.personal_info.element;


import org.openqa.selenium.WebDriver;

import com.mailru.classmates.common.ui.element.RadioButtonElement;
import com.mailru.classmates.personal_info.object.Gender;


/**
 * Two radiobuttons for gender selection
 */
public class GenderRadioButtonGroup
{
  private WebDriver webDriver;

  private RadioButtonElement male;

  private RadioButtonElement female;

  public GenderRadioButtonGroup( WebDriver webDriver )
  {
    setDriver( webDriver );
    setMale( new RadioButtonElement( getDriver(), "field_gender_1" ) );
    setFemale( new RadioButtonElement( getDriver(), "field_gender_2" ) );
  }

  private RadioButtonElement getMale()
  {
    return male;
  }

  private void setMale( RadioButtonElement male )
  {
    this.male = male;
  }

  private RadioButtonElement getFemale()
  {
    return female;
  }

  private void setFemale( RadioButtonElement female )
  {
    this.female = female;
  }

  private WebDriver getDriver()
  {
    return webDriver;
  }

  private void setDriver( WebDriver webDriver )
  {
    this.webDriver = webDriver;
  }

  public void setGender( Gender gender )
  {
    if( gender.equals( Gender.MALE ) && !getMale().isChecked() )
    {
      getMale().enable();
    }
    else if( gender.equals( Gender.FEMALE ) && !getFemale().isChecked() )
    {
      getFemale().enable();
    }
  }

  public Gender getGender()
  {
    if( getMale().isChecked() )
    {
      return Gender.MALE;
    }
    else
    {
      return Gender.FEMALE;
    }
  }
}
