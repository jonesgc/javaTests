package javaTest1;

import java.io.*;
import java.util.ArrayList;


public class htmlStripper {
	
	private ArrayList<String> htmlTags = new ArrayList<String>();
	
	public htmlStripper(String pathToReference) throws IOException{
		
		BufferedReader referenceReader = new BufferedReader(new FileReader(pathToReference));
			
		String tempLine = "";
		while ((tempLine = referenceReader.readLine()) != null) {
			htmlTags.add(tempLine);
		}
		
		referenceReader.close();
	}
	
	//Read and strip the file and create a new file with the html tags stripped out.
	public void readAndStrip(String path, String pathAndNameOfNew) throws FileNotFoundException, IOException {
		String originFile = this.read(path);
		String strippedFile = this.strip(originFile);
		
		FileWriter writer = new FileWriter(pathAndNameOfNew);
		writer.write(strippedFile);
		writer.close();
	}
	
	//Read the file into a string.
	private String read(String path) throws FileNotFoundException, IOException {
		String file = "";
		
		BufferedReader reader = new BufferedReader( new FileReader(path));
		
		String tempLine= "";
		
		while ((tempLine = reader.readLine()) != null){
			file = file + tempLine;
		}
		reader.close();
		return file;
	}
	
	//Strip html tags, this is done by detecting the opening < and the closing >. This has the problem that if these are used during normal text it will trigger this function.
	private String strip (String origin) {
		String stripped = origin;
		String subString = "";
		
		int len = origin.length();
		Boolean tag = false;
		Boolean recordSubString = false;
		
		for (int i = 0; i < len; i++) {
			char currChar = origin.charAt(i);
			
			if(currChar == '<') {
				tag = true;
				recordSubString = true;
			}
			
			if(recordSubString == true) {
				subString += currChar;
			}
			
			if(tag == true && currChar == '>'){
				System.out.println(subString);
				stripped = stripped.replace(subString, "");
				subString = "";
				tag = false;
				recordSubString = false;
			}
		}	
		
		return stripped;
	}
	
	//New version of the tag stripper using the file of reference tags.
	public String readAndStripv2(String path, String pathToNew) throws IOException {
		String originFile = this.read(path);
		
		for(String tag : this.htmlTags) {
			originFile = originFile.replace(tag, "");
			
			//Since the reference file only has opening tags need to simulate a closing tag.
			String tempTag = tag;
			StringBuilder builder = new StringBuilder(tempTag);
			int tempTagLen = tempTag.length();
			builder.insert((tempTagLen - (tempTagLen -1)), '/');
			tempTag = builder.toString();
			
			originFile = originFile.replace(tempTag, "");
		}
		
		FileWriter writer = new FileWriter(pathToNew);
		writer.write(originFile);
		writer.close();
		
		return originFile;
	}
}
