
package com.google.api.services.samples.dailymotion.cmdline;

/**
 * OAuth 2 credentials found in the <a href="http://www.dailymotion.com/profile/developer">
 * Developer Profile Page</a>.
 *
 * <p>
 * Once at the Developer Profile page, you will need to create a Daily Motion account if you do not
 * already have one. Click on "Create a new API Key". Enter "http://127.0.0.1:8080/Callback" under
 * "Callback URL" and select "Native Application" under "Application Profile". Enter a port number
 * other than 8080 if that is what you intend to use.
 * </p>
 *
 * @author Ravi Mistry
 */
public class OAuth2ClientCredentials {

  /** Value of the "API Key". */
  public static final String CLIENT_ID = "600206105823-1e3ekce7tt62hnjq0mel8mo5765iaias.apps.googleusercontent.com";

  /** Value of the "API Secret". */
  public static final String CLIENT_SECRET = "w6BQm0Um_cFSAI9i8V-eKBx_";

  public static void errorIfNotSpecified() {
    if (CLIENT_ID == null || CLIENT_SECRET == null) {
      System.err.println(
          "Please enter your client ID and secret in " + OAuth2ClientCredentials.class);
      System.exit(1);
    }
  }
}