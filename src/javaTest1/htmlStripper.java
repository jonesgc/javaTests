package javaTest1;

import java.io.*;
import java.io.BufferedReader;

public class htmlStripper {
	
	String file= "";
	
	public htmlStripper(){
		
	}
	
	//Read the file into a string.
	public String read(String path) throws FileNotFoundException, IOException {
		
		BufferedReader reader = new BufferedReader( new FileReader(path));
		
		String tempLine= "";
		
		while ((tempLine = reader.readLine()) != null){
			file = file + tempLine;
		}
		reader.close();
		display(file);
		return file;
	}
	
	private void display(String data) {
		System.out.println(data);
	}
	
}
