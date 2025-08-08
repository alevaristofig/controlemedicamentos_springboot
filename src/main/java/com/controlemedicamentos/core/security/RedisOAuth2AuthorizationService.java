package com.controlemedicamentos.core.security;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.util.Assert;

public class RedisOAuth2AuthorizationService implements OAuth2AuthorizationService {
	
	private final RedisTemplate<String, Object> redisTemplate;
	private final String KEY_PREFIX = "oauth2:auth";
	//private final OAuth2AuthorizationGrantAuthorizationRepository authorizationGrantAuthorizationRepository;
		

	public RedisOAuth2AuthorizationService(RedisTemplate<String, Object> redisTemplate) {
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
		return (OAuth2Authorization) redisTemplate.opsForValue().get(KEY_PREFIX + id);
	}

	@Override
	public OAuth2Authorization findByToken(String token, OAuth2TokenType tokenType) {	
		/*Assert.hasText(token, "Token não pode ser vazio");
		
		OAuth2AuthorizationGrantAuthorization authorizationGrantAuthorization = null;
		
		if (tokenType == null) {
			authorizationGrantAuthorization = this.authorizationGrantAuthorizationRepository
				.findByStateOrAuthorizationCode_TokenValue(token, token);
			if (authorizationGrantAuthorization == null) {
				authorizationGrantAuthorization = this.authorizationGrantAuthorizationRepository
						.findByAccessToken_TokenValueOrRefreshToken_TokenValue(token, token);
			}
			if (authorizationGrantAuthorization == null) {
				authorizationGrantAuthorization = this.authorizationGrantAuthorizationRepository
						.findByIdToken_TokenValue(token);
			}
			if (authorizationGrantAuthorization == null) {
				authorizationGrantAuthorization = this.authorizationGrantAuthorizationRepository
						.findByDeviceStateOrDeviceCode_TokenValueOrUserCode_TokenValue(token, token, token);
			}
		}*/
		
		return null;
	}

}
