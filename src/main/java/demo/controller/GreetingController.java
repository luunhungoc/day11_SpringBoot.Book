package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController{
    @RequestMapping("/hello")
    public String greeting(@RequestParam(name="name") String name,
                           @RequestParam(name="country", required=false,defaultValue="Vietnam") String country){
        return "Hello " + name + " from " + country;}
}
