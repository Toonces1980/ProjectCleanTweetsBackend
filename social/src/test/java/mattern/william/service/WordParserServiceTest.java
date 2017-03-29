package mattern.william.service;

import mattern.william.entity.DetailedAnalysis;
import org.junit.Before;
import org.junit.Test;
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
    private Tweet mockTweet, mockNegative;
    private List<Tweet> mockTweets;
    private WordParserService wordParserService;

    @Before
    public void setUp() throws Exception {
        mockTweet = mock(Tweet.class);
        mockNegative = mock(Tweet.class);
        wordParserService = new WordParserService();
        mockTweets = new ArrayList<>();
        mockTweets.add(mockTweet);
        mockTweets.add(mockNegative);
        when(mockTweet.getUnmodifiedText()).thenReturn("Happy love joy awesome");
        when(mockNegative.getUnmodifiedText()).thenReturn("Don't worry, be happy, sucker");
    }

    @Test
    public void doScoreTest(){
        int[] actualPos = wordParserService.doScore(mockTweet);
        int[] actualNeg = wordParserService.doScore(mockNegative);
        verify(mockTweet).getUnmodifiedText();//asserting that text is actually being used
        verify(mockNegative).getUnmodifiedText();//asserting that text is actually being used
        assertTrue(actualNeg[1]>=0);//asserting that no negative value is being found
        assertTrue(actualNeg[2]>=0);//asserting that no negative value is being found
        assertTrue(actualPos[1]>=0);//asserting that no negative value is being found
        assertTrue(actualPos[2]>=0);//asserting that no negative value is being found
        assertNotEquals(actualPos[0], actualNeg[0]);//asserting that doScore is finding differences
    }

    @Test
    public void detailedAnalysisTest() throws Exception {
        DetailedAnalysis actual = wordParserService.getDetailedAnalysis("this is a string",mockTweets);
        verify(mockTweet).getUnmodifiedText();
        verify(mockNegative).getUnmodifiedText();
    }
}
