package com.conurets.inventory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.http.MediaType.ALL;
import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Dost M. Soomro on 4/2/2019.
 */
@RestController
public class ReportController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "E://dtemp//";

    @PostMapping(value ="/uploadf")
    public String report(@RequestParam("file") MultipartFile file){


        try {

            // Get the file and save it somewhere//@RequestParam("file") MultipartFile file
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);



        } catch (IOException e) {
            e.printStackTrace();
        }
        return "file saved";
    }
}
