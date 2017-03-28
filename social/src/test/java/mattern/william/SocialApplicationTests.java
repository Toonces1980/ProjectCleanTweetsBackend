package mattern.william;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SocialApplicationTests {

	@Autowired
	MockMvc mockMvc;

	public MockHttpServletRequestBuilder getTweet = get("/svc/v1/tweets/realdonaldtrump");
	public MockHttpServletRequestBuilder getBattle = get("/svc/v1/tweets/realdonaldtrump/normmacdonald/10/score");

	@Test
	public void tweetEndpointTest() throws Exception {
		mockMvc.perform(getTweet).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void battleEndpointTest() throws Exception {
		mockMvc.perform(getBattle).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
}