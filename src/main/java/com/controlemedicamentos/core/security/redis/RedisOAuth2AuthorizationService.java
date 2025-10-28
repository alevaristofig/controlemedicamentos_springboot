package com.controlemedicamentos.core.security.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;

public class RedisOAuth2AuthorizationService implements OAuth2AuthorizationService {
	
	private final RedisTemplate<String, OAuth2Authorization> redisTemplate;
	private final String KEY_PREFIX = "oauth2:auth";
	
	public RedisOAuth2AuthorizationService(RedisTemplate<String, OAuth2Authorization> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void save(OAuth2Authorization authorization) {
		redisTemplate.opsForValue().set(KEY_PREFIX + authorization.getId(), authorization);		
	}

	@Override
	public void remove(OAuth2Authorization authorization) {
		redisTemplate.delete(KEY_PREFIX + authorization.getId());
	}

	@Override
	public OAuth2Authorization findById(String id) {		
		return redisTemplate.opsForValue().get(KEY_PREFIX + id);
	}

	@Override
	public OAuth2Authorization findByToken(String token, OAuth2TokenType tokenType) {
		// TODO Auto-generated method stub
		return null;
	}

}
