package com.inseinc.technicaltask.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LookUpService implements DictionaryLookupQuestion {

    private final DictionaryCache dictionaryCache;

    @Autowired
    public LookUpService(DictionaryProvider dictionaryProvider,
                         DictionaryCache dictionaryCache) {
        this.dictionaryCache = dictionaryCache;
        setupDictionary(dictionaryProvider.getDictionaryWords());
    }

    @Override
    public void setupDictionary(List<String> listOfWords) {
        dictionaryCache.addToCache(listOfWords);
    }

    @Override
    public boolean isWordInDictionary(String searchTerm) {

        if(consistOnlyWildcards(searchTerm)) {
            return true;
        }

        var sanitisedSearchTerm = searchTerm.replaceAll("\\*","");
        switch (getLookUpType(searchTerm)){
            case CONTAINS:
                return dictionaryCache.lookUpWordContain(sanitisedSearchTerm);
            case BEGINS_WITH:
                return dictionaryCache.lookUpWordBeginWith(sanitisedSearchTerm);
            case ENDS_WITH:
                return dictionaryCache.lookUpWordEndWith(sanitisedSearchTerm);
            case UNDEFINED:
            default: return dictionaryCache.lookUpWholeWord(sanitisedSearchTerm);
        }
    }

    private boolean consistOnlyWildcards(String searchTerm) {
        for(int i = 1; i < searchTerm.length(); i++){
            if(searchTerm.charAt(0) != searchTerm.charAt(i)){
                return false;
            }
        }
        return searchTerm.charAt(0) == '*';
    }

    private LookUpType getLookUpType(String searchTerm) {

        if(searchTerm.startsWith("*") && searchTerm.endsWith("*")){
            return LookUpType.CONTAINS;
        }

        if(searchTerm.startsWith("*")) {
            return LookUpType.ENDS_WITH;
        }

        if(searchTerm.endsWith("*")) {
            return LookUpType.BEGINS_WITH;
        }

        return LookUpType.UNDEFINED;
    }
}
