package com.citoyenaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citoyenaction.domain.User;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {

}
