package com.example.esportsmanagement.web.controller.match;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
public class MatchController {
    @GetMapping("/find")
    public String find(){
        return "/find";
    }

    @PostMapping("/find")
    public String findResults(
            @RequestParam("match_id") String match_id,
            @RequestParam("region") String region
            ) throws Exception {
        try {
            ProcessBuilder pb = new ProcessBuilder("src\\main\\Python\\venv\\Scripts\\python",
                    "src\\main\\Python\\FetchApiData\\riotAPI.py", region, match_id
            );
            Process p = pb.start();
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            while ((line = errorReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("All went well");
        } catch (Exception e) {
            System.out.println(e);
        }


        return "/find";
    }
}
