package com.example.controller;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class TitleController {

    @GetMapping("/titleOfWork")
    public String titleOfWork() throws IOException {
        //return "<h1>hello<h1>";
        return new String(Files.readAllBytes(Paths.get("src/main/resources/static/index.html")));
    }

}
