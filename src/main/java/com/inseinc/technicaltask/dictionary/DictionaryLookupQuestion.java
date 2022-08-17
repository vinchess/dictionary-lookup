package com.inseinc.technicaltask.dictionary;

import java.util.List;

public interface DictionaryLookupQuestion {
    void setupDictionary(List<String> words);
    boolean isWordInDictionary(String searchTerm);
}
