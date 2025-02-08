package com.microservice.gatewayserver.oauth;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/oauth2")
public class OAuthController {

    @GetMapping("/token")
    public Mono<OAuth2AccessToken> getAccessToken(@RegisteredOAuth2AuthorizedClient("keycloak") OAuth2AuthorizedClient oAuth2AuthorizedClient) {
        OAuth2AccessToken accessToken = oAuth2AuthorizedClient.getAccessToken();
        return Mono.just(accessToken);
    }
}
