package mattern.william.entity;

public class DetailedAnalysisBuilder {
    private String twitterHandle;
    private int posScore;
    private int negScore;
    private int id;
    private int pos25;
    private int neg25;
    private int pos50;
    private int neg50;
    private int pos100;
    private int neg100;
    private int pos200;
    private int neg200;

    public DetailedAnalysisBuilder setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
        return this;
    }

    public DetailedAnalysisBuilder setPosScore(int posScore) {
        this.posScore = posScore;
        return this;
    }

    public DetailedAnalysisBuilder setNegScore(int negScore) {
        this.negScore = negScore;
        return this;
    }

    public DetailedAnalysisBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public DetailedAnalysisBuilder setPos25(int pos25) {
        this.pos25 = pos25;
        return this;
    }

    public DetailedAnalysisBuilder setNeg25(int neg25) {
        this.neg25 = neg25;
        return this;
    }

    public DetailedAnalysisBuilder setPos50(int pos50) {
        this.pos50 = pos50;
        return this;
    }

    public DetailedAnalysisBuilder setNeg50(int neg50) {
        this.neg50 = neg50;
        return this;
    }

    public DetailedAnalysisBuilder setPos100(int pos100) {
        this.pos100 = pos100;
        return this;
    }

    public DetailedAnalysisBuilder setNeg100(int neg100) {
        this.neg100 = neg100;
        return this;
    }

    public DetailedAnalysisBuilder setPos200(int pos200) {
        this.pos200 = pos200;
        return this;
    }

    public DetailedAnalysisBuilder setNeg200(int neg200) {
        this.neg200 = neg200;
        return this;
    }

    public DetailedAnalysis createDetailedAnalysis() {
        return new DetailedAnalysis(twitterHandle, posScore, negScore, pos25, neg25, pos50, neg50, pos100, neg100, pos200, neg200);
    }
}