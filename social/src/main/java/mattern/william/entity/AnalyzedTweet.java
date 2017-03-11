package mattern.william.entity;

import org.springframework.social.twitter.api.Tweet;

/**
 * Created by williammattern on 3/11/17.
 */
public class AnalyzedTweet {

    private Tweet theTweet;
    private int theScore = 420;

    public AnalyzedTweet(Tweet theTweet){
        this.theTweet = theTweet;
        this.theScore = 0;//import logic here
    }

    public void setTheScoreScore(Tweet theTweet){

    }
}
