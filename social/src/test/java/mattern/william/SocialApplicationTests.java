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
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SocialApplicationTests {

	@Autowired
	MockMvc mockMvc;

	private MockHttpServletRequestBuilder getTweet = get("/svc/v1/tweets/realdonaldtrump");
	private MockHttpServletRequestBuilder getBattle = get("/svc/v1/tweets/realdonaldtrump/normmacdonald/10/score");
	private MockHttpServletRequestBuilder getExpert = get("/svc/v1/tweets/normmacdonald/score");
	private MockHttpServletRequestBuilder getDetail = get("/svc/v1/tweets/normmacdonald/score/detail");

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

	@Test
	public void expertEndpointTest() throws Exception {
		mockMvc.perform(getExpert).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void detailEndpointTest() throws Exception {
		mockMvc.perform(getDetail).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
}