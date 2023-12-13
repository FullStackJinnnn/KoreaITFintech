package section01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hello 

{
	
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		String[] inputWord = new String[3];
		inputWord = input.split(" ");
		StringBuilder output = sb.append(inputWord[0]).append(" ").append(inputWord[1]).append(" ").append(inputWord[2]);
		System.out.println(output);
		
		
	}
}
