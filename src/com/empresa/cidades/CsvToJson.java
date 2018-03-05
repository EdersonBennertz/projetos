package com.empresa.cidades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class CsvToJson {
	
	Utils util = new Utils();

	CsvToJson() {

	}
	
	public String retornaJSON() throws FileNotFoundException, JSONException {
		int i;
		String linha = "";
		BufferedReader fileReader = util.carregaArquivo("src\\Trabalho Java - Cidades.csv");
	
		
		boolean inicio = true;
		ArrayList<String> cabecalho = new ArrayList<String>();
		JSONObject jsObject = new JSONObject();
		try {
			while ((linha = fileReader.readLine()) != null) {

				i = 0;
				String[] tokens = linha.split(",");
				if (inicio) {

					for (String token : tokens) {
						if (token.startsWith("\"")) {
							token = token.substring(1);
						}
						if (token.endsWith("\"")) {
							token = token.substring(0, token.length() - 1);
						}
						cabecalho.add(token);
					}
					inicio = false;
					continue;

				}
			
				for (String token : tokens) {
					if (token.startsWith("\"")) {
						token = token.substring(1);
					}
					if (token.endsWith("\"")) {
						token = token.substring(0, token.length() - 1);
					}

					jsObject.put(cabecalho.get(i).toString(), token);
					//System.out.println(jsObject);
					i++;
					if (i == cabecalho.size())
						break;

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsObject.toString();  
	
	}
	

	public static void main(String[] args) throws FileNotFoundException, JSONException {
		new CsvToJson().retornaJSON();
	}

	  
	  
	  
	  
	  
	  
}
