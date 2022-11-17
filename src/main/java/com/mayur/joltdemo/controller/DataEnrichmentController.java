package com.mayur.joltdemo.controller;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.mayur.joltdemo.entity.Customer;
import com.mayur.joltdemo.util.JoltUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/enrich/")
public class DataEnrichmentController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private JoltSpecController joltSpecController;

	@GetMapping("/{id}")
	public String enrich(@PathVariable(value = "id") long id) {

		ResponseEntity<Map<String, Object>> responseEntity
				= restTemplate.exchange("http://localhost/api/external/customerId/"+id,
								HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, Object>>() {
		});

		Object inputJson = responseEntity.getBody();
		String spec = joltSpecController.getSpec("Dummy");

		List chainSpecJSON = JsonUtils.jsonToList(spec);
		Chainr chainr = Chainr.fromSpec(chainSpecJSON);
		Object transform = chainr.transform(inputJson);


		return transform.toString();
	}
}
