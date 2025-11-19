/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepartthree;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random; 

/**
 *
 * @author RC_Student_Lab
 */
class Message {               // start of message class
    
    //      Global declaration 
    String registeredUser;
    String registeredPassword;
    String registeredCellno;
    String recipientNumber;
    
    ArrayList<String> disregardMessage = new ArrayList<String>();  // allows us to add items and delete them.
    ArrayList<String> storeMessage = new ArrayList<String>();  //storing 
    ArrayList<String> sentMessage = new ArrayList<String>();  // act as our storage 
    ArrayList<String> hashId = new ArrayList<String>(); 
    ArrayList<String> recipientPhone = new ArrayList<String>();
   // HashSet<String> uniqueMessageID = new HashSet<>(); 
    ArrayList<String> uniqueMessageID = new ArrayList<String>();
    Random random = new Random();
    
    // End of global Declaration
    
    public boolean userNameCheck(String username) {       // start of username method 
        if (username.contains("_") && username.length()>= 5) {
        return true;
        } else {
            return false;
        }
    }  // End of username method 
    
    
    public boolean checkPasswordComplexity(String userPassword){   // start of pssword method
        if (userPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_+=-])(?=\\S+$).{5,}$")){
            return true;
        }else {
            return false; 
             
         }
     }     // End of the password method
     
    public boolean checkCellPhoneNumber(String cellNumber) {    // start of Recipient method 
        if (cellNumber.matches("^\\+27[6-8][0-9]{8}$")) {
            return true; 
        }else {
            return false;
        }
   }      // End of cellphone method 
    
    
    
    public void sentMessage() {             // start of sent method
            
    String recipientNumber;
    do {
        recipientNumber = JOptionPane.showInputDialog(null, "Enter recipient cellphone number", "Chatbot", JOptionPane.QUESTION_MESSAGE);
        if (recipientNumber == null){
            int quitConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
            if (quitConfirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
            return;
        }
        if(!checkCellPhoneNumber(recipientNumber)){
            JOptionPane.showMessageDialog(null, "invalid recipient number" , "Chatbot", JOptionPane.ERROR_MESSAGE);
        }
    } while(!checkCellPhoneNumber(recipientNumber));
            
    String messageNumber = JOptionPane.showInputDialog(null, "How many messages do you want to send? ","Chatbot", JOptionPane.QUESTION_MESSAGE );
    if(messageNumber == null){
        return;            
    }
    
    try {
        int messageCount = Integer.parseInt(messageNumber);
        for(int i = 0; i < messageCount; i++){
            
            String message = JOptionPane.showInputDialog(null, String.format("Enter your message (%d of %d): ", i + 1, messageCount));
            if(message == null){
                return;    
                
            } 
            
            if (message.length() > 250) {
            JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters.", "Chatbot", JOptionPane.ERROR_MESSAGE);
            i--; 
            continue;
            }
            
            String[] options = {"Send ", "Store ", "Disregard"};
            int actions = JOptionPane.showOptionDialog(
            null,
            "What do you want to do with your message?",
            "Message Action",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,  
            null,
            options,
            options[2] 
            );
            String id  = checkMessageId();
            
            switch(actions){
               case 0 -> {
                   sentMessage.add(message);
                   uniqueMessageID.add(id);
                   recipientPhone.add(recipientNumber);
                   
                   
                   int number = sentMessage.size();
                   
                   String hash = createMessageHash(id, number, message);
                   hashId.add(hash);
                   
                   JOptionPane.showMessageDialog(null,
                   "Message Sent:\n" +
                   "Message ID: " + id + "\n" +
                   "Message Hash: " + hash.toUpperCase() + "\n" +
                   "Recipient: " + recipientNumber + "\n" +
                   "Message: " + message,
                   "QuickChat", JOptionPane.INFORMATION_MESSAGE);
                   
               }
               case 1 -> {
                   storeMessage.add(message);
                   JOptionPane.showMessageDialog(null, "Your message has been Stored successfully.", "Chatbot", JOptionPane.INFORMATION_MESSAGE);
               }
               case 2 -> {                      
                   disregardMessage.add(message);
                   JOptionPane.showMessageDialog(null, "Your message has been disregarded.\nPress 0 to delete message.", "Chatbot", JOptionPane.INFORMATION_MESSAGE);
                }

               default -> {
                   return;
               }
            }
        }
                
    } catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(null,"Please enter a vaild number ","Error", JOptionPane.ERROR_MESSAGE );
    }
    
    printMessages();
    JOptionPane.showMessageDialog(null, returnTotalMessages(),"Messages sent", JOptionPane.INFORMATION_MESSAGE);
                
    boolean continueChat = true;
    while (continueChat) {
        String[] options = {"Send", "Message management", "Quit"};
        int choice = JOptionPane.showOptionDialog(
            null,
            "What would you like to do next?", "Chatbot",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]
        );

        switch (choice) {
            case 0 -> sentMessage(); 
            case 1 -> messageManagement();
            case 2, JOptionPane.CLOSED_OPTION -> continueChat = false;
            default -> continueChat = false;
            }
        }
    }   // End of sent message method
       
        
        
    public String checkMessageId() {        //start of checkMessageId method
        String Id; 
        
        do{
            int firstNum = 1 + random.nextInt(9);
            int remainingNum = random.nextInt(1_000_000_000);
            Id = firstNum + String.format("%09d", remainingNum);
            
        }while(uniqueMessageID.contains(Id));
        return Id;
    }           // end of checkMessageId method
    
    
    public String createMessageHash(String messageId, int messageIndex, String message) {       //    Start of createMessageHash method 
    String idPrefix = messageId.length() >= 2 ? messageId.substring(0, 2) : messageId;

    String[] words = message.trim().split("\\s+");
    String firstWord = words.length > 0 ? words[0] : "";
    String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;

    return String.format("%s:%d:%s%s", idPrefix, messageIndex, firstWord, lastWord).toUpperCase();
    }       // end of  createMessageHash method 
    
    public int returnTotalMessages(){       //start of returnTotalMessages method
        return sentMessage.size();
    }           // end of method
    
    
    
    public void printMessages() {    // start of printMessages method
            if (sentMessage.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No message was sent.");
                return;
            }

            StringBuilder display = new StringBuilder("SENT MESSAGES\n");

            int totalMessages = sentMessage.size();
            for (int i = 0; i < totalMessages; i++) {
                display.append("\nMessage ").append(i + 1).append(":\n")
                       .append("Message HASH ID: ").append(hashId.get(i)).append("\n")
                       .append("Message ID: ").append(uniqueMessageID.get(i)).append("\n")
                       .append("Message Content: ").append(sentMessage.get(i)).append("\n")
                       .append("Recipient: ").append(recipientPhone.get(i)).append("\n");
            }

            JOptionPane.showMessageDialog(null, display.toString());
    }        // end of printMessages method
    
    
    public String messageManagement ()  {        // start of message management 
      
        String[] options = {"search ID", "Delete by Hash", "Show all sent messages", "Display longest message"};
        int action = JOptionPane.showOptionDialog(null,
                "Message management",
                "Management",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null,
                options,options[0]);
        
        switch (action) {
            case 0 -> searchById();
            case 1 -> deleteByHash();
            case 2 -> printMessages();
            case 3 -> displayLongestMessage();
        }
        return null;
    }           // end of messageManagement
    
    
    
    public void searchById() {       // Start of searchById method 
        if (uniqueMessageID.isEmpty())  {
        JOptionPane.showMessageDialog(null, "No unique ID to search");
        return;
        }

        String inputID = JOptionPane.showInputDialog(null, "Enter unique ID You want to search");
        if (inputID == null) {
        return; 
        }

        int id = uniqueMessageID.indexOf(inputID); 

        if (id == -1)  {
        JOptionPane.showMessageDialog(null, "The position is not defined");
        return;
        }

        StringBuilder display = new StringBuilder("\n *** Message Details ***\n");

        display.append("Messages: ").append(sentMessage.get(id)).append("\n");
        display.append("Messages HASHID: ").append(hashId.get(id)).append("\n");
        display.append("Messages ID: ").append(uniqueMessageID.get(id)).append("\n");
        display.append("Messages Content: ").append(sentMessage.get(id)).append("\n");
        display.append("Recipient: ").append(recipientPhone.get(id)).append("\n");

        JOptionPane.showMessageDialog(null, display.toString());
        }             // end of searchById method 
         
    
    
    public void deleteByHash() {
        if (hashId.isEmpty())   {
            JOptionPane.showMessageDialog(null, "No hash ID to use to delete message details");
        }
        
        String hash = JOptionPane.showInputDialog(null, "Enter hash Id to delete message");
        if (hash == null)  {
            return;
        }
        
        int index = hashId.indexOf(hash);
        if (index != -1)   {
            disregardMessage.add(sentMessage.get(index));
            sentMessage.remove(index);
            recipientPhone.remove(index);
            uniqueMessageID.remove(index);
            hashId.remove(index);
            
            JOptionPane.showMessageDialog(null," Message successfully deleted", null, JOptionPane.DEFAULT_OPTION);
            
        }else{
            JOptionPane.showMessageDialog(null, "No message exit with this hash!" , null, JOptionPane.ERROR_MESSAGE);
        }
    }     // END of delete by hash 
    
    
    public void displayLongestMessage() {  // Start of displayLongestMessage method
         if (sentMessage.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No messages available.");
        return;
        }

        int longestIndex = 0;
        for (int i = 1; i < sentMessage.size(); i++) {
        if (sentMessage.get(i).length() > sentMessage.get(longestIndex).length()) {
            longestIndex = i;
        }
    }

        StringBuilder display = new StringBuilder("\n*** Longest Sent Message ***\n");
        display.append("Message: ").append(sentMessage.get(longestIndex)).append("\n");
        display.append("HASH ID: ").append(hashId.get(longestIndex)).append("\n");
        display.append("Unique ID: ").append(uniqueMessageID.get(longestIndex)).append("\n");
        display.append("Recipient Phone: ").append(recipientPhone.get(longestIndex)).append("\n");

        JOptionPane.showMessageDialog(null, display.toString());
        JOptionPane.showMessageDialog(null, "Longest message displayed successfully, Thank you.");
    
    
    }  // End of displayLongestMessage method
  
}   // End of message class 
