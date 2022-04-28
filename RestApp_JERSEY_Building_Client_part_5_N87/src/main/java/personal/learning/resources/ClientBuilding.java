package personal.learning.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/testClient")
public class ClientBuilding {
	
	@GET
	@Path("/test")
	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	public Brand[] test() {
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("http://localhost:8080/RestApp_JERSEY_HATEOAS_part_4_N77/showroom/brand");
		//WebTarget extendedUrl = baseUrl.path("{brandId}");
		//WebTarget finalUrl = extendedUrl.resolveTemplate("brandId", brandId);
		Builder builder = baseUrl.request(MediaType.APPLICATION_JSON);
		Brand[] response = builder.get(Brand[].class);
		return response;
	}
}
