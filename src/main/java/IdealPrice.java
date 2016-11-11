import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class IdealPrice {
	
	public static void IdealPRice(String[] args) {
		
		port(Integer.valueOf(System.getenv("PORT")));
	    staticFileLocation("/public");

	    get("/IdealPrice", (req, res) -> "Ideal Price");
	}
}