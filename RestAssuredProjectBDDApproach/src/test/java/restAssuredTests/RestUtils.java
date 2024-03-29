package restAssuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getFirstName()
	{
		
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		
		System.out.println("The firstname "+generatedString);
		
		return("John"+generatedString);
	}
		

	public static String getLastName()
	{
		
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		
		return("Horgan"+generatedString);
		
			}
	
	
	public static String getUserName()
	{
		
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		
		return("JohnH"+generatedString);
		
		
	}
	
	public static String getPassword()
	{
		
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		
		return("John"+generatedString);
		
		
	}
	
	
	
	public static String getEmail()
	{
		
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		
		return(generatedString+"@gmail.com");
		
		
	}
	
	public static String getEmployeeName()
	{
		
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		
		return("Michell"+generatedString);
		
	}
	
	public static String getEmployeeSalary()
	{
		
		     String generatedString  =RandomStringUtils.randomNumeric(6);
		     
		     return(generatedString);
	}
	
	public static String getEmployeeAge()
	{
		
		     String generatedString  =RandomStringUtils.randomNumeric(2);
		     
		     return(generatedString);
	}
	
	
	public static String getTite()
	{
		
		
		String generatedString = RandomStringUtils.randomNumeric(5);
		
		return ("Java"+generatedString);
	}
	
}
