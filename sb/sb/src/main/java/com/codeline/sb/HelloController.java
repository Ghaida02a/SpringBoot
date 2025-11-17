package com.codeline.sb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam String name){
        if(name==null || name.isEmpty()){
            return "Hello Guest";
        }
        return "Hello " + name;
    }

    @GetMapping("/sum")
    public String sum(@RequestParam int a, @RequestParam int b){
        int sum = a + b;
        return "The sum of " + a + " and " + b + " is " + sum;
    }

    @GetMapping("/info")
    public Info getInfo() {
        return new Info("Ghaida", "Muscat", "Arabic");
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Greetings, " + name + "!";
    }

    @GetMapping("/upper")
    public String upper(@RequestParam String text) {
        return text.toUpperCase();
    }

    @GetMapping("/random")
    public String random() {
        int randomNum = (int)(Math.random() * 100) + 1;
        return "Random number: " + randomNum;
    }
}
