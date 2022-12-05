package com.example.esportsmanagement;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public class GetSummoner {
    public static void main(String[] args) {
        Orianna.setRiotAPIKey("RGAPI-efdd8a66-8bee-4003-8bfe-442fb2048450");
        Orianna.setDefaultRegion(Region.EUROPE_NORTH_EAST);

        final Summoner summoner = Summoner.named("Ego the 1st").withRegion(Region.EUROPE_NORTH_EAST).get();
        System.out.println("Name: " + summoner.getName());
        System.out.println("ID: " + summoner.getId());
        System.out.println("Account ID: " + summoner.getAccountId());
        System.out.println("Level: " + summoner.getLevel());
        System.out.println("Last Updated: " + summoner.getUpdated());
        System.out.println("Profile Icon ID: " + summoner.getProfileIcon().getId());
        System.out.println("Profile Icon URL: " + summoner.getProfileIcon().getImage().getURL());
    }
}
