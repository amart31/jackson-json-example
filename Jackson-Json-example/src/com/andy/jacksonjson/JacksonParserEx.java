package com.andy.jacksonjson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JacksonParserEx {

	public static void main(String[] args) throws JsonParseException, IOException {
		
		//create the jsonFactory obj, used to configure parser and generator instances
		JsonFactory factory = new JsonFactory();
		
		//create Reader/InputStream/File
		File file = new File("/Jackson-Json-example/src/myFile.json");
		
		//creates the JsonParser
		JsonParser parser = factory.createParser(file);
		
		JsonToken token = parser.nextToken(); //read the first obj i.e {
		
		//read the json obj
		token = parser.nextToken();
		
		if (token == JsonToken.FIELD_NAME && "id".contentEquals(parser.getCurrentName())) {
			token = parser.nextToken();
			if (token == JsonToken.VALUE_STRING) {
				System.out.println("ID: " + parser.getText());
			}
		}
		
		token = parser.nextToken();
		if (token == JsonToken.FIELD_NAME && "name".equals(parser.getCurrentName())) {
			token = parser.nextToken();
			if (token == JsonToken.VALUE_STRING) {
				System.out.println("NAME: " + parser.getText());
			}
		}
		
		token = parser.nextToken();
		if (token == JsonToken.FIELD_NAME && "team".equals(parser.getCurrentName())) {
			token = parser.nextToken();
			if (token == JsonToken.VALUE_STRING) {
				System.out.println("TEAM: " + parser.getText());
			}
		}
		
		//age is an int so value number int has to be used
		token = parser.nextToken();
		if (token == JsonToken.FIELD_NAME && "age".equals(parser.getCurrentName())) {
			token = parser.nextToken();
			if (token == JsonToken.VALUE_NUMBER_INT) {
				System.out.println("AGE: " + parser.getIntValue());
			}
		}
		
		//reading the JSON array
		token = parser.nextToken();
		if (token == JsonToken.FIELD_NAME && "skills".equals(parser.getCurrentName())) {
			
			System.out.println("\nYour skills are: ");
			token = parser.nextToken(); //read left bracket
			
			while (token != JsonToken.END_ARRAY) {
				token = parser.nextToken();
				
				if (token == JsonToken.VALUE_STRING) {
					System.out.println(parser.getText() + ", ");
				}
			}
			System.out.println();
			
		}
		
		//reading nested Json Object
		token = parser.nextToken();
		
		if (token == JsonToken.FIELD_NAME && "address".equals(parser.getCurrentName())) {
			
			token = parser.nextToken(); //read the first {
			
			System.out.println("\nYour Address is: ");
			token = parser.nextToken();
			if (token == JsonToken.FIELD_NAME && "city".equals(parser.getCurrentName())) {
				token = parser.nextToken();
				if (token == JsonToken.VALUE_STRING) {
					System.out.println("CITY: " + parser.getText());
				}
			}
			
			token = parser.nextToken();
			if (token == JsonToken.FIELD_NAME && "country".equals(parser.getCurrentName())) {
				token = parser.nextToken();
				if (token == JsonToken.VALUE_STRING) {
					System.out.println("Country: " + parser.getText());
				}
			}
		}
		parser.close();

	}

}


















