package mattern.william.service;

import mattern.william.entity.DetailedAnalysis;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by williammattern on 3/29/17.
 */
public class WordParserServiceTest {

    int[] intArray = {1,2,3};

    Tweet mockTweet = mock(Tweet.class);
    Tweet mockNegative = mock(Tweet.class);
    List<Tweet> mockTweets;

    WordParserService wordParserService = new WordParserService();

    @Before
    public void setUp() throws Exception {
        mockTweets = new ArrayList<>();
        when(mockTweet.getUnmodifiedText()).thenReturn("Happy love joy awesome");
        when(mockNegative.getUnmodifiedText()).thenReturn("Don't worry, be happy, sucker");
        mockTweets.add(mockTweet);
        mockTweets.add(mockNegative);
    }

    @Test
    public void doScoreTest(){
        int[] actualPos = wordParserService.doScore(mockTweet), expectedPos = {3,3,0};
        int[] actualNeg = wordParserService.doScore(mockNegative), expectedNeg = {-1,1,2};
        assertArrayEquals(expectedPos, actualPos);
        assertArrayEquals(expectedNeg, actualNeg);
    }

    @Test
    public void detailedAnalysisTest() throws Exception {
        DetailedAnalysis actual = wordParserService.getDetailedAnalysis("this is a string",mockTweets);
        verify(mockTweet).getUnmodifiedText();
        verify(mockNegative).getUnmodifiedText();
    }
}
