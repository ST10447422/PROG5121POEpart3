/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package poepartthree;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author RC_Student_Lab
 */
public class LoginNGTest {
    
  
    
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkUserName(username);
        assertEquals(result, expResult);
       
    }

    
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String userPassword = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(userPassword);
        assertEquals(result, expResult);
        
    }

   
    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String cellNumber = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkCellPhoneNumber(cellNumber);
        assertEquals(result, expResult);
       
    }

   
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        Login instance = new Login();
        instance.registerUser();
      
    }

  
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        Login instance = new Login();
        instance.loginUser();
        //TEST
       
    }
    
}
