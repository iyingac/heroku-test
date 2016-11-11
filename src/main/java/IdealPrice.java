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
	
	private Connection connection = null;
	Map<String, npd> attributes = new HashMap<>();
	public IdealPrice() {
		try
		{
			connection = DatabaseUrl.extract().getConnection();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM salesforce.NPD__c");
			while (rs.next()) 
			{
				npd newNPD = new npd();
				newNPD.npdName = rs.getString("name");
				newNPD.ProjectName = rs.getString("project_name__c");
				newNPD.AnnualVolume = Double.parseDouble(rs.getString("annual_volume_pcs__c"));
				attributes.put(newNPD.npdName, newNPD);
			}
		}
		catch (Exception e) { }
	}
	
	public Double getAnnualVolume(String NPD)
	{
		return attributes.get(NPD).AnnualVolume;
	}
}