package com.inseinc.technicaltask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechnicalTaskApplication {

    public static void main(String[] args) {
        Timer.startTimer();
        SpringApplication.run(TechnicalTaskApplication.class, args);
        Timer.endTimer();
    }
}


//
//package com.ingg.interview.question;
//
///*** I want you to implement a dictionary lookup service such that given a dictionary of words your
// * service is able to perform a search and return true if the word is contained within the dictionary.
// *
// * The search term used by the user may contain a wildcard represented by an asterisk(*).
// * Wildcard can only be used at the beginning and end of the search term.
// * The wildcard represents zero or more characters
// * Some example search terms the user may supply which would all match the word "excellent":
// * excellent
// * *excellent*
// * *excellent
// * excellent*
// * *cellent
// * excelle*
// * *xcelle*
// *
// *
// * Care should be taken to make it as quick as possible for the user. Memory usage isn't a concern,
// * nor is a slow setup method, so as much logic as possible should be performed in the setup method
// * such that you can prioritise the performance of the lookup method for the user. You're also only
// * required to confirm if the users search is present within the dictionary, you do not actually
// * have to find a specific matching word.
// */public interface DictionaryLookupQuestion {  /**
// * This is called to supply the dictionary implementation with all words in the dictionary. In
// * this method you should store your values in a way which will prioritise speed of lookup later.
// *
// * @param words All words within the dictionary
// */  void setupDictionary(String[] words);  /**
// * This method should perform a lookup and confirm if the provided search term matches at least 1
// * word within the dictionary. This method should take into account wildcard characters(asterisk   *
// *) at the ends of the search term such that the user can perform "begins with", "ends with" and
// * "contains" lookups.
// *
// * @param searchTerm The search term, possibly containing wildcards
// * @return true if the provided search term matches at least one word within the dictionarry,
// * false otherwise   */  boolean isWordInDictionary(String searchTerm);}