package mattern.william.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;


import java.util.Date;

public class AnalyzedTwitterHandle {
    private int id;
    private String twitterHandle;
    private int postiveScore;
    private int negativeScore;
    private int totalScore;

    public AnalyzedTwitterHandle(int id, String twitterHandle, int postiveScore, int negativeScore) {
        this.id = id;
        this.twitterHandle = twitterHandle;
        this.postiveScore = postiveScore;
        this.negativeScore = negativeScore;
        this.totalScore = postiveScore - negativeScore;
    }

    public AnalyzedTwitterHandle(String twitterHandle, int postiveScore, int negativeScore) {
        this.id = (int)Math.floor(Math.random());
        this.twitterHandle = twitterHandle;
        this.postiveScore = postiveScore;
        this.negativeScore = negativeScore;
        this.totalScore = postiveScore - negativeScore;
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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
