package mattern.william.entity;

/**
 * Created by williammattern on 3/28/17.
 */
public class DetailedAnalysis extends AnalyzedTwitterHandle {
    private int pos25;
    private int neg25;
    private int tot25;
    private int pos50;
    private int neg50;
    private int tot50;
    private int pos100;
    private int neg100;
    private int tot100;
    private int pos200;
    private int neg200;
    private int tot200;

    public DetailedAnalysis(){
        super();
    }

    public DetailedAnalysis(String twitterHandle, int posScore, int negScore){
        super(twitterHandle,posScore,negScore);
    }

    public DetailedAnalysis(String twitterHandle, int postiveScore, int negativeScore, int pos25, int neg25, int pos50, int neg50, int pos100, int neg100, int pos200, int neg200) {
        super(twitterHandle, postiveScore, negativeScore);
        this.pos25 = pos25;
        this.neg25 = neg25;
        this.tot25 = pos25 - neg25;
        this.pos50 = pos50;
        this.neg50 = neg50;
        this.tot50 = pos50 - neg50;
        this.pos100 = pos100;
        this.neg100 = neg100;
        this.tot100 = pos100 - neg100;
        this.pos200 = pos200;
        this.neg200 = neg200;
        this.tot200 = pos200 - neg200;
    }

    public int getPos25() {
        return pos25;
    }

    public void setPos25(int pos25) {
        this.pos25 = pos25;
    }

    public int getNeg25() {
        return neg25;
    }

    public void setNeg25(int neg25) {
        this.neg25 = neg25;
    }

    public int getTot25() {
        return tot25;
    }

    public void setTot25(int tot25) {
        this.tot25 = tot25;
    }

    public int getPos50() {
        return pos50;
    }

    public void setPos50(int pos50) {
        this.pos50 = pos50;
    }

    public int getNeg50() {
        return neg50;
    }

    public void setNeg50(int neg50) {
        this.neg50 = neg50;
    }

    public int getTot50() {
        return tot50;
    }

    public void setTot50(int tot50) {
        this.tot50 = tot50;
    }

    public int getPos100() {
        return pos100;
    }

    public void setPos100(int pos100) {
        this.pos100 = pos100;
    }

    public int getNeg100() {
        return neg100;
    }

    public void setNeg100(int neg100) {
        this.neg100 = neg100;
    }

    public int getTot100() {
        return tot100;
    }

    public void setTot100(int tot100) {
        this.tot100 = tot100;
    }

    public int getPos200() {
        return pos200;
    }

    public void setPos200(int pos200) {
        this.pos200 = pos200;
    }

    public int getNeg200() {
        return neg200;
    }

    public void setNeg200(int neg200) {
        this.neg200 = neg200;
    }

    public int getTot200() {
        return tot200;
    }

    public void setTot200(int tot200) {
        this.tot200 = tot200;
    }
}
