package com.example.collectibles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeaderController {
	
	@GetMapping("/contactUs")
	public String getContactUs() {
		return "contact-us";
	}
	
	@GetMapping("/getCollectionBinaryville")
	public String getBinaryville() {
		return "/characters/Collection-Binaryville";
	}
	
	@GetMapping("/getCollectionLilmonsters")
	public String getLilMonsters() {
		return "/characters/Collection-Lilmonsters";
	}
	@GetMapping("/getCollectionStartgazers")
	public String getStargazer() {
		return "/characters/Collection-Stargazers";
	}

}
