package com.empresa.cidades;

import java.io.IOException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class CsvToJsonTeste {

	public String getJsonText() {
	
	String jsonText = "{\"Cidades\": [" +
	        "{\"name\":["
	        + "{\"name\": \"Braslia\"},"
	        + "{\"Cidades\": \"Braslia\"}"
	        + "]},"
	        + "{\"capital\":["
	        + "{\"capital\": \"true\"},"
	        + "{\"Cidades\": \"Braslia\"} "
	        + "]},"
	        + "{\"uf\":["
	        + "{\"uf\": \"DF\"},"
	        + "{\"Cidades\": \"Braslia\"}"
	        + "]}"
	        + "]"
	        + "}";
	
	return jsonText;
	}

	
	
	  public static void main(String[] args) throws IOException, JSONException {
		  CsvToJsonTeste teste = new CsvToJsonTeste();
		  
		  
		  try {
			    JSONObject jObj = new JSONObject( teste.getJsonText() );
			    JSONArray jArrayCidades = jObj.getJSONArray( "Cidades" );
			    for ( int i = 0; i < jArrayCidades.length(); i++ ) {
			        JSONObject jo = jArrayCidades.getJSONObject( i );
			        JSONArray jArrayCapital = jo.optJSONArray("capital");
			        for ( int j = 0; j < jArrayCapital.length(); j++ ) {
			        	 JSONObject joi = jArrayCapital.getJSONObject( j );
			        	//System.out.println(jArrayCapital.get(j));
			        	
			        
			        }
			    }
			} catch ( JSONException exc ) {
			    exc.printStackTrace();
			}
	     
	        
	  
	  }

	  
	  
	  
	  
	
	
}
