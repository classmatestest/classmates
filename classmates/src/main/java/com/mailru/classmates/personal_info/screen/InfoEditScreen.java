package com.mailru.classmates.personal_info.screen;


import org.openqa.selenium.WebDriver;

import com.mailru.classmates.common.ui.element.ButtonElement;
import com.mailru.classmates.common.ui.element.InputElement;
import com.mailru.classmates.common.ui.element.LinkElement;
import com.mailru.classmates.common.ui.element.SuggestElement;
import com.mailru.classmates.common.ui.element.css_wrapper.CssWrapperSelector;
import com.mailru.classmates.common.ui.screen.EditScreen;
import com.mailru.classmates.common.ui.screen.EditScreenBase;
import com.mailru.classmates.common.ui.screen.ViewScreen;
import com.mailru.classmates.personal_info.element.BirthDateSelectGroup;
import com.mailru.classmates.personal_info.element.GenderRadioButtonGroup;
import com.mailru.classmates.personal_info.element.IncorrectInfoErrorNoteGroup;
import com.mailru.classmates.personal_info.object.BirthDate;
import com.mailru.classmates.personal_info.object.Gender;
import com.mailru.classmates.personal_info.object.IncorrectInfo;


/**
 * Screen with popup for edit user personal info
 */
public class InfoEditScreen extends EditScreenBase implements EditScreen
{
  public InfoEditScreen( WebDriver webDriver )
  {
    super( webDriver );
  }

  ButtonElement saveButton = new ButtonElement( getDriver(), "hook_FormButton_button_savePopLayerEditUserProfileNew" );

  ButtonElement confirmButton = new ButtonElement( getDriver(), "buttonId_button_close" );

  LinkElement cancelLink = new LinkElement( getDriver(), CssWrapperSelector.LINK_FROM_CONTAINER_WITH_CLASS,
    "formButtonContainer" );

  InputElement firstNameInput = new InputElement( getDriver(), "field_name" );

  InputElement lastNameInput = new InputElement( getDriver(), "field_surname" );

  BirthDateSelectGroup birthDateSelectGroup = new BirthDateSelectGroup( getDriver() );

  GenderRadioButtonGroup genderRadioButtonGroup = new GenderRadioButtonGroup( getDriver() );

  InputElement livePlaceInput = new InputElement( getDriver(), "field_suggcity" );

  InputElement birthPlaceInput = new InputElement( getDriver(), "field_suggbcity" );

  private static final String DIV_PLACE_SUGGEST_CLASS = "sug_it_txt-div";

  SuggestElement livePlaceSuggest = new SuggestElement( getDriver(), DIV_PLACE_SUGGEST_CLASS );

  SuggestElement birthPlaceSuggest = new SuggestElement( getDriver(), DIV_PLACE_SUGGEST_CLASS );

  IncorrectInfoErrorNoteGroup incorrectInfoErrorNoteGroup = new IncorrectInfoErrorNoteGroup( getDriver() );

  /**
   * TODO Type to inputs with suggest from down to up in first, for exclude suggest over submit and cancel buttons and
   * themselves. Should be found nicely solution
   * 
   * @param firstName
   * @param lastName
   * @param birthDate
   * @param gender
   * @param livePlace
   * @param birthPlace
   * @return
   */
  public InfoEditScreen fillPersonalInfo( String firstName, String lastName, BirthDate birthDate, Gender gender,
    String livePlace, String birthPlace )
  {

    birthPlaceInput.typeWrite( birthPlace );
    birthPlaceSuggest.typeWrite( birthPlace );
    livePlaceInput.typeWrite( livePlace );
    livePlaceSuggest.typeWrite( livePlace );

    firstNameInput.typeWrite( firstName );
    lastNameInput.typeWrite( lastName );

    birthDateSelectGroup.setBirthDate( birthDate );

    genderRadioButtonGroup.setGender( gender );

    return new InfoEditScreen( getDriver() );
  }

  public String getFirstName()
  {
    return firstNameInput.getContent();
  }

  public String getLastName()
  {
    return lastNameInput.getContent();
  }

  public BirthDate getBirthDate()
  {
    return birthDateSelectGroup.getBirthDate();
  }

  public Gender getGender()
  {
    return genderRadioButtonGroup.getGender();
  }

  public String getLivePlace()
  {
    return livePlaceInput.getContent();
  }

  public String getBirthPlace()
  {
    return birthPlaceInput.getContent();
  }

  /**
   * This save method use, then we fill valid personal info
   *
   * @return
   */
  public InfoViewScreen saveInfo()
  {
    saveButton.clickAndWaitForScreen( new InfoViewScreen( getDriver() ) );
    confirmButton.clickAndWaitForScreen( new InfoViewScreen( getDriver() ) );
    return new InfoViewScreen( getDriver() );
  }

  /**
   * This save method use, then we fill incorrect personal info
   *
   * @return
   */
  public InfoEditScreen saveInfoWithError()
  {
    saveButton.clickAndWaitForScreen( new InfoEditScreen( getDriver() ) );
    return new InfoEditScreen( getDriver() );
  }

  /**
   * Check error notes according selected incorrect fill strategy
   *
   * @param incorrectInfo
   * @return
   */
  public boolean checkInfoErrors( IncorrectInfo incorrectInfo )
  {
    return incorrectInfoErrorNoteGroup.isIncorrectInfoErrorsCorrect( incorrectInfo );
  }

  public ViewScreen cancelInfo()
  {
    return close();
  }

  @Override
  public ViewScreen close()
  {
    cancelLink.clickAndWaitForScreen( new InfoViewScreen( getDriver() ) );
    return new InfoViewScreen( getDriver() );
  }
}
