package com.example.StarWarsTemplate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
class StarWarsTemplateApplicationTests {

	@Test
	public void consomeAPI() {
		RestTemplate template = new RestTemplate();		
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("swapi.dev")
				.path("api/people/1/")
				//.queryParam("people", 1)
				.build();
		
		ResponseEntity<People> entity = template.getForEntity(uri.toUriString(), People.class);
		
		System.out.println(entity.getBody().getName());
	}

}
