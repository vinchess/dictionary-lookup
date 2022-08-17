package com.inseinc.technicaltask.dictionary;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class DictionaryProvider {

    public List<String> getDictionaryWords() {
        List<String> sampleWords = new ArrayList<>();

        try{
            var scanner = new Scanner(new FileReader("./src/main/resources/sample.txt"));

            while (scanner.hasNext()) {
                sampleWords.add(scanner.next());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Failed to load sample.");
            e.printStackTrace();
        }

        return sampleWords;
//        return List.of("excellent");
    }
}
