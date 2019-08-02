package javaTest1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class main {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		htmlStripper strip = new htmlStripper();
		strip.read("/home/greg/Documents/test.txt");
	}
}
