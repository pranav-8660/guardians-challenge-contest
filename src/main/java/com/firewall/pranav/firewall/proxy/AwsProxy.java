package com.firewall.pranav.firewall.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "aws-s3-driver")
public interface AwsProxy {

    @GetMapping("addfile/")
    public String addFile(@RequestParam("dummyfile") MultipartFile mfile);
}
