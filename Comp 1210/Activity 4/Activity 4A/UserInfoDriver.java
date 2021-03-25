/** 
*Activity4.
*@author Lawrence Martin
*@version 2/3/19
*/
public class UserInfoDriver {
   
   /**
    * prints for User 1 and User 2.
    * @param args Command line arguments - not used.
    */
   public static void main(String[] args) {
      
      //Makes User 1.
      UserInfo user1 = new UserInfo("Pat", "Doe");
      System.out.println("\n" + user1);
      user1.setLocation("Auburn");
      user1.setAge(19);
      user1.logOn();
      System.out.println("\n" + user1);
      
      //Makes user 2
      UserInfo user2 = new UserInfo("Sam", "Jones");
      System.out.println("\n" + user2);
      user2.setLocation("Atlanta");
      user2.setAge(21);
      user2.logOn();
      System.out.println("\n" + user2);
   
   }

}


