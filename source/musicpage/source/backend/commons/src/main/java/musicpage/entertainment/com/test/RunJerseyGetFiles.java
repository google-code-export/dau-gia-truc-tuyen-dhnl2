package musicpage.entertainment.com.test;

import java.io.IOException;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RunJerseyGetFiles {
	static String CODE = "4/YTzAIUoZ0bvymIL6vayNKArcCCdm.8s8Hd_xSZqARgrKXntQAax2EqRo9fQI";
	static String ACCESS_TOKEN = "ya29.AHES6ZQATdYFDJUAs34pkL6FnRtGFrYVIVUPjbZmyIUopStL58_NaBY";						
	/** OAuth 2 scope. */
	private static final String SCOPE = "https://www.googleapis.com/auth/drive.file";

	/** Global instance of the HTTP transport. */
	private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

	/** Global instance of the JSON factory. */
	static final JsonFactory JSON_FACTORY = new JacksonFactory();

	private static final String TOKEN_SERVER_URL = "https://accounts.google.com/o/oauth2/token";
	private static final String AUTHORIZATION_SERVER_URL = "https://accounts.google.com/o/oauth2/auth";
	private static final String REDIRECT_URI = "http://127.0.0.1:8080/Callback";

	public static void main(String[] args) throws IOException {
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource("https://www.googleapis.com/drive/v2/files?access_token=".concat(ACCESS_TOKEN));
 
		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);
 
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
 
		String output = response.getEntity(String.class);
 
		System.out.println("Output from Server .... \n");
		System.out.println(output);

	}
}
