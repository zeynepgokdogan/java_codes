//Zeynep Gokdogan

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Elections {
    private HashMap<String, Integer> wordCount;

    public Elections(HashMap<String, Integer> wordCount) {
        this.wordCount = wordCount;
    }

    public void election_1(String word) {
        int count = getCount(word);
        System.out.println("The word '" + word + "' appears " + count + " times.");
    }

    public void election_2(int number) {
        List<String> mostFrequent = getMostFrequentWords(number);
        System.out.println("The " + number + " most frequent words are " + mostFrequent);
    }

    public void election_3(int number) {
        List<String> leastFrequent = getLeastFrequentWords(number);
        System.out.println("The " + number + " most frequent words are " + leastFrequent);
    }
    
    
    public int getCount(String word) {
        return wordCount.getOrDefault(word.toLowerCase(), 0);
    }

    public List<String> getMostFrequentWords(int k) {
        List<String> mostFrequent = new ArrayList<>(wordCount.keySet());
        mostFrequent.sort((word1, word2) -> wordCount.get(word2) - wordCount.get(word1));
        return mostFrequent.subList(0, Math.min(k, mostFrequent.size()));
    }

    public List<String> getLeastFrequentWords(int k) {
        List<String> leastFrequent = new ArrayList<>(wordCount.keySet());
        leastFrequent.sort((word1, word2) -> wordCount.get(word1) - wordCount.get(word2));
        return leastFrequent.subList(0, Math.min(k, leastFrequent.size()));
    }

}
