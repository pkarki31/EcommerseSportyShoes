package com.Simplilearn.eCommerceSportyShoes.controller;

import com.Simplilearn.eCommerceSportyShoes.entity.Hobby;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HobbyController {
	@GetMapping("/hello")
	public String hello() {
		return "Hey welcome to simplilearn";
	}

	@GetMapping("/hobbies")
	public List<Hobby> listHobbies() {
		Hobby hobby1 = new Hobby(1, "Watching Movies");
		Hobby hobby2 = new Hobby(2, "Playing Piano");

		List<Hobby> hobbies = new ArrayList<Hobby>();
		hobbies.add(hobby1);
		hobbies.add(hobby2);
		return hobbies;
	}

}
