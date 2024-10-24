package com.dhiraj.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	// URL versioning		--> Twitter
	@GetMapping(path="/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob charlie");
	}
	
	@GetMapping(path="/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Dhiraj", "Borse"));
	}
	
	// Request Parameter versioning		--> Amazon
	@GetMapping(path="/person", params="version=1")
	public PersonV1 getFirstVersionOfPersonRequestParams() {
		return new PersonV1("Bob charlie");
	}
	
	@GetMapping(path="/person", params="version=2")
	public PersonV2 getSecondVersionOfPersonRequestHea() {
		return new PersonV2(new Name("Dhiraj", "Borse"));
	}
	
	// Custom Headers versioning		--> Microsoft
	@GetMapping(path="/person/header", headers="X-API-VERIONS=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Bob charlie");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERIONS=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Dhiraj", "Borse"));
	}
	
	// Media Type versionning (content negotiation or accept header)		--> Github
	@GetMapping(path="/person/accept", produces="application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Bob charlie");
	}
	
	@GetMapping(path="/person/accept", produces="application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Dhiraj", "Borse"));
	}
	
	
}

/*
 Factors to consider
 1. URI pollution (by URL, request params)
 2. Misuse of HTTP Headers (by cusotm headers, media type)
 3. Caching, when it comes to caching we can cached base on the url by (URL, request params)
 	but we need to take in account while caching the headers if versioining is done using
 	(by cusotm headers, media type)
 4. Can we execute the request in browser ? (we can by URL, request params)
 5. API documentation, no perfect documentatino for (by cusotm headers, media type)
 
 
 */



























