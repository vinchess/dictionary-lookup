package com.inseinc.technicaltask;

import com.inseinc.technicaltask.dictionary.LookUpService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LookUpServiceTest {

    @Autowired
    private LookUpService lookUpService;

    private final List<String> searchTerms = new ArrayList<>();
    private final List<Boolean> results = new ArrayList<>();

    @Test
    public void testAllGivenScenario(){
        givenListOfValidSearchTerms();
        whenILookUpEachSearchTerms();
        thenAllResultsAreTrue();
    }

    @Test
    public void testFalseScenario(){
        givenListOfInvalidSearchTerms();
        whenILookUpEachSearchTerms();
        thenAllResultsAreFalse();
    }

    private void givenListOfValidSearchTerms() {
        searchTerms.addAll(List.of("excellent","*excellent*","*excellent","excellent*","*cellent","excelle*","*xcelle*"));
    }

    private void givenListOfInvalidSearchTerms() {
        searchTerms.addAll(List.of("jkl","jkl*","*jkl*","*jkl"));
    }

    private void whenILookUpEachSearchTerms() {
        searchTerms.forEach(searchTerm -> {
            results.add(lookUpService.isWordInDictionary(searchTerm));
        });
    }

    private void thenAllResultsAreTrue() {
        assertTrue(results.stream().allMatch(result -> result.equals(true)));
    }

    private void thenAllResultsAreFalse() {
        assertTrue(results.stream().allMatch(result -> result.equals(false)));
    }
}
