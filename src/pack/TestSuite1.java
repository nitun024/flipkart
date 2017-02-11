package pack;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;

import jxl.read.biff.BiffException;
import testCases.TC_CartVerification;
import testCases.TC_Login;

public class TestSuite1 {

	@Test
	public static void testSuite1() throws SQLException, InterruptedException, BiffException, IOException, GeneralSecurityException, InvalidFormatException, ClassNotFoundException {
		
		TC_Login.TC_login();
		TC_CartVerification.TC_cartVerification();
		
	}
}
