package com.abeldevelop.courses.clients.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.abeldevelop.courses.clients.model.UserEntity;
import com.abeldevelop.courses.clients.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class InfoAditionalToken implements TokenEnhancer {

	private final UserService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		UserEntity userEntity = userService.findByUsername(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		info.put("name", userEntity.getName());
		info.put("surname", userEntity.getSurname());
		info.put("email", userEntity.getEmail());
		((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(info);
		return accessToken;
	}
	
}
