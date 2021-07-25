package com.geek.battle;

import com.geek.battle.service.WarService;
import com.geek.battle.service.WarServiceImpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class War {
    public static void main(String[] args) {
        String inputFile = null;
        try {
            inputFile = args[0];
            List<String> armoury;
            armoury = Files.readAllLines(Paths.get(inputFile),
                    StandardCharsets.UTF_8);
            // Split the line on basis of Space Char
            armoury= Arrays.asList(armoury.get(0).split(" "));
            WarService warService = new WarServiceImpl();
            System.out.println(warService.battle(armoury)) ;


        } catch (IOException e) {
            System.out.println(" Specified file " + inputFile + "  not found. Supply valid file location");
        }

    }
}
