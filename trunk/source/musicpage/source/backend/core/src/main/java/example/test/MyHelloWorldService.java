package example.test;
 
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
 
@Path("/hello2")
public class MyHelloWorldService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	@POST
	@Path("/maptest")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testMappingService(TestXMObject testxmlobj) throws JsonGenerationException, JsonMappingException, IOException{
		
		String output = "Jersey say : " + new ObjectMapper().writeValueAsString(testxmlobj);
		
		return Response.status(401).entity(output).build();
	}
}