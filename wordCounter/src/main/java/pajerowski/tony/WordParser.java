package pajerowski.tony;

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

    public void parseAllWords() {
        tokens = TrialText.malcolmX.split(regexToSplit);
    }

    public void showParsedList() {
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
    }

    public void eliminateEmptyTokens() {
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("")) {
                newList.add(tokens[i]);
            }
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
