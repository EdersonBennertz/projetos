package com.empresa.cidades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Utils {

	public BufferedReader carregaArquivo(String path) throws FileNotFoundException {
		BufferedReader fileReader = new BufferedReader(new FileReader(path));
		return fileReader;
	}
	
	
	
}
