/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utill;

/**
 *
 * @author apple
 */
public class UserBean {
    

      private String username;
      private String password;
      private String role;
      private String mailid;
      private String otp;
      public String getOtp(){
      return otp;
      }
      public boolean valid;
	public void setOtp(String totp){
            otp=totp;
        }
	public String getRole() {
         return role;
	}
      public String getMailid() {
         return mailid;
	}
      

      public void setMailid(String mail) {
         mailid = mail;
	}
	 

      public void setRole(String newRole) {
         role = newRole;
	}
	
      
			

      public String getPassword() {
         return password;
	}
      

      public void setPassword(String newPassword) {
         password = newPassword;
	}
	
			
      public String getUsername() {
         return username;
			}

      public void setUserName(String newUsername) {
         username = newUsername;
			}

				
      public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}	
}

