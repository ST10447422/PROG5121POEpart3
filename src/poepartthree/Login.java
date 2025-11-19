/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepartthree;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_Lab
 */
class Login {     // Start of External class
     
    //Global declaration for user to input information
    
    String registeredUser;
    String registeredPassword;
    String registeredCellno;
    String firstName;
    String lastName;
    Message obj = new Message();
    
    
   
    // end of the storing name section
    
    
    public boolean checkUserName(String username){   // start of username method checker
     
        
        if(username.contains("_") && username.length()>= 5){
          JOptionPane.showMessageDialog(null, "Username successfully captured.", "Signup", JOptionPane.INFORMATION_MESSAGE);
          return true;
      }else{
          JOptionPane.showMessageDialog(null,"Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
          return false;
      }
    }      // End of Username method
    
    

     public boolean checkPasswordComplexity(String userPassword){      // start of password method 
        
        if(userPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_+=-])(?=\\S+$).{5,}$") && userPassword.length() <= 8){
            JOptionPane.showMessageDialog(null,"Password successfully captured.","Signup", JOptionPane.INFORMATION_MESSAGE);
          return true;
       }else{
          JOptionPane.showMessageDialog(null,"Password is not correctly formatted, please ensure that your password contains at least eight characters, a capital letter, a number and a special character." , "Login", JOptionPane.ERROR_MESSAGE);
          return false;
        }
    }  // End of password method 
    
    
    
    
    public boolean checkCellPhoneNumber(String cellNumber){   //Start of cellphone number method
        
        if(cellNumber.matches("^\\+27[6-8][0-9]{8}$")){
            JOptionPane.showMessageDialog(null,"Cellphone number successfully added." , "Signup", JOptionPane.INFORMATION_MESSAGE);
          return true;
       }else{
          JOptionPane.showMessageDialog(null,"Cellphone number is incorrectly formatted or does not contain international code.");
          return false;
        }
    }        //End of cellphone number method 
    
    
    
    public void registerUser() { // Start of signup method
        
        // users first and last name 
    String firstName = JOptionPane.showInputDialog(null,"Enter your first name", "Signup", JOptionPane.QUESTION_MESSAGE);
    String lastName = JOptionPane.showInputDialog( null,"Enter your last name ", "Signup", JOptionPane.QUESTION_MESSAGE);
    
        
    String userName;
    String userPassword;
    String userCellno;

    boolean isRegistered = false;

    do {
        
         do {
            userName = JOptionPane.showInputDialog(null, 
                "Enter your username (must have _, 5 char).", 
                "Signup", JOptionPane.QUESTION_MESSAGE);
            if (userName == null) {
                JOptionPane.showMessageDialog(null, "Signup cancelled.", "Signup", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } while (!checkUserName(userName));
            
         
          do {
            userPassword = JOptionPane.showInputDialog(null, 
                "Enter your Password.", 
                "Signup", JOptionPane.QUESTION_MESSAGE);
            if (userPassword == null) {
                JOptionPane.showMessageDialog(null, "Signup cancelled.", "Signup", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } while (!checkPasswordComplexity(userPassword));
          
          do {
            userCellno = JOptionPane.showInputDialog(null, 
                "Enter your cellphone number.", 
                "Signup", JOptionPane.QUESTION_MESSAGE);
            if (userCellno == null) {
                JOptionPane.showMessageDialog(null, "Signup cancelled.", "Signup", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } while (!checkCellPhoneNumber(userCellno));
          
        registeredUser = userName;
        registeredPassword = userPassword;
        registeredCellno = userCellno;

        JOptionPane.showMessageDialog(null, "User has been registered successfully.", "Signup", JOptionPane.INFORMATION_MESSAGE);
        isRegistered = true;

        } while (!isRegistered);
    }      // End of registertion method

    
   public void loginUser(){       //Logging in method 

    if(registeredUser == null && registeredPassword == null){
        JOptionPane.showMessageDialog(null,"You need to register before, you can login.", "Login", JOptionPane.INFORMATION_MESSAGE);
        return;
    }   

    boolean isLoggedIn = false;

    do {
        String userName = JOptionPane.showInputDialog(null, "Enter your username to login!" , "Login", JOptionPane.QUESTION_MESSAGE);
        String userPassword = JOptionPane.showInputDialog(null,"Enter your Password to login!",  "Login", JOptionPane.QUESTION_MESSAGE);

        if(userName.equals(registeredUser) && userPassword.equals(registeredPassword)) {
            
           boolean continueChat = true; 
          
            String[] options = {"Send", "Recently sent message", "Quit"};
            int action = JOptionPane.showOptionDialog(null, "Welcome to Quickchat.", "Welcome", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
            switch (action) {
            case 0 -> {
            obj.sentMessage();
            return;
            }
            case 1 -> {
            obj.messageManagement();
            return;
            }
           case 2, JOptionPane.CLOSED_OPTION -> {
           JOptionPane.showMessageDialog(null, "Goodbye!", "Exit", JOptionPane.INFORMATION_MESSAGE);
           System.exit(0);
            }
        
                }
            
            JOptionPane.showMessageDialog(null,"Welcome " + firstName + " " + lastName + " to Quickchat , It is great to see you again!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            
            isLoggedIn = true;
        } else {
            JOptionPane.showMessageDialog(null,"Username or password incorrect, please try again." , "Login", JOptionPane.ERROR_MESSAGE);  
        }
    } while (!isLoggedIn);
} // End of login user method

}   // end of login class
