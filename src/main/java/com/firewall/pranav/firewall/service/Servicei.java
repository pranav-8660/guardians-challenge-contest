package com.firewall.pranav.firewall.service;


import com.firewall.pranav.firewall.proxy.AwsProxy;
import com.firewall.pranav.firewall.proxy.MongoProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class Servicei {



    private final AwsProxy awsProxy;


    @Autowired(required = true)
    private MongoProxy mongoProxy;

    public Servicei(AwsProxy awsProxy) {
        this.awsProxy = awsProxy;
    }

    public String addFile(MultipartFile file){
        return awsProxy.addFile(file);
    }

    public boolean validateFile(MultipartFile file){

        var fileSize = file.getSize()/1024;
        var contentType = file.getContentType();

        if(fileSize>1500L){
            return false;
        }
        else{
            return true;
        }

    }

    public String doAll(MultipartFile file,String user){

        if(validateFile(file)){
            if(file.getOriginalFilename().endsWith(".mp4"))
                return mongoProxy.addDataIntoMongoDB(user,addFile(file));
            return "Not a video";
        }
        return "Failure";

    }



}
