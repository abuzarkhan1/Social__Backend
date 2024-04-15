package com.social.webdevproject.controller;

import com.social.webdevproject.models.Reels;
import com.social.webdevproject.models.User;
import com.social.webdevproject.service.ReelService;
import com.social.webdevproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReelsController {

    @Autowired
    private ReelService reelService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/reels")
    public Reels createReels(@RequestBody Reels reel,@RequestHeader("Authorization") String jwt){

        User reqUser = userService.findUserByJwt(jwt);
        Reels createdReels = reelService.createReel(reel, reqUser);

        return createdReels;
    }

    @GetMapping("/api/reels/user/{userId}")
    public List<Reels> findAllReels(@PathVariable Integer userId) throws Exception {
        List<Reels> reels = reelService.findUsersReel(userId);
        return reels;
    }
}
