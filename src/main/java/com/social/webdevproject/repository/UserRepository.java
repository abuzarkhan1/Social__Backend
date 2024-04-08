package com.social.webdevproject.repository;

import com.social.webdevproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{

}
