package mattern.william.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.social.twitter.api.Tweet;

public class AnalyzedTwitterHandle {
    private int id;
    private String twitterHandle;
    private int postiveScore;
    private int negativeScore;

    public AnalyzedTwitterHandle(int id, String twitterHandle, int postiveScore, int negativeScore) {
        this.id = id;
        this.twitterHandle = twitterHandle;
        this.postiveScore = postiveScore;
        this.negativeScore = negativeScore;
    }

    public AnalyzedTwitterHandle(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
