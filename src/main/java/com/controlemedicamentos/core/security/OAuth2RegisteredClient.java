package com.controlemedicamentos.core.security;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.jose.jws.JwsAlgorithm;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

@RedisHash("oauth2_registered_client")
public class OAuth2RegisteredClient {

	@Id
	private final String id;
	
	@Indexed
	private final String clientId;
	
	private final Instant clientIdIssuedAt;
	
	private final String clientSecret;
	
	private final Instant clientSecretExpiresAt;
	
	private final String clientName;
	
	private final Set<ClientAuthenticationMethod> clientAuthenticationMethods;
	
	private final Set<AuthorizationGrantType> authorizationGrantTypes;
	
	private final Set<String> redirectUris;
	
	private final Set<String> postLogoutRedirectUris;
	
	private final Set<String> scopes;
	
	private final ClientSettings clientSettings;
	
	private final TokenSettings tokenSettings;

	public OAuth2RegisteredClient(String id, String clientId, Instant clientIdIssuedAt, String clientSecret,
			Instant clientSecretExpiresAt, String clientName,
			Set<ClientAuthenticationMethod> clientAuthenticationMethods,
			Set<AuthorizationGrantType> authorizationGrantTypes, Set<String> redirectUris,
			Set<String> postLogoutRedirectUris, Set<String> scopes, ClientSettings clientSettings,
			TokenSettings tokenSettings) {
		
		this.id = id;
		this.clientId = clientId;
		this.clientIdIssuedAt = clientIdIssuedAt;
		this.clientSecret = clientSecret;
		this.clientSecretExpiresAt = clientSecretExpiresAt;
		this.clientName = clientName;
		this.clientAuthenticationMethods = clientAuthenticationMethods;
		this.authorizationGrantTypes = authorizationGrantTypes;
		this.redirectUris = redirectUris;
		this.postLogoutRedirectUris = postLogoutRedirectUris;
		this.scopes = scopes;
		this.clientSettings = clientSettings;
		this.tokenSettings = tokenSettings;
	}

	public String getId() {
		return id;
	}

	public String getClientId() {
		return clientId;
	}

	public Instant getClientIdIssuedAt() {
		return clientIdIssuedAt;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public Instant getClientSecretExpiresAt() {
		return clientSecretExpiresAt;
	}

	public String getClientName() {
		return clientName;
	}

	public Set<ClientAuthenticationMethod> getClientAuthenticationMethods() {
		return clientAuthenticationMethods;
	}

	public Set<AuthorizationGrantType> getAuthorizationGrantTypes() {
		return authorizationGrantTypes;
	}

	public Set<String> getRedirectUris() {
		return redirectUris;
	}

	public Set<String> getPostLogoutRedirectUris() {
		return postLogoutRedirectUris;
	}

	public Set<String> getScopes() {
		return scopes;
	}

	public ClientSettings getClientSettings() {
		return clientSettings;
	}

	public TokenSettings getTokenSettings() {
		return tokenSettings;
	}
	
	public static class ClientSettings {
		
		private final boolean requireProofKey;
		
		private final boolean requireAuthorizationConsent;
		
		private final String jwkSetUrl;
		
		private final JwsAlgorithm tokenEndpointAuthenticationSigningAlgorithm;
		
		private final String x509CertificateSubjectDN;

		public ClientSettings(boolean requireProofKey, boolean requireAuthorizationConsent, String jwkSetUrl,
				JwsAlgorithm tokenEndpointAuthenticationSigningAlgorithm, String x509CertificateSubjectDN) {
			
			this.requireProofKey = requireProofKey;
			this.requireAuthorizationConsent = requireAuthorizationConsent;
			this.jwkSetUrl = jwkSetUrl;
			this.tokenEndpointAuthenticationSigningAlgorithm = tokenEndpointAuthenticationSigningAlgorithm;
			this.x509CertificateSubjectDN = x509CertificateSubjectDN;
		}

		public boolean isRequireProofKey() {
			return requireProofKey;
		}

		public boolean isRequireAuthorizationConsent() {
			return requireAuthorizationConsent;
		}

		public String getJwkSetUrl() {
			return jwkSetUrl;
		}

		public JwsAlgorithm getTokenEndpointAuthenticationSigningAlgorithm() {
			return tokenEndpointAuthenticationSigningAlgorithm;
		}

		public String getX509CertificateSubjectDN() {
			return x509CertificateSubjectDN;
		}				
	}
	
	public static class TokenSettings {
		
		private final Duration authorizationCodeTimeToLive;
		
		private final Duration accessTokenTimeToLive;
		
		private final OAuth2TokenFormat accessTokenFormat;
		
		private final Duration deviceCodeTimeToLive;
		
		private final boolean reuseRefreshTokens;
		
		private final Duration refreshTokenTimeToLive;
		
		private final boolean x509CertificateBoundAccessTokens;

		public TokenSettings(Duration authorizationCodeTimeToLive, Duration accessTokenTimeToLive,
				OAuth2TokenFormat accessTokenFormat, Duration deviceCodeTimeToLive, boolean reuseRefreshTokens,
				Duration refreshTokenTimeToLive, boolean x509CertificateBoundAccessTokens) {
			
			this.authorizationCodeTimeToLive = authorizationCodeTimeToLive;
			this.accessTokenTimeToLive = accessTokenTimeToLive;
			this.accessTokenFormat = accessTokenFormat;
			this.deviceCodeTimeToLive = deviceCodeTimeToLive;
			this.reuseRefreshTokens = reuseRefreshTokens;
			this.refreshTokenTimeToLive = refreshTokenTimeToLive;
			this.x509CertificateBoundAccessTokens = x509CertificateBoundAccessTokens;
		}

		public Duration getAuthorizationCodeTimeToLive() {
			return authorizationCodeTimeToLive;
		}

		public Duration getAccessTokenTimeToLive() {
			return accessTokenTimeToLive;
		}

		public OAuth2TokenFormat getAccessTokenFormat() {
			return accessTokenFormat;
		}

		public Duration getDeviceCodeTimeToLive() {
			return deviceCodeTimeToLive;
		}

		public boolean isReuseRefreshTokens() {
			return reuseRefreshTokens;
		}

		public Duration getRefreshTokenTimeToLive() {
			return refreshTokenTimeToLive;
		}

		public boolean isX509CertificateBoundAccessTokens() {
			return x509CertificateBoundAccessTokens;
		}				
	}
}
