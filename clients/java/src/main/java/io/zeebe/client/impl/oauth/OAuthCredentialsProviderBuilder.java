/*
 * Copyright © 2017 camunda services GmbH (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.zeebe.client.impl.oauth;

import io.zeebe.client.util.Environment;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

public final class OAuthCredentialsProviderBuilder {
  public static final String INVALID_ARGUMENT_MSG = "Expected valid %s but none was provided.";
  public static final String OAUTH_ENV_CLIENT_ID = "ZEEBE_CLIENT_ID";
  public static final String OAUTH_ENV_CLIENT_SECRET = "ZEEBE_CLIENT_SECRET";
  public static final String OAUTH_ENV_TOKEN_AUDIENCE = "ZEEBE_TOKEN_AUDIENCE";
  public static final String OAUTH_ENV_AUTHORIZATION_SERVER = "ZEEBE_AUTHORIZATION_SERVER_URL";
  public static final String OAUTH_ENV_CACHE_PATH = "ZEEBE_CLIENT_CONFIG_PATH";
  private static final String DEFAULT_AUTHZ_SERVER = "https://login.cloud.camunda.io/oauth/token/";

  private String clientId;
  private String clientSecret;
  private String audience;
  private String authorizationServerUrl;
  private URL authorizationServer;
  private String credentialsCachePath;
  private File credentialsCache;

  /** Client id to be used when requesting access token from OAuth authorization server. */
  public OAuthCredentialsProviderBuilder clientId(final String clientId) {
    this.clientId = clientId;
    return this;
  }

  /** @see OAuthCredentialsProviderBuilder#clientId(String) */
  String getClientId() {
    return clientId;
  }

  /** Client secret to be used when requesting access token from OAuth authorization server. */
  public OAuthCredentialsProviderBuilder clientSecret(final String clientSecret) {
    this.clientSecret = clientSecret;
    return this;
  }

  /** @see OAuthCredentialsProviderBuilder#clientSecret(String) */
  String getClientSecret() {
    return clientSecret;
  }

  /** The resource for which the the access token should be valid. */
  public OAuthCredentialsProviderBuilder audience(final String audience) {
    this.audience = audience;
    return this;
  }

  /** @see OAuthCredentialsProviderBuilder#audience(String) */
  String getAudience() {
    return audience;
  }

  /** The authorization server's URL, from which the access token will be requested. */
  public OAuthCredentialsProviderBuilder authorizationServerUrl(
      final String authorizationServerUrl) {
    this.authorizationServerUrl = authorizationServerUrl;
    return this;
  }

  /** @see OAuthCredentialsProviderBuilder#authorizationServerUrl(String) */
  URL getAuthorizationServer() {
    return authorizationServer;
  }

  /**
   * The location for the credentials cache file. If none (or null) is specified the default will be
   * $HOME/.camunda/credentials
   */
  public OAuthCredentialsProviderBuilder credentialsCachePath(final String cachePath) {
    this.credentialsCachePath = cachePath;
    return this;
  }

  /** @see OAuthCredentialsProviderBuilder#credentialsCachePath(String) */
  File getCredentialsCache() {
    return credentialsCache;
  }

  /** @return a new {@link OAuthCredentialsProvider} with the provided configuration options. */
  public OAuthCredentialsProvider build() {
    checkEnvironmentOverrides();
    applyDefaults();

    validate();
    return new OAuthCredentialsProvider(this);
  }

  private void checkEnvironmentOverrides() {
    final String envClientId = Environment.system().get(OAUTH_ENV_CLIENT_ID);
    final String envClientSecret = Environment.system().get(OAUTH_ENV_CLIENT_SECRET);
    final String envAudience = Environment.system().get(OAUTH_ENV_TOKEN_AUDIENCE);
    final String envAuthorizationUrl = Environment.system().get(OAUTH_ENV_AUTHORIZATION_SERVER);
    final String envCachePath = Environment.system().get(OAUTH_ENV_CACHE_PATH);

    if (envClientId != null) {
      clientId = envClientId;
    }

    if (envClientSecret != null) {
      clientSecret = envClientSecret;
    }

    if (envAudience != null) {
      audience = envAudience;
    }

    if (envAuthorizationUrl != null) {
      authorizationServerUrl = envAuthorizationUrl;
    }

    if (envCachePath != null) {
      credentialsCachePath = envCachePath;
    }
  }

  private void applyDefaults() {
    if (credentialsCachePath == null) {
      credentialsCachePath =
          Paths.get(System.getProperty("user.home"), ".camunda", "credentials")
              .toAbsolutePath()
              .toString();
    }

    if (authorizationServerUrl == null) {
      authorizationServerUrl = DEFAULT_AUTHZ_SERVER;
    }
  }

  private void validate() {
    try {
      Objects.requireNonNull(clientId, String.format(INVALID_ARGUMENT_MSG, "client id"));
      Objects.requireNonNull(clientSecret, String.format(INVALID_ARGUMENT_MSG, "client secret"));
      Objects.requireNonNull(audience, String.format(INVALID_ARGUMENT_MSG, "audience"));
      Objects.requireNonNull(
          authorizationServerUrl, String.format(INVALID_ARGUMENT_MSG, "authorization server URL"));

      authorizationServer = new URL(authorizationServerUrl);
      credentialsCache = new File(credentialsCachePath);

      if (credentialsCache.isDirectory()) {
        throw new IllegalArgumentException(
            "Expected specified credentials cache to be a file but found directory instead.");
      }
    } catch (final NullPointerException | IOException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
