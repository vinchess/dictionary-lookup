package com.inseinc.technicaltask.dictionary;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Component
public class DictionaryCache {

    private List<String> loadedDictionary = new ArrayList<>();
    private final Set<String> prefixSet = new TreeSet<>();
    private final Set<String> suffixSet = new TreeSet<>();
    private final Set<String> containSet = new TreeSet<>();

    public void addToCache(List<String> words) {
        loadedDictionary = words;
        populatePrefixSet(words);
        populateSuffixSet(words);
        populateContainSet(words);
    }

    private void populatePrefixSet(List<String> words) {
        words.forEach(word -> {
            int start = 0;
            for(var i = start; i < word.length(); i++){
                prefixSet.add(word.substring(start,i+1));
            }
        });
    }

    private void populateSuffixSet(List<String> words) {
        words.forEach(word -> {
            int end = word.length();
            for(var i = end; i > 0; i--){
                suffixSet.add(word.substring(i - 1,end));
            }
        });
    }

    private void populateContainSet(List<String> words) {
        words.forEach(word -> {
            for(var i = 0; i < word.length(); i++){
                checkLeft(i, word);
                checkRight(i, word);
            }
        });
    }

    private void checkLeft(int index, String word) {
        for(var i = index; i > 0; i--) {
            containSet.add(word.substring(i - 1, index));
        }
    }

    private void checkRight(int index, String word) {
        for(var i = index; i < word.length(); i++) {
            containSet.add(word.substring(index, i + 1));
        }
    }

    public boolean lookUpWordContain(String searchTerm) {
        return containSet.contains(searchTerm);
    }

    public boolean lookUpWordBeginWith(String searchTerm) {
        return prefixSet.contains(searchTerm);
    }

    public boolean lookUpWordEndWith(String searchTerm) {
        return suffixSet.contains(searchTerm);
    }

    public boolean lookUpWholeWord(String searchTerm) {
        return loadedDictionary.contains(searchTerm);
    }

    public Cache getCache() {
        return new Cache(loadedDictionary, prefixSet, suffixSet, containSet);
    }

    class Cache {
        private final List<String> loadedDictionary;
        private final Set<String> prefixSet ;
        private final Set<String> suffixSet ;
        private final Set<String> containSet;

        public Cache(List<String> loadedDictionary, Set<String> prefixSet, Set<String> suffixSet, Set<String> containSet) {
            this.loadedDictionary = loadedDictionary;
            this.prefixSet = prefixSet;
            this.suffixSet = suffixSet;
            this.containSet = containSet;
        }

//        public List<String> getLoadedDictionary() {
//            return loadedDictionary;
//        }

        public int getLoadedDictionarySize() {
            return loadedDictionary.size();
        }

//        public Set<String> getPrefixSet() {
//            return prefixSet;
//        }

        public int getPrefixSetSize() {
            return prefixSet.size();
        }

//        public Set<String> getSuffixSet() {
//            return suffixSet;
//        }

        public int getSuffixSetSize() {
            return suffixSet.size();
        }

//        public Set<String> getContainSet() {
//            return containSet;
//        }

        public int getContainSetSize() {
            return containSet.size();
        }

        @Override
        public String toString() {
            return "Cache{" +
                    "loadedDictionary=" + loadedDictionary +
                    ", prefixSet=" + prefixSet +
                    ", suffixSet=" + suffixSet +
                    ", containSet=" + containSet +
                    '}';
        }
    }
}
