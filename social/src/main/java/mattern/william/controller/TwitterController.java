package mattern.william.controller;

import mattern.william.service.WordParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(TwitterController.TWITTER_BASE_URI)
public class TwitterController {

    public static final String TWITTER_BASE_URI = "svc/v1/tweets";

    private final Twitter twitter;

    private final WordParserService wordParserService;

    @Autowired
    public TwitterController(Twitter twitter, WordParserService wordParserService){
        this.twitter = twitter;
        this.wordParserService = wordParserService;
    }

    @RequestMapping(value="/{twitterHandle}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Tweet> getTweets(@PathVariable String twitterHandle){
        return twitter.timelineOperations().getUserTimeline(twitterHandle,1);
    }

    @RequestMapping(value="/{twitterHandle}/score", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int getTweetScore(@PathVariable String twitterHandle){
        return wordParserService.doScore(twitter.timelineOperations().getUserTimeline(twitterHandle,1).get(0));
    }


}
