package com.example.esportsmanagement;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteries;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMastery;
import com.merakianalytics.orianna.types.core.searchable.SearchableList;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public class GetChampionMasteries {
    public static void main(final String[] args) {
        // Name: FatalElement
        // ID: 22508641
        // Account ID: 36321079

        Orianna.setRiotAPIKey("RGAPI-efdd8a66-8bee-4003-8bfe-442fb2048450");
        Orianna.setDefaultRegion(Region.EUROPE_NORTH_EAST);

        final Summoner summoner = Summoner.named("Ego the 1st").withRegion(Region.EUROPE_NORTH_EAST).get();
        final Champion shen = Champion.named("Shen").withRegion(Region.EUROPE_NORTH_EAST).get();
        final ChampionMastery cm = summoner.getChampionMastery(shen);
        System.out.println("Champion ID: " + cm.getChampion().getId());
        System.out.println("Mastery points: " + cm.getPoints());
        System.out.println("Mastery level: " + cm.getLevel());
        System.out.println("Points until next level: " + cm.getPointsUntilNextLevel());

        final ChampionMasteries cms = summoner.getChampionMasteries();
        System.out.println(cms.get(3).getPoints());
        System.out.println(cms.find(shen.getName()).getPoints());

        System.out.println(summoner.getName() + " has mastery level 6 or higher on:");
        final SearchableList<ChampionMastery> pro = cms.filter((final ChampionMastery mastery) -> mastery.getLevel() >= 6);
        for(final ChampionMastery mastery : pro) {
            System.out.println(mastery.getChampion().getName());
        }
    }
}