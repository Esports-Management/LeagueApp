package com.example.esportsmanagement.user.jpa.data;

import com.example.esportsmanagement.web.controller.match.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class UpdateDatabaseWithMatches {

    private static final Logger logger = LogManager.getLogger("User Match ID and region Input");

    public static void updateDatabaseWithMatches(String region, String match_ids) throws Exception {

        logger.info(region, match_ids);

//
//        String[] regionArray = new String[] {"eun1", "euw1"};
//        boolean validRegion = Arrays.asList(regionArray)
//                .contains(region);
//
//        Pattern pattern = Pattern.compile(region + "_" + "\\d\\d\\d\\d\\d\\d\\d\\d\\d", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(match_ids);
//        boolean inputFormatCorrect = matcher.matches();
//
//        // add logging here


        try {

            ProcessBuilder pb = new ProcessBuilder(config.getConfig(),
                    "src\\main\\Python\\FetchApiData\\riotAPI.py", region, match_ids
            );
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            while ((line = errorReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            logger.error("Unable to fetch data through API", e);
            System.out.println(e);
        }


    }
}
