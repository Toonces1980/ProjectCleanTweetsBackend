package mattern.william.controller;

import mattern.william.entity.AnalyzedTwitterHandle;
import mattern.william.service.AnalyzedTweetService;
import mattern.william.service.WordParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping(TwitterController.TWITTER_BASE_URI)
public class TwitterController {

    public static final String TWITTER_BASE_URI = "svc/v1/tweets";

    private final Twitter twitter;

    private final WordParserService wordParserService;

    private final AnalyzedTweetService analyzedTweetService;

    @Autowired
    public TwitterController(Twitter twitter, WordParserService wordParserService, AnalyzedTweetService analyzedTweetService){
        this.twitter = twitter;
        this.wordParserService = wordParserService;
        this.analyzedTweetService = analyzedTweetService;
    }

    @RequestMapping(value="/{twitterHandle}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Tweet> getTweets(@PathVariable String twitterHandle){
        return twitter.timelineOperations().getUserTimeline(twitterHandle,1);
    }

    @RequestMapping(value="/{twitterHandle}/score", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int getTweetScore(@PathVariable String twitterHandle){
        int tweetNumber = 100;
        int tweetScore = 0;
        List<Tweet> tweets= twitter.timelineOperations().getUserTimeline(twitterHandle,tweetNumber);
        for (int i = 0; i < tweetNumber; i++) {
            tweetScore += wordParserService.doScore(tweets.get(i))[0];
        }
        return tweetScore;
    }

    @RequestMapping(value="/{twitterHandle}/{tweetNumber}/score", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int getTweetScore(@PathVariable String twitterHandle, @PathVariable int tweetNumber){
        int tweetScore = 0;
        List<Tweet> tweets= twitter.timelineOperations().getUserTimeline(twitterHandle,tweetNumber);
        for (int i = 0; i < tweetNumber; i++) {
            tweetScore += wordParserService.doScore(tweets.get(i))[0];
        }
        return tweetScore;
    }



    @RequestMapping(value="/{twitterHandle1}/{twitterHandle2}/{tweetNumber}/score", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> getTweetScore(@PathVariable String twitterHandle1, @PathVariable String twitterHandle2, @PathVariable int tweetNumber){
        Map<String, String>battleMap = new HashMap<>();
        List<String> results = new ArrayList<>();
        {
            battleMap.put("winner", "");
            battleMap.put("loser", "");
            battleMap.put("tweetScore1", "");
            battleMap.put("tweet1Pos", "");
            battleMap.put("tweet1Neg", "");
            battleMap.put("tweetScore2", "");
            battleMap.put("tweet2Pos", "");
            battleMap.put("tweet2Neg", "");
        }
        String winner = "";
        int tweetScore1 = 0;
        int tweet1Pos = 0;
        int tweet1Neg = 0;
        int tweetScore2 = 0;
        int tweet2Pos = 0;
        int tweet2Neg = 0;
        List<Tweet> tweets1= twitter.timelineOperations().getUserTimeline(twitterHandle1,tweetNumber);
        for (Tweet tweet: tweets1) {
            tweetScore1 += wordParserService.doScore(tweet)[0];
            tweet1Pos += wordParserService.doScore(tweet)[1];
            tweet1Neg += wordParserService.doScore(tweet)[2];
        }
        List<Tweet> tweets2= twitter.timelineOperations().getUserTimeline(twitterHandle2,tweetNumber);
        for (Tweet tweet: tweets2) {
            tweetScore2 += wordParserService.doScore(tweet)[0];
            tweet2Pos += wordParserService.doScore(tweet)[1];
            tweet2Neg += wordParserService.doScore(tweet)[2];
        }
        if (tweetScore1 > tweetScore2) {
            battleMap.put("winner", twitterHandle1);
            results.add(twitterHandle1);
            battleMap.put("loser", twitterHandle2);
            results.add(twitterHandle2);
            battleMap.put("tweetScore1", String.valueOf(tweetScore1));
            results.add(String.valueOf(tweetScore1));
            battleMap.put("tweet1Pos", String.valueOf(tweet1Pos));
            results.add(String.valueOf(tweet1Pos));
            battleMap.put("tweet1Neg", String.valueOf(tweet1Neg));
            results.add(String.valueOf(tweet1Neg));
            battleMap.put("tweetScore2", String.valueOf(tweetScore2));
            results.add(String.valueOf(tweetScore2));
            battleMap.put("tweet2Pos", String.valueOf(tweet2Pos));
            results.add(String.valueOf(tweet2Pos));
            battleMap.put("tweet2Neg", String.valueOf(tweet2Neg));
            results.add(String.valueOf(tweet2Neg));
        } else if (tweetScore2 > tweetScore1) {
            battleMap.put("winner", twitterHandle2);
            results.add(twitterHandle2);
            battleMap.put("loser", twitterHandle1);
            results.add(twitterHandle1);
            battleMap.put("tweetScore1", String.valueOf(tweetScore2));
            results.add(String.valueOf(tweetScore2));
            battleMap.put("tweet1Pos", String.valueOf(tweet2Pos));
            results.add(String.valueOf(tweet2Pos));
            battleMap.put("tweet1Neg", String.valueOf(tweet2Neg));
            results.add(String.valueOf(tweet2Neg));
            battleMap.put("tweetScore2", String.valueOf(tweetScore1));
            results.add(String.valueOf(tweetScore1));
            battleMap.put("tweet2Pos", String.valueOf(tweet1Pos));
            results.add(String.valueOf(tweet1Pos));
            battleMap.put("tweet2Neg", String.valueOf(tweet1Neg));
            results.add(String.valueOf(tweet1Neg));
        } else {
            battleMap.put("winner", "everybody");
            results.add(twitterHandle1);
            battleMap.put("loser", "nobody");
            results.add(twitterHandle2);
            battleMap.put("tweetScore1", String.valueOf(tweetScore1));
            results.add(String.valueOf(tweetScore1));
            battleMap.put("tweet1Pos", String.valueOf(tweet1Pos));
            results.add(String.valueOf(tweet1Pos));
            battleMap.put("tweet1Neg", String.valueOf(tweet1Neg));
            results.add(String.valueOf(tweet1Neg));
            battleMap.put("tweetScore2", String.valueOf(tweetScore2));
            results.add(String.valueOf(tweetScore2));
            battleMap.put("tweet2Pos", String.valueOf(tweet2Pos));
            results.add(String.valueOf(tweet2Pos));
            battleMap.put("tweet2Neg", String.valueOf(tweet2Neg));
            results.add(String.valueOf(tweet2Neg));
        }
        return results;
    }


    @RequestMapping(value="/db/scores", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection<AnalyzedTwitterHandle> getScores(){
        return analyzedTweetService.getAllAnalyzedTwitterHandles();
    }

    @RequestMapping(value="/db/scores/{twitterHandle}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AnalyzedTwitterHandle getScoresByHandle(@PathVariable String twitterHandle) throws NoSuchElementException{
        AnalyzedTwitterHandle result = analyzedTweetService.getAnalyzedTwitterHandleByHandle(twitterHandle);
        if(result == null){
            throw new NoSuchElementException("no such handle in Db yet");
        }
        return result;
    }

    @RequestMapping(value="/db/scores/{twitterHandle}", method=RequestMethod.DELETE)
    public void deleteAnalysisByHandle(@PathVariable String twitterHandle){
        this.analyzedTweetService.removeHandle(twitterHandle);
    }

}
