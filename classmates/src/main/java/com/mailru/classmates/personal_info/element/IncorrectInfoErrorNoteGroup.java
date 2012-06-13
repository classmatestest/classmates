package com.mailru.classmates.personal_info.element;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.mailru.classmates.common.ui.element.ErrorNoteElement;
import com.mailru.classmates.personal_info.object.IncorrectInfo;



/**
 * All error notes on screen
 */
public class IncorrectInfoErrorNoteGroup
{
  private WebDriver webDriver;

  ErrorNoteElement firstNameError;

  ErrorNoteElement lastNameError;

  ErrorNoteElement birthDateError;

  ErrorNoteElement genderError;

  ErrorNoteElement livePlaceError;

  ErrorNoteElement birthPlaceError;

  List<ErrorNoteElement> shownErrorNoteList;

  List<ErrorNoteElement> hidedErrorNoteList;

  public IncorrectInfoErrorNoteGroup( WebDriver webDriver )
  {
    setDriver( webDriver );
    setFirstNameError( new ErrorNoteElement( getDriver(), "input-e", 1 ) );

    setLastNameError( new ErrorNoteElement( getDriver(), "input-e", 2 ) );

    setBirthDateError( new ErrorNoteElement( getDriver(), "input-e", 3 ) );

    setGenderError( new ErrorNoteElement( getDriver(), "input-e", 4 ) );

    setLivePlaceError( new ErrorNoteElement( getDriver(), "input-e", 5 ) );

    setBirthPlaceError( new ErrorNoteElement( getDriver(), "input-e", 6 ) );

    setShownErrorNoteList( new ArrayList<ErrorNoteElement>() );

    setHidedErrorNoteList( new ArrayList<ErrorNoteElement>() );

    // this field always can have error
    shownErrorNoteList.add( getFirstNameError() );
    shownErrorNoteList.add( getLastNameError() );
    shownErrorNoteList.add( getBirthDateError() );
    shownErrorNoteList.add( getLivePlaceError() );

    // this field always can't have error
    hidedErrorNoteList.add( getGenderError() );
  }

  private WebDriver getDriver()
  {
    return webDriver;
  }

  private void setDriver( WebDriver webDriver )
  {
    this.webDriver = webDriver;
  }

  private ErrorNoteElement getFirstNameError()
  {
    return firstNameError;
  }

  private void setFirstNameError( ErrorNoteElement firstNameError )
  {
    this.firstNameError = firstNameError;
  }

  private ErrorNoteElement getLastNameError()
  {
    return lastNameError;
  }

  private void setLastNameError( ErrorNoteElement lastNameError )
  {
    this.lastNameError = lastNameError;
  }

  private ErrorNoteElement getBirthDateError()
  {
    return birthDateError;
  }

  private void setBirthDateError( ErrorNoteElement birthDateError )
  {
    this.birthDateError = birthDateError;
  }

  private ErrorNoteElement getGenderError()
  {
    return genderError;
  }

  private void setGenderError( ErrorNoteElement genderError )
  {
    this.genderError = genderError;
  }

  private ErrorNoteElement getLivePlaceError()
  {
    return livePlaceError;
  }

  private void setLivePlaceError( ErrorNoteElement livePlaceError )
  {
    this.livePlaceError = livePlaceError;
  }

  private ErrorNoteElement getBirthPlaceError()
  {
    return birthPlaceError;
  }

  private void setBirthPlaceError( ErrorNoteElement birthPlaceError )
  {
    this.birthPlaceError = birthPlaceError;
  }

  private List<ErrorNoteElement> getShownErrorNoteList()
  {
    return shownErrorNoteList;
  }

  private void setShownErrorNoteList( List<ErrorNoteElement> shownErrorNoteList )
  {
    this.shownErrorNoteList = shownErrorNoteList;
  }

  private List<ErrorNoteElement> getHidedErrorNoteList()
  {
    return hidedErrorNoteList;
  }

  private void setHidedErrorNoteList( List<ErrorNoteElement> hidedErrorNoteList )
  {
    this.hidedErrorNoteList = hidedErrorNoteList;
  }

  /**
   * Check or not check birth place error, dependency from incorrect info fill strategy. Birth place can be empty but
   * can't be not valid
   * 
   * @param incorrectInfo
   * @return
   */
  public boolean isIncorrectInfoErrorsCorrect( IncorrectInfo incorrectInfo )
  {
    if( incorrectInfo.equals( IncorrectInfo.EMPTY ) )
    {
      getHidedErrorNoteList().add( getBirthPlaceError() );
    }
    else if( incorrectInfo.equals( IncorrectInfo.NOT_VALID ) )
    {
      getShownErrorNoteList().add( getBirthPlaceError() );
    }

    boolean result = true;
    for( ErrorNoteElement shownErrorNote : getShownErrorNoteList() )
    {
      result = result && shownErrorNote.isErrorShown();
    }
    for( ErrorNoteElement hidedErrorNote : getHidedErrorNoteList() )
    {
      result = result && !hidedErrorNote.isErrorShown();
    }
    return result;
  }
}
