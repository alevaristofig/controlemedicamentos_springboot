package com.controlemedicamentos.core.security;

import java.util.Set;

import com.controlemedicamentos.core.security.OAuth2AuthorizationGrantAuthorization.AbstractToken.AccessToken;
import com.controlemedicamentos.core.security.OAuth2AuthorizationGrantAuthorization.AbstractToken.AccessToken.RefreshToken;


public class OAuth2ClientCredentialsGrantAuthorization extends OAuth2AuthorizationGrantAuthorization {

	public OAuth2ClientCredentialsGrantAuthorization(String id, String registeredClientId, String principalName,
			Set<String> authorizedScopes, AccessToken accessToken, RefreshToken refreshToken) {
		super(id, registeredClientId, principalName, authorizedScopes, accessToken, refreshToken);
	}
}
