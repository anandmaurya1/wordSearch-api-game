package io.javabrains.wordSearchapi.controller;

import io.javabrains.wordSearchapi.services.WordGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController("/")
public class WordSearchController {
    @Autowired
    WordGridService wordGridService;
    @GetMapping("/wordgrid")
    public String createWordGrid(@RequestParam int gridSize, @RequestParam  String wordList){

        List<String>  words=Arrays.asList(wordList.split(","));

         char[][] grid=wordGridService.generateGrid(gridSize,words);
         String gridToStrig="";
        for(int i=0;i<gridSize;i++) {
            for (int j = 0; j < gridSize; j++) {
                gridToStrig += grid[i][j] + " ";
            }
            gridToStrig += "\r\n";
        }
        return gridToStrig;
    }
}
