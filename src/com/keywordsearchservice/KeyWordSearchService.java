package com.keywordsearchservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

@Path("/SearchService")

public class KeyWordSearchService {

	private static Logger logger = Logger.getLogger(KeyWordSearchService.class.getName());

	@GET
	@Path("/keywordSearch/{searchString}")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getValues(@PathParam("searchString") String keyWord) throws Exception {
		logger.info("service started and running");
		ObjectMapper objectMapper = new ObjectMapper();
		//logger.info(KeyWordSearchDAO.getValuesByKeyWord(keyWord).toString());
		return objectMapper.writeValueAsString(KeyWordSearchDAO.getValuesByKeyWord(keyWord));
	}

	@GET
	@Path("/{param}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ArrayList<String> print(@PathParam("param") String s) {
		ArrayList<String> a = new ArrayList<String>();
		a.add(s);
		a.add("udahy");

		return a;
	}
}
