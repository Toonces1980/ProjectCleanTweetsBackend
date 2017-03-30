package mattern.william.service;

import mattern.william.entity.DetailedAnalysis;
import mattern.william.entity.DetailedAnalysisBuilder;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WordParserService {
    private WordParser wordParser;

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

    public DetailedAnalysis getDetailedAnalysis(String twitterHandle, List<Tweet> tweetsList) {
        int listLength = tweetsList.size(), count = 1, posValue = 0, negValue = 0;
        System.out.println("Calculating score for " + listLength + " tweets");
        boolean set25 = false, set50 = false, set100 = false, set200 = false;
        DetailedAnalysisBuilder analysisBuilder = new DetailedAnalysisBuilder();
        analysisBuilder.setTwitterHandle(twitterHandle);
        for (Tweet tweet: tweetsList){
            int[] countArr = doScore(tweet);
            posValue = posValue + countArr[1];
            negValue = negValue + countArr[2];
            if(count == 25){
                analysisBuilder.setPos25(posValue);
                analysisBuilder.setNeg25(negValue);
                set25 = true;
            }
            if(count == 50){
                analysisBuilder.setPos50(posValue);
                analysisBuilder.setNeg50(negValue);
                set50 = true;
            }
            if(count == 100){
                analysisBuilder.setPos100(posValue);
                analysisBuilder.setNeg100(negValue);
                set100 = true;
            }
            if(count == 200){
                analysisBuilder.setPos200(posValue);
                analysisBuilder.setNeg200(negValue);
                set200 = true;
            }
            count++;
        }
        if(!set25){
            analysisBuilder.setPos25(posValue);
            analysisBuilder.setNeg25(negValue);
        }
        if(!set50){
            analysisBuilder.setPos50(posValue);
            analysisBuilder.setNeg50(negValue);
        }
        if(!set100){
            analysisBuilder.setPos100(posValue);
            analysisBuilder.setNeg100(negValue);
        }
        if(!set200){
            analysisBuilder.setPos200(posValue);
            analysisBuilder.setNeg200(negValue);
        }
        analysisBuilder.setPosScore(posValue);
        analysisBuilder.setNegScore(negValue);
        analysisBuilder.setMostRecentTweet(tweetsList.get(0));
        return analysisBuilder.createDetailedAnalysis();
    }

    public void print(int[] countArr){
        System.out.print(countArr[0] + " = ");
        System.out.print(countArr[1] + " - ");
        System.out.println(countArr[2]);
    }
}
