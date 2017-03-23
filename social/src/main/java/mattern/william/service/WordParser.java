package mattern.william.service;

import org.springframework.social.twitter.api.Tweet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anthonypajerowski on 2/15/17.
 */
public class WordParser {

    private String[] tokens;
    private String regexToSplit = "(\\W)";
    public ArrayList<String> newList = new ArrayList<String>();
    private HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
    public String speechName = "ObamaKeyNote";

    public void speechName () {
        System.out.println(speechName);
    }

    public void printTweet(Tweet theTweet){
        System.out.println(theTweet.getUnmodifiedText());
    }

    public void parseAllWords(Tweet theTweet) {
        tokens = theTweet.getUnmodifiedText().split(regexToSplit);
        for(int special=0;special < tokens.length; special++){
            System.out.println(tokens[special]);
        }
    }

    public void showParsedList() {
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
    }

    public void showFinalList() {
        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }
    }

    public void makeDictionaryOfFinalList() {
        for (int i = 0; i < newList.size(); i++) {
            if (!wordCounts.containsKey(newList.get(i))) {
                wordCounts.put(newList.get(i), 1);
            } else wordCounts.put(newList.get(i), 1 + wordCounts.get(newList.get(i)));
        }
    }

    public void showDictionaryOfFinalList() {
        System.out.println(wordCounts);
    }
}
