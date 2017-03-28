package mattern.william.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WordParserService {
    WordParser wordParser;

    public int[] doScore(Tweet tweet) {
        ArrayList<String> positivematches = new ArrayList<String>();
        ArrayList<String> negativematches = new ArrayList<String>();
        ArrayList<String> badword = new ArrayList<String>();
        ArrayList<String> goodword = new ArrayList<String>();
        NegativeWords neg = new NegativeWords();
        PositiveWords pos = new PositiveWords();
        wordParser = new WordParser();
        wordParser.parseAllWords(tweet);
        wordParser.makeDictionaryOfFinalList();
        int[]countArr = new int[3];
        int count = 0;
        int posCount = 0;
        int negCount = 0;
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
                negCount++;
            }
            if (goodword.contains(wordParser.newList.get(i))) {
                count++;
                posCount++;
            }
        }
        countArr[0] = count;
        countArr[1] = posCount;
        countArr[2] = negCount;
        return countArr;
    }
}
