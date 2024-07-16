package com.firewall.pranav.firewall.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="RecipeMongoDriver")
public interface MongoProxy {

    @GetMapping(value="add-data/{user}/{link}")
    public String addDataIntoMongoDB(@PathVariable("user") String user, @PathVariable("link") String link);
}
