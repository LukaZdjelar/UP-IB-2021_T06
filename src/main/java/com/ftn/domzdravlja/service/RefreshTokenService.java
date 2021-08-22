package com.ftn.domzdravlja.service;

import com.ftn.domzdravlja.model.RefreshToken;

import com.ftn.domzdravlja.model.RefreshToken;

public interface RefreshTokenService {
	
    RefreshToken findByToken(String token);

    RefreshToken createRefreshToken(Integer userId);

    RefreshToken verifyExpiration(RefreshToken token);
}
