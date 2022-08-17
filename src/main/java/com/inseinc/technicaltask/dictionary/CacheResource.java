package com.inseinc.technicaltask.dictionary;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
@AllArgsConstructor
public class CacheResource {

    private final DictionaryCache dictionaryCache;

    @GetMapping
    public ResponseEntity getCache(){
        return ResponseEntity.ok(dictionaryCache.getCache());
    }

}
