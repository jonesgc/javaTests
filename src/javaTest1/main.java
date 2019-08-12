package javaTest1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class main {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		htmlStripper strip = new htmlStripper("/home/greg/Documents/htmlTagReference.txt");
		strip.readAndStripv2("/home/greg/Documents/htmlDocTest.txt", "/home/greg/Documents/htmlStripped.txt");
	}
}
