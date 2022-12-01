package vttp2022.ssf.ssfworkshop13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import vttp2022.ssf.ssfworkshop13.controllers.AddressbookController;
import vttp2022.ssf.ssfworkshop13.models.Contact;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SsfWorkshop13ApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private AddressbookController addressbkController;

	@Autowired
	private MockMvc mockMvc;


	@Autowired
	private TestRestTemplate restTemplate;

	private static final String TEST_URL = "http://localhost:";

	@Test
	void contextLoads() {
		assertThat(addressbkController).isNotNull();
	}


	@Test
	public void testContact() throws Exception{
		Contact c = new Contact();
		c.setEmail("apple@gmail.com");
		c.setName("apple");
		c.setPhoneNumber(123123123);
		assertEquals(c.getEmail(), "apple@gmail.com");
	}

	@Test
	public void testAddressbookController(){
		assertThat(this.restTemplate.getForObject(TEST_URL + port + "/addressbook", 
						String.class)).contains("Your contact information");
	}



	@Test
	public void testSaveAddressUsingRestTemplate(){
		final String baseUrl = TEST_URL + port + "/addressbook";
		try {
			URI uri = new URI(baseUrl);
			Contact ctc = new Contact();
			ctc.setEmail("aa@a.com");
			ctc.setName("AA");
			ctc.setPhoneNumber(123456);
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<Contact> request = new HttpEntity<>(ctc, headers);
			ResponseEntity<String> result = this.restTemplate.postForEntity(TEST_URL + port + "/addressbook", 
												request, String.class);
			assertEquals(HttpStatus.OK, result.getStatusCode());
												


		} catch (URISyntaxException e) {
				e.printStackTrace();
		}
	}

	@Test
	public void testSaveAddressUsingUrlEncoded(){
		try {
			ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders
			               .post(TEST_URL + port + "/addressbook")
						   .contentType(MediaType.APPLICATION_FORM_URLENCODED)
						   .content("name=grace&email=grace@123.com&phoneNumber=123123"));
					System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

