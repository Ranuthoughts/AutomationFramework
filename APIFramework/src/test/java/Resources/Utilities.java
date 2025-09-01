package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utilities {
	public static RequestSpecification request;
	ResponseSpecification response;

	public RequestSpecification requestspecification() throws IOException

	{
		if (request == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logs.txt"));
//		RestAssured.baseURI = "http://3.111.77.42:8183";
			request = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return request;
		}

		return request;
	}

	public ResponseSpecification responseSpecification() {
		response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return response;
	}

	// getglobal values method
	public static String getGlobalValues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\ECMS\\GITSTUFF\\APIFramework\\src\\test\\java\\Resources\\Global.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}

   

}
