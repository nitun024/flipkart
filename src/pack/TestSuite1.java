package pack;

import java.sql.SQLException;

import org.testng.annotations.Test;

public class TestSuite1 {

	@Test
	public static void testSuite1() throws SQLException, InterruptedException {
		
		TC_Login.TC_login();
		TC_CartVerification.TC_cartVerification();
		
	}
}
