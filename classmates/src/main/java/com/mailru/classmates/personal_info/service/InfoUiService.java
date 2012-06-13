package com.mailru.classmates.personal_info.service;

import com.mailru.classmates.common.service.UiServiceBase;
import com.mailru.classmates.personal_info.object.IncorrectInfo;
import com.mailru.classmates.personal_info.object.Info;
import com.mailru.classmates.personal_info.screen.InfoEditScreen;
import com.mailru.classmates.personal_info.screen.InfoViewScreen;
import com.mailru.classmates.session.object.Session;

public class InfoUiService extends UiServiceBase implements InfoUiServiceInProxy
{
  public InfoUiService( Session session )
  {
    super( session );
  }

  @Override
  public void setInfo( Info info )
  {
    InfoEditScreen editInfoScreen = openSession().openPersonalInfo().edit();
    InfoViewScreen infoScreen =
      editInfoScreen.fillPersonalInfo( info.getFirstName(), info.getLastName(), info.getBirthDate(), info.getGender(),
        info.getLivePlace(), info.getBirthPlace() ).saveInfo();
    closeSession( infoScreen );
  }

  @Override
  public boolean fillIncorrectInfoSubmitAndCancel( Info info, IncorrectInfo incorrectInfo )
  {
    InfoEditScreen editInfoScreen = openSession().openPersonalInfo().edit();
    InfoEditScreen editInfoScreenUpdated =
      editInfoScreen.fillPersonalInfo( info.getFirstName(), info.getLastName(), info.getBirthDate(), info.getGender(),
        info.getLivePlace(), info.getBirthPlace() );
    InfoEditScreen personalInfoWithError = editInfoScreenUpdated.saveInfoWithError();
    boolean result = personalInfoWithError.checkInfoErrors( incorrectInfo );
    closeSession( personalInfoWithError );
    return result;
  }

  @Override
  public Info getInfo()
  {
    InfoEditScreen editInfoScreen = openSession().openPersonalInfo().edit();
    Info info =
      new Info( editInfoScreen.getFirstName(), editInfoScreen.getLastName(), editInfoScreen.getBirthDate(),
        editInfoScreen.getGender(), editInfoScreen.getLivePlace(), editInfoScreen.getBirthPlace() );
    closeSession( editInfoScreen );
    return info;
  }
}
