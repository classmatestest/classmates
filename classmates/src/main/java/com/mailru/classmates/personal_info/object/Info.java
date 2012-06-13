package com.mailru.classmates.personal_info.object;

/**
 * Class for personal info data representation
 * toString need for proxy logging
 */
public class Info
{
  private String firstName;

  private String lastName;

  private BirthDate birthDate;

  private Gender gender;

  private String livePlace;

  private String birthPlace;

  public Info( String firstName, String lastName, BirthDate date, Gender gender, String livePlace, String birthPlace )
  {
    setFirstName( firstName );
    setLastName( lastName );
    setBirthDate( date );
    setGender( gender );
    setLivePlace( livePlace );
    setBirthPlace( birthPlace );
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName( String firstName )
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName( String lastName )
  {
    this.lastName = lastName;
  }

  public BirthDate getBirthDate()
  {
    return birthDate;
  }

  private void setBirthDate( BirthDate birthDate )
  {
    this.birthDate = birthDate;
  }

  public Gender getGender()
  {
    return gender;
  }

  private void setGender( Gender gender )
  {
    this.gender = gender;
  }

  public String getLivePlace()
  {
    return livePlace;
  }

  public void setLivePlace( String livePlace )
  {
    this.livePlace = livePlace;
  }

  public String getBirthPlace()
  {
    return birthPlace;
  }

  public void setBirthPlace( String birthPlace )
  {
    this.birthPlace = birthPlace;
  }

  @Override
  public boolean equals( Object obj )
  {
    Info comparingInfo = ( Info ) obj;
    return ( getFirstName().equals( comparingInfo.getFirstName() )
      && getLastName().equals( comparingInfo.getLastName() ) && getBirthDate().equals( comparingInfo.getBirthDate() )
      && getGender().equals( comparingInfo.getGender() ) && getLivePlace().equals( comparingInfo.getLivePlace() ) && getBirthPlace()
      .equals( comparingInfo.getBirthPlace() ) );
  }

  @Override
  public String toString()
  {
    return getFirstName() + " " + getLastName() + ", " + getBirthDate() + ", " + getGender() + ", " + getLivePlace()
      + ", " + getBirthPlace();
  }
}
