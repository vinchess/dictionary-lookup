package com.inseinc.technicaltask.dictionary;

import com.inseinc.technicaltask.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find")
public class LookUpResource {

    private final LookUpService lookUpService;

    @Autowired
    public LookUpResource(LookUpService lookUpService) {
        this.lookUpService = lookUpService;
    }

    @PostMapping
    public ResponseEntity doesExist(@RequestBody String word){
        Timer.startTimer();
        var result = lookUpService.isWordInDictionary(word);
        Timer.endTimer();
        return ResponseEntity.ok(result);
    }
}
