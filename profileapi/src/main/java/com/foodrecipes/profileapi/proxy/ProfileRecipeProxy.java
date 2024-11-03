package com.foodrecipes.profileapi.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "profile-api")
public interface ProfileRecipeProxy {
	
	@GetMapping("/profile-api/profile/profile-images/")
    public long countRecipesByOwnerId(@RequestParam("ownerId") Long ownerId);
    
	
}
