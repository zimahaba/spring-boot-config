package edu.zimahaba.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    // Default message
    @Value("${my.greeting: Hello default}")
    private String greetingMessage;

    @Value("some static message")
    private String staticMessage;

    // Properties to List
    @Value("${my.list.values}")
    private List<String> listValues;

    // Properties to Map
    @Value("#{${dbValues}}")
    private Map<String, String> dbValues;

    @Autowired
    private DatabaseValues databaseValues;

    @GetMapping("/greeting")
    public String greeting(){
        return greetingMessage + " " + staticMessage + " " + listValues + " " + dbValues;
    }

    @GetMapping("/values")
    public String values(){
        return databaseValues.getConnection() + " " + databaseValues.getHost() + " " + databaseValues.getPort();
    }
}
