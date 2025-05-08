package com.controlemedicamentos.core.security.domain;

import java.security.Principal;
import java.time.Instant;
import java.util.Set;

import org.springframework.data.redis.core.index.Indexed;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

import com.controlemedicamentos.core.security.domain.OAuth2AuthorizationGrantAuthorization.AbstractToken.AccessToken;
import com.controlemedicamentos.core.security.domain.OAuth2AuthorizationGrantAuthorization.AbstractToken.AccessToken.RefreshToken;

public class OAuth2AuthorizationCodeGrantAuthorization extends OAuth2AuthorizationGrantAuthorization {

	private final Principal principal;
	
	private final OAuth2AuthorizationRequest authorizationRequest;
	
	private final AuthorizationCode authorizationCode;
	
	@Indexed
	private final String state;

	public OAuth2AuthorizationCodeGrantAuthorization(String id, String registeredClientId, String principalName,
			Set<String> authorizedScopes, AccessToken accessToken, RefreshToken refreshToken, Principal principal,
			OAuth2AuthorizationRequest authorizationRequest, AuthorizationCode authorizationCode, String state) {
		super(id, registeredClientId, principalName, authorizedScopes, accessToken, refreshToken);
		this.principal = principal;
		this.authorizationRequest = authorizationRequest;
		this.authorizationCode = authorizationCode;
		this.state = state;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public OAuth2AuthorizationRequest getAuthorizationRequest() {
		return authorizationRequest;
	}

	public AuthorizationCode getAuthorizationCode() {
		return authorizationCode;
	}

	public String getState() {
		return state;
	}
	
	public static class AuthorizationCode extends AbstractToken {

		public AuthorizationCode(String tokenValue, Instant issuedAt, Instant expiresAt, boolean invalidated) {
			super(tokenValue, issuedAt, expiresAt, invalidated);
		}
		
	}
}
