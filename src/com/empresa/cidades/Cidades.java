package com.empresa.cidades;

import java.io.FileNotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONException;


@Path("/Cidades")
public class Cidades{
	

	@GET
	@Path("/retCidades")
	@Produces("application/json")
	public String retornaCidadesCapitaisOrdenadas() throws JSONException, FileNotFoundException {
		CsvToJson js = new CsvToJson();
		js.retornaJSON();

		 
		 
		 return js.retornaJSON();

		
	}
	
	
	
	
	
	
	
	
}
