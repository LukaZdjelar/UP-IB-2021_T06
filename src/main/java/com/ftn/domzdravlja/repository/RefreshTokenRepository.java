package com.ftn.domzdravlja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.RefreshToken; 


public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{

    RefreshToken findByToken (String token);

}
