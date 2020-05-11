package com.andy.jacksonjson;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;


public class JacksonGenerator {
	
	public static void main(String[] args) throws IOException {
		//retrieve JsonFacotry object
		JsonFactory factory = new JsonFactory();
		
		//create writer/OutputStream/File
		StringWriter jsonObjectWriter = new StringWriter();
		
		//creates json generator
		JsonGenerator generator = factory.createGenerator(jsonObjectWriter);
		
		
		//creates the JSON object {}
		generator.writeStartObject();
		
		//add string fields to json
		generator.writeStringField("id", "1234");
		generator.writeStringField("name", "Andy");
		generator.writeStringField("team", "Java");
		generator.writeNumberField("age", 25);
		
		//creates a JSON array within the JSON object
		generator.writeFieldName("skills");
		
		//writes the [ to start the array
		generator.writeStartArray();
		
		//add values to the array
		generator.writeString("Java");
		generator.writeString("Spring");
		generator.writeString("Hibernate");
		generator.writeString("SQL");
		generator.writeString("React");
		
		//writes the ] to end the array	
		generator.writeEndArray();
		
		//creates an object within the JSON object
		generator.writeFieldName("address");
		
		//writes the { to start the object
		generator.writeStartObject();
		
		//add string field values to the object
		generator.writeStringField("city", "Miami");
		generator.writeStringField("country", "USA");
		
		//must generate 2 }} to close the object inside the JSON and close the JSON
		generator.writeEndObject();
		generator.writeEndObject();
		
		//close the json generator
		generator.close();
		
		//print the json
		System.out.println(jsonObjectWriter.toString());
		
		
		
		
	}
	

}
