package br.com.smartzig.rest.service.basic;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.smartzig.rest.service.basic.bo.facade.BasicFacade;

@Path("rest/basicservice")
public class BasicService {
	Map<String, Integer> basicPorcentageChartModel;


	@GET
	@Path("/greeting")
	public Response greeting(@QueryParam("param") String name, @Context HttpServletResponse response, 
			@Context HttpServletRequest request) throws Exception {


		String result = "Come to the Dark Side, " + name+ ".";

		return Response.status(200).entity(result).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/basicchart")
	public String countChartGroupedByTypeToChart(@QueryParam("dtInitial") String dtInitialJson, @QueryParam("dtFinal") String dtFinalJson,
			@Context HttpServletResponse response, @Context HttpServletRequest request) throws Exception {	

		Gson gson = new Gson();
		response.addHeader("Access-Control-Allow-Origin", "*");

		BasicFacade facade = new BasicFacade();

		try {

			basicPorcentageChartModel = facade.fetchMockUpInfo();


		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsonResult = gson.toJson(basicPorcentageChartModel);

		return jsonResult;
	}

}
