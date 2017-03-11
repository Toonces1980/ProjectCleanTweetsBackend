package pajerowski.tony;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by anthonypajerowski on 2/15/17.
 */
public class MainTester {

    static String inputText = "/Users/anthonypajerowski/Desktop/oopsy/wordCounter/src/main/resources/ObamaKeyNote2004.txt";
    static String negativeDictionary = "/Users/anthonypajerowski/Desktop/oopsy/wordCounter/src/main/resources/negative-words.txt";
    static String positiveDictionary = "/Users/anthonypajerowski/Desktop/oopsy/wordCounter/src/main/resources/positive-words.txt";

    public static void main(String[] args) {
        ImportTextFiles files = new ImportTextFiles();
        ArrayList<String> positivematches = new ArrayList<String>();
        ArrayList<String> negativematches = new ArrayList<String>();
        ArrayList<String> badword = new ArrayList<String>();
        ArrayList<String> goodword = new ArrayList<String>();
        NegativeWords neg = new NegativeWords();
        PositiveWords pos = new PositiveWords();
        WordParser wordParser = new WordParser();
        TrialText trialText = new TrialText();
        wordParser.parseAllWords();
  //      wordParser.showParsedList();
        wordParser.eliminateEmptyTokens();
//        wordParser.showFinalList();
        wordParser.makeDictionaryOfFinalList();
//        wordParser.showDictionaryOfFinalList();
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
                negativematches.add(wordParser.newList.get(i));
            }
            if (goodword.contains(wordParser.newList.get(i))) {
                positivematches.add(wordParser.newList.get(i));
            }
        }
        System.out.println("Input:   -----------------------------------------------  " + wordParser.speechName);
        System.out.println("posmatchsize -------------------------------------------  " +  positivematches.size() + " " + positivematches + "\n");
        System.out.println("negmatchsize -------------------------------------------  " +  negativematches.size() + " " + negativematches + "\n");
        System.out.println("input length: " + wordParser.newList.size() + "\n");
        System.out.println("percent words matched: " + (double)(positivematches.size()+negativematches.size()) / wordParser.newList.size() + "\n");
//        for ( int i = 0; i < positivematches.size(); i++ ) {
//            System.out.println(positivematches.get(i));
//        }
//        for ( int i = 0; i < negativematches.size(); i++) {
//            System.out.println(negativematches.get(i));
//        }
        System.out.println("OVERALL SENTIMENT   ------------------------------------  " + (double)(positivematches.size() - negativematches.size()) + "\n");
        System.out.println("AVERAGE SENTIMENT   ------------------------------------  " + (double)(positivematches.size() - negativematches.size())/wordParser.newList.size() + "\n");
        System.out.println("Adjusted AVerage Sentiment -----------------------------  " + (double)((positivematches.size() - (double)negativematches.size())/(double)wordParser.newList.size())/((double)(positivematches.size()+negativematches.size()) / wordParser.newList.size()));
//        try {
//            System.out.println(files.importTextFileToString(inputText));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }
}