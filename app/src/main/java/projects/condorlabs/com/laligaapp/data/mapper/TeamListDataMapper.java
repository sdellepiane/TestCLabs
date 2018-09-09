package projects.condorlabs.com.laligaapp.data.mapper;

import java.util.ArrayList;
import java.util.List;

import projects.condorlabs.com.laligaapp.Constants;
import projects.condorlabs.com.laligaapp.data.entity.TeamEntity;
import projects.condorlabs.com.laligaapp.domain.model.TeamModel;

public class TeamListDataMapper {

    public List<TeamModel> transformTeamList(List<TeamEntity> teamEntityList){
        List<TeamModel> teamModelList = new ArrayList<>();
        if(teamEntityList != null && teamEntityList.size() > 0){
            for(TeamEntity teamEntity : teamEntityList){
                teamModelList.add(transformTeamEntity(teamEntity));
            }
        }

        return teamModelList;
    }

    private TeamModel transformTeamEntity(TeamEntity teamEntity){
        TeamModel teamModel = null;
        if(teamEntity != null){
            teamModel = new TeamModel();
            teamModel.setIdTeam(teamEntity.getIdTeam());
            teamModel.setIdSoccerXML(teamEntity.getIdSoccerXML());
            teamModel.setLoved(teamEntity.getIntLoved());
            teamModel.setTeamName(teamEntity.getStrTeam() != null ? teamEntity.getStrTeam() : Constants.EMPTY_STRING);
            teamModel.setTeamShortName(teamEntity.getStrTeamShort() != null ? teamEntity.getStrTeamShort() : Constants.EMPTY_STRING);
            teamModel.setAlternateName(teamEntity.getStrAlternate() != null ? teamEntity.getStrAlternate() : Constants.EMPTY_STRING);
            teamModel.setFormedYear(teamEntity.getIntFormedYear());
            teamModel.setSportName(teamEntity.getStrSport() != null ? teamEntity.getStrSport() : Constants.EMPTY_STRING);
            teamModel.setLeagueName(teamEntity.getStrLeague() != null ? teamEntity.getStrLeague() : Constants.EMPTY_STRING);
            teamModel.setIdLeague(teamEntity.getIdLeague());
            teamModel.setDivisionName(teamEntity.getStrDivision() != null ? teamEntity.getStrDivision() : Constants.EMPTY_STRING);
            teamModel.setManagerName(teamEntity.getStrManager() != null ? teamEntity.getStrManager() : Constants.EMPTY_STRING);
            teamModel.setStadiumName(teamEntity.getStrStadium() != null ? teamEntity.getStrStadium() : Constants.EMPTY_STRING);
            teamModel.setKeywords(teamEntity.getStrKeywords() != null ? teamEntity.getStrKeywords() : Constants.EMPTY_STRING);
            teamModel.setRss(teamEntity.getStrRSS() != null ? teamEntity.getStrRSS() : Constants.EMPTY_STRING);
            teamModel.setStadiumThumb(teamEntity.getStrStadiumThumb() != null ? teamEntity.getStrStadiumThumb() : Constants.EMPTY_STRING);
            teamModel.setStadiumDescription(teamEntity.getStrStadiumDescription() != null ? teamEntity.getStrStadiumDescription() : Constants.EMPTY_STRING);
            teamModel.setStadiumLocation(teamEntity.getStrStadiumLocation() != null ? teamEntity.getStrStadiumLocation() : Constants.EMPTY_STRING);
            teamModel.setStadiumCapacity(teamEntity.getIntStadiumCapacity());
            teamModel.setWebsite(teamEntity.getStrWebsite() != null ? teamEntity.getStrWebsite() : Constants.EMPTY_STRING);
            teamModel.setFacebook(teamEntity.getStrFacebook() != null ? teamEntity.getStrFacebook() : Constants.EMPTY_STRING);
            teamModel.setTwitter(teamEntity.getStrTwitter() != null ? teamEntity.getStrTwitter() : Constants.EMPTY_STRING);
            teamModel.setInstagram(teamEntity.getStrInstagram() != null ? teamEntity.getStrInstagram() : Constants.EMPTY_STRING);
            teamModel.setEnglishDescription(teamEntity.getStrDescriptionEN() != null ? teamEntity.getStrDescriptionEN() : Constants.EMPTY_STRING);
            teamModel.setDeutchlandDescription(teamEntity.getStrDescriptionDE() != null ? teamEntity.getStrDescriptionDE() : Constants.EMPTY_STRING);
            teamModel.setFrenchDescription(teamEntity.getStrDescriptionFR() != null ? teamEntity.getStrDescriptionFR() : Constants.EMPTY_STRING);
            teamModel.setDescriptionCN(teamEntity.getStrDescriptionCN() != null ? teamEntity.getStrDescriptionCN() : Constants.EMPTY_STRING);
            teamModel.setItalianDescription(teamEntity.getStrDescriptionIT() != null ? teamEntity.getStrDescriptionIT() : Constants.EMPTY_STRING);
            teamModel.setDescriptionJP(teamEntity.getStrDescriptionJP() != null ? teamEntity.getStrDescriptionJP() : Constants.EMPTY_STRING);
            teamModel.setDescriptionRU(teamEntity.getStrDescriptionRU() != null ? teamEntity.getStrDescriptionRU() : Constants.EMPTY_STRING);
            teamModel.setDescriptionES(teamEntity.getStrDescriptionES() != null ? teamEntity.getStrDescriptionES() : Constants.EMPTY_STRING);
            teamModel.setDescriptionPT(teamEntity.getStrDescriptionPT() != null ? teamEntity.getStrDescriptionPT() : Constants.EMPTY_STRING);
            teamModel.setDescriptionSE(teamEntity.getStrDescriptionSE() != null ? teamEntity.getStrDescriptionSE() : Constants.EMPTY_STRING);
            teamModel.setDescriptionNL(teamEntity.getStrDescriptionNL() != null ? teamEntity.getStrDescriptionNL() : Constants.EMPTY_STRING);
            teamModel.setDescriptionHU(teamEntity.getStrDescriptionHU() != null ? teamEntity.getStrDescriptionHU() : Constants.EMPTY_STRING);
            teamModel.setDescriptionNO(teamEntity.getStrDescriptionNO() != null ? teamEntity.getStrDescriptionNO() : Constants.EMPTY_STRING);
            teamModel.setDescriptionIL(teamEntity.getStrDescriptionIL() != null ? teamEntity.getStrDescriptionIL() : Constants.EMPTY_STRING);
            teamModel.setDescriptionPL(teamEntity.getStrDescriptionPL() != null ? teamEntity.getStrDescriptionPL() : Constants.EMPTY_STRING);
            teamModel.setGender(teamEntity.getStrGender() != null ? teamEntity.getStrGender() : Constants.EMPTY_STRING);
            teamModel.setCountry(teamEntity.getStrCountry() != null ? teamEntity.getStrCountry() : Constants.EMPTY_STRING);
            teamModel.setTeamBadge(teamEntity.getStrTeamBadge() != null ? teamEntity.getStrTeamBadge() : Constants.EMPTY_STRING);
            teamModel.setTeamJersey(teamEntity.getStrTeamJersey() != null ? teamEntity.getStrTeamJersey() : Constants.EMPTY_STRING);
            teamModel.setTeamLogo(teamEntity.getStrTeamLogo() != null ? teamEntity.getStrTeamLogo() : Constants.EMPTY_STRING);
            teamModel.setTeamFanart1(teamEntity.getStrTeamFanart1() != null ? teamEntity.getStrTeamFanart1() : Constants.EMPTY_STRING);
            teamModel.setTeamFanart2(teamEntity.getStrTeamFanart2() != null ? teamEntity.getStrTeamFanart2() : Constants.EMPTY_STRING);
            teamModel.setTeamFanart3(teamEntity.getStrTeamFanart3() != null ? teamEntity.getStrTeamFanart3() : Constants.EMPTY_STRING);
            teamModel.setTeamFanart4(teamEntity.getStrTeamFanart4() != null ? teamEntity.getStrTeamFanart4() : Constants.EMPTY_STRING);
            teamModel.setTeamBanner(teamEntity.getStrTeamBanner() != null ? teamEntity.getStrTeamBanner() : Constants.EMPTY_STRING);
            teamModel.setYoutube(teamEntity.getStrYoutube() != null ? teamEntity.getStrYoutube() : Constants.EMPTY_STRING);
            teamModel.setLocked(teamEntity.getStrLocked() != null ? teamEntity.getStrLocked() : Constants.EMPTY_STRING);
        }
        return teamModel;
    }
}
