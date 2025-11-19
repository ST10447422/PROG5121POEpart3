/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepartthree;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_Lab
 */
public class PoePartThree {

  
    public static void main(String[] args) {
      
         // login methods start
            Login obj = new Login();
            
            Message message = new Message(); 
         
           obj.registerUser();
           obj.loginUser();           
           message.sentMessage();
        // login methods finish    
        
    }    // End of main method 
      
}  // end of main 
