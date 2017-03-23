package mattern.william.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WordParserService {
    WordParser wordParser;

    static String inputText = "/Users/anthonypajerowski/Desktop/oopsy/wordCounter/src/main/resources/ObamaKeyNote2004.txt";
    static String negativeDictionary = "/Users/anthonypajerowski/Desktop/oopsy/wordCounter/src/main/resources/negative-words.txt";
    static String positiveDictionary = "/Users/anthonypajerowski/Desktop/oopsy/wordCounter/src/main/resources/positive-words.txt";

    public int doScore(Tweet tweet) {

//        public void makeDictionaryOfFinalList() {
//            for (int i = 0; i < newList.size(); i++) {
//                if (!wordCounts.containsKey(newList.get(i))) {
//                    wordCounts.put(newList.get(i), 1);
//                } else wordCounts.put(newList.get(i), 1 + wordCounts.get(newList.get(i)));
//            }
//        }


//        ImportTextFiles files = new ImportTextFiles();
        ArrayList<String> positivematches = new ArrayList<String>();
        ArrayList<String> negativematches = new ArrayList<String>();
        ArrayList<String> badword = new ArrayList<String>();
        ArrayList<String> goodword = new ArrayList<String>();
        NegativeWords neg = new NegativeWords();
        PositiveWords pos = new PositiveWords();
        wordParser = new WordParser();
        wordParser.parseAllWords(tweet);
        wordParser.makeDictionaryOfFinalList();
        int count = 0;
        String[] negWords = neg.negativeWords.split("\\r?\\n");
        String[] posWords = pos.positiveWords.split("\\r?\\n");
        for ( int i = 0; i < negWords.length; i++){
            badword.add(negWords[i]);
        }
        for ( int i = 0; i < posWords.length; i++ ) {
            goodword.add(posWords[i]);
        }

        for( int i = 0; i < wordParser.newList.size(); i++) {
            if (badword.contains(wordParser.newList.get(i))){
                count--;
                negativematches.add(wordParser.newList.get(i));
            }
            if (goodword.contains(wordParser.newList.get(i))) {
                count++;
                positivematches.add(wordParser.newList.get(i));
            }
        }
        return count;
    }
}
