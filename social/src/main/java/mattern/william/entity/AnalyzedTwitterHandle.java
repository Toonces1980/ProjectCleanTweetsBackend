package mattern.william.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;


import java.util.Date;

public class AnalyzedTwitterHandle {

    private String twitterHandle;
    private int postiveScore;
    private int negativeScore;

    public AnalyzedTwitterHandle(String twitterHandle, int postiveScore, int negativeScore) {
        this.twitterHandle = twitterHandle;
        this.postiveScore = postiveScore;
        this.negativeScore = negativeScore;
    }

    public AnalyzedTwitterHandle(){}

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public int getPostiveScore() {
        return postiveScore;
    }

    public void setPostiveScore(int postiveScore) {
        this.postiveScore = postiveScore;
    }

    public int getNegativeScore() {
        return negativeScore;
    }

    public void setNegativeScore(int negativeScore) {
        this.negativeScore = negativeScore;
    }


}
