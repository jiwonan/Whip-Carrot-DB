package com.example.whipCarrotDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhipCarrotController {
	
	@Autowired private UserRepository userRepository;
	
	@GetMapping(value="/test", produces=MediaType.APPLICATION_JSON_VALUE)
	public String testAd() {
		return "{\"connect: \" success}";
	}
	
	// 당근 개수 호출
	@GetMapping(value="/{user_id}/carrot", produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserCarrot(@PathVariable String user_id) {
		User user = userRepository.findByUserId(user_id);
		
		userRepository.save(user);
		
		return user;
	}
	
	// 당근 개수 변경
	@PostMapping(value="/{user_id}/carrot_up", produces=MediaType.APPLICATION_JSON_VALUE)
	public void setUserCarrot(@PathVariable String user_id) {
		User user = userRepository.findByUserId(user_id);
		
		user.setCarrot(user.getCarrot()+1);
		
		userRepository.save(user);
	}
	
	
	@PostMapping(value="/create_user", produces=MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestParam(value="user_id") String user_id,
						   @RequestParam(value="user_pw") String user_pw,
						   @RequestParam(value="nickname") String nickname) {
		System.out.println("Create User");
		User user = new User(user_id,user_pw,nickname,0);
		userRepository.save(user);
		return user;
	}
	
}
