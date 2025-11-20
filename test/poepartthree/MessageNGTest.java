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
public class MessageNGTest {
    
   

    
    @Test
    public void testUserNameCheck() {
        System.out.println("userNameCheck");
        String username = "";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.userNameCheck(username);
        assertEquals(result, expResult);
        
    }

    
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String userPassword = "";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(userPassword);
        assertEquals(result, expResult);
        
    }

    
    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String cellNumber = "+27688401511";
        Message instance = new Message();
        boolean expResult = true;
        boolean result = instance.checkCellPhoneNumber(cellNumber);
        assertEquals(result, expResult);
        
    }

    
    @Test
    public void testincorrectCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String cellNumber = "";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkCellPhoneNumber(cellNumber);
        assertEquals(result, expResult);
        
    }
    
    
    @Test
    public void testSentMessage() {
        System.out.println("sentMessage");
        Message instance = new Message();
        instance.sentMessage();
        
    }

    
    @Test
    public void testCheckMessageId() {
        System.out.println("checkMessageId");
        Message instance = new Message();
        String expResult = "";
        String result = instance.checkMessageId();
        assertEquals(result, expResult);
        
    }

    
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String messageId = "";
        int messageIndex = 0;
        String message = "";
        Message instance = new Message();
        String expResult = "";
        String result = instance.createMessageHash(messageId, messageIndex, message);
        assertEquals(result, expResult);
        
    }

    
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.returnTotalMessages();
        assertEquals(result, expResult);
        
    }

    
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Message instance = new Message();
        instance.printMessages();
       
    }

    
    @Test
    public void testMessageManagement() {
        System.out.println("messageManagement");
        Message instance = new Message();
        String expResult = "";
        String result = instance.messageManagement();
        assertEquals(result, expResult);
        
    }

    
    @Test
    public void testSearchById() {
        System.out.println("searchById");
        Message instance = new Message();
        instance.searchById();
        
    }

    
    @Test
    public void testDeleteByHash() {
        System.out.println("deleteByHash");
        Message instance = new Message();
        instance.deleteByHash();
        
    }

    
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("displayLongestMessage");
        Message instance = new Message();
        instance.displayLongestMessage();
        
    }
    
}
