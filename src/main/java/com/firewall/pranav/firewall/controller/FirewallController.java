package com.firewall.pranav.firewall.controller;

import com.firewall.pranav.firewall.service.Servicei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
public class FirewallController {


    @Autowired(required = true)
    private Servicei service;

    @GetMapping("/acceptFile/")
    public boolean getfileAttributes(@RequestParam("file")MultipartFile multipartFile,String username){
        return service.validateFile(multipartFile);
    }

    // http://localhost:8095/useraddfile/{user}
    @GetMapping("useraddfile/{user}")
    public String doAll(@RequestParam("file") MultipartFile file, @PathVariable String user){

        return service.doAll(file,user);
    }







}
