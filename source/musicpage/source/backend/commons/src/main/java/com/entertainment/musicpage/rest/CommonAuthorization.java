package com.entertainment.musicpage.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.entertainment.musicpage.common.Configuration;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("/authorize")
public class CommonAuthorization {

	@GET
	@Path("/printaccesstoken")
	public Response printAccessToken() throws URISyntaxException {
		Properties pr = Configuration.getProperties();
		String [] scopes = pr.getProperty("drive.cope").split(",");
		String authorizationUrl = new AuthorizationCodeRequestUrl(
				pr.getProperty("authorization.server.url"), pr.getProperty("client.id.google")).setRedirectUri(pr.getProperty("redirect.uri"))
				.setScopes(Arrays.asList(scopes)).set("access_type", "offline").set("approval_prompt", "force").build();
		return Response.temporaryRedirect(new URI(authorizationUrl)).build();
	}

	/**
	 * this callback use to generate accestoken after get code
	 * @throws IOException 
	 */
	@GET
	@Path("/callback")
	public Response callback(@QueryParam("code") String code) throws IOException{
		Properties pr = Configuration.getProperties();
		HttpTransport httpTransport = new NetHttpTransport();
		JsonFactory jsfactory = new JacksonFactory();
		String [] scopes = pr.getProperty("drive.cope").split(",");
		AuthorizationCodeFlow codeFlow = new AuthorizationCodeFlow.Builder(
				BearerToken.authorizationHeaderAccessMethod(), httpTransport,
				jsfactory, new GenericUrl(pr.getProperty("token.server.url")),
				new ClientParametersAuthentication(
						pr.getProperty("client.id.google"),
						pr.getProperty("client.secret.google")),
						pr.getProperty("client.id.google"), 
						pr.getProperty("authorization.server.url"))
				.setScopes(Arrays.asList(scopes)).build();
		AuthorizationCodeTokenRequest authtokreq  = codeFlow.newTokenRequest(code)
		.setRedirectUri(pr.getProperty("redirect.uri"))
		.setScopes(Arrays.asList(scopes));
		 TokenResponse response = authtokreq.execute();
		String accessToken = response.getAccessToken();
		String responseS = " access token ".concat(accessToken).concat(" \r\n refresh token ".concat(response.getRefreshToken()));
		return Response.status(200).entity(responseS).build();
	}
	
	@GET
	@Path("/refreshtoken")
	public Response refreshToken() throws IOException{
		Properties pr = Configuration.getProperties();
		HttpTransport httpTransport = new NetHttpTransport();
		JsonFactory jsfactory = new JacksonFactory();
		String [] scopes = pr.getProperty("drive.cope").split(",");
		
		String refreshTokenUrl = new AuthorizationCodeRequestUrl(pr.getProperty("token.server.url"), pr.getProperty("client.id.google"))
									.set("refresh_token", pr.getProperty("tuanlhdnl.refresh.token"))
									.set("client_secret", pr.getProperty("client.secret.google"))
									.set("grant_type", "refresh_token").build();
		
		AuthorizationCodeFlow codeFlow;
		
		
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource(pr.getProperty("token.server.url"));
		webResource.setProperty("refresh_token", pr.getProperty("tuanlhdnl.refresh.token"));
		webResource.setProperty("client_secret", pr.getProperty("client.secret.google"));
		webResource.setProperty("grant_type", "refresh_token");
		webResource.setProperty("client_id", pr.getProperty("client.id.google"));
		
		ClientResponse response = webResource
                   .post(ClientResponse.class);
		return Response.status(200).entity(response.getEntity(String.class)).build();
		
	}
}
