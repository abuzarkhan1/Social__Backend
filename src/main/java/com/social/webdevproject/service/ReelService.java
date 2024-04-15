package com.social.webdevproject.service;

import com.social.webdevproject.models.Reels;
import com.social.webdevproject.models.User;

import java.util.List;

public interface ReelService {

    public Reels createReel(Reels reel, User user);

    public List<Reels> findAllReels();

    public List<Reels> findUsersReel(Integer userId) throws Exception;
}
