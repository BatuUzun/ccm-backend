package com.foodrecipes.profileapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.foodrecipes.profileapi.constants.Constants;
import com.foodrecipes.profileapi.entity.UserProfile;
import com.foodrecipes.profileapi.proxy.Amazons3Proxy;
import com.foodrecipes.profileapi.proxy.ProfileRecipeProxy;
import com.foodrecipes.profileapi.response.ResultResponse;
import com.foodrecipes.profileapi.service.UserProfileService;

@RestController
@RequestMapping("/profile-api")
public class ProfileController {
	
	@Autowired
	private Amazons3Proxy profileProxy;
	
	@Autowired
	private ProfileRecipeProxy profileRecipeProxy;
	
	
	@Autowired
    private UserProfileService userProfileService;
	
	@PostMapping("/change-profile-picture")
	public String changeProfilePicture(@RequestParam("file") MultipartFile file, @RequestParam("userId") Long userProfileId) {
		ResultResponse response = null;
		UserProfile userProfile = userProfileService.getUserProfileById(userProfileId);
		if(userProfile != null) {
			String currentPP = userProfile.getProfilePicture();
			if(!currentPP.equals(Constants.DEFAULT_PROFILE_IMAGE)) {
				profileProxy.delete(currentPP);
			}
			
			response = profileProxy.upload(file);
		    
		    String imageName = "";
		    if (response.getResult() instanceof String) {
		        imageName = (String) response.getResult();
		    }
		    userProfileService.updateProfilePicture(userProfileId, imageName);
		    // You can now use imageName as needed
		    System.out.println("Uploaded image name: " + imageName);
		    System.out.println("User ID: " + userProfileId);
		    return imageName;
		}
	    return "";
	}
	
	
	
	
	
	@GetMapping("/get-user-profile-by-email/")
	public ResponseEntity<UserProfile> getUserProfileByEmail(@RequestParam String email) {
        UserProfile userProfile = userProfileService.getUserProfileByEmail(email);
        if (userProfile != null) {
            return ResponseEntity.ok(userProfile);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
	
	@GetMapping("/is-user-exist-by-id/")
	public Boolean isUserExistById(@RequestParam Long id) {
        return userProfileService.isUserProfileExist(id);
        
    }
	
	@GetMapping("/get-user-profile/{id}")
	public UserProfile getUserProfileById(@PathVariable("id") Long id) {
        return userProfileService.getUserProfileById(id);
    }
	
	
	
	@GetMapping("/{userId}/profile-picture")
    public ResponseEntity<String> getProfilePicture(@PathVariable Long userId) {
        String profilePicture = userProfileService.getProfilePictureByUserId(userId);
        return profilePicture != null 
            ? ResponseEntity.ok(profilePicture) 
            : ResponseEntity.notFound().build(); // Return 404 if not found
    }
	
	
	
	

}
