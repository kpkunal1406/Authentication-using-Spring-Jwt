//package com.gen.api.integration.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class OauthController {
//	@Autowired
//	private TokenStore tokenStore;
//
//	@RequestMapping(value = "/oauth/revoke-token", method = RequestMethod.POST)
//	public void logout(HttpServletRequest request) {
//		request.getHeaderNames();
//		String authHeader = request.getHeader("Authorization");
//		if (authHeader != null) {
//			String tokenValue = authHeader.replace("Bearer", "").trim();
//			OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
//			tokenStore.removeAccessToken(accessToken);
//		}
//	}
//
//}
