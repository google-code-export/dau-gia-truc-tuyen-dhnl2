package musicpage.entertainment.com.test;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;


public class TestGoogleClientApi {
	private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport(); 
	private static JsonFactory JSON_FACTORY = new JacksonFactory();   	
	private static String CLIENT_ID = "600206105823.apps.googleusercontent.com";
	private static String CLIENT_SECRET = "600206105823.apps.googleusercontent.com";
	
	public static void main(String[] args) {
		/**
		// Set up the HTTP transport and JSON factory
		HttpTransport httpTransport = new NetHttpTransport();
		JsonFactory jsonFactory = new JacksonFactory();

		// Set up OAuth 2.0 access of protected resources
		// using the refresh and access tokens, automatically
		// refreshing the access token when it expires
		Credential credential = new Credential.Builder(accessMethod)
		    .setJsonFactory(jsonFactory)
		    .setTransport(httpTransport)
		    .setTokenServerEncodedUrl(tokenServerEncodedUrl)
		    .setClientAuthentication(clientAuthentication)
		    .setRequestInitializer(requestInitializer)
		    .build();

		// Set up the main Google+ class
		Plus plus = new Plus(httpTransport, jsonFactory, credential);

		// Make a request to access your profile and display it to console
		Person profile = plus.people().get("me").execute();
		System.out.println("ID: " + profile.getId());
		System.out.println("Name: " + profile.getDisplayName());
		System.out.println("Image URL: " + profile.getImage().getUrl());
		System.out.println("Profile URL: " + profile.getUrl());
		*/
//		GoogleAuthorizationCodeTokenRequest newTokenRequest = new GoogleAuthorizationCodeFlow.Builder(
//				new NetHttpTransport(), new JacksonFactory(), "clientId", "clientSecret",
//				Collections.singleton("https://gdata.youtube.com"))).build().newTokenRequest(
//				req.getParameter("code"));
		AuthorizationCodeFlow fl ;
		// authorization
	    
	}
	
}
