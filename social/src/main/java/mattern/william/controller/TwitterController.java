package mattern.william.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(TwitterController.TWITTER_BASE_URI)
public class TwitterController {

    public static final String TWITTER_BASE_URI = "svc/v1/tweets";

    @Autowired
    private Twitter twitter;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Tweet> getTweets(){
        return twitter.timelineOperations().getUserTimeline("realDonaldTrump");
    }
}
