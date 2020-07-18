package weatherapi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WEATHER_TEST4 {

	public static void main(String[] args) throws Exception {
		 
		 //HTTP request using query parameter(giving in  query method) and reponse_ in _json
		
	       // create HTTP request
			
			
			RestAssured.baseURI="https://www.amazon.in/s";
			RequestSpecification req=RestAssured.given();
			//send a HTTP request
			
			Response res =req.queryParam("k","corona beer").queryParam("crid", "3VE9Q1NC8XNKC").get("");
			
			//get status line
			String sline=res.getStatusLine();
			System.out.println(sline);
			//get headers
			Headers hr=res.getHeaders();
			
			
			List<Header> hrs=hr.asList();
			for(Header h:hrs) {
				System.out.println(h.getName()+":"+h.getValue());
			}
			String rbody=res.getBody().asString();
			System.out.println(":"+rbody);
			File f;
			
			String frmt=res.getHeader("Content-Type");
			if(frmt.contains("json")) {
				 f =new File("E:\\weather.json");
			}
			else if(frmt.contains("xml")) {
				 f =new File("E:\\weather.xml");
			}
			else if(frmt.contains("csv")) {
				 f =new File("E:\\weather.csv");
			}
			else if(frmt.contains("html")) {
				 f =new File("E:\\weather.html");
			}
			else {
				 f =new File("E:\\weather.txt");
			}
			FileWriter fw=new FileWriter(f);
			fw.write(frmt);
			fw.close();


	}

}
