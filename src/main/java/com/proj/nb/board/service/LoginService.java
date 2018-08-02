package com.proj.nb.board.service;

import java.util.Arrays;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.nb.board.repository.LoginRepository;

@Service
public class LoginService {
	
@Autowired	
LoginRepository lr;

@Autowired
EncDecService encdec;

	
	public boolean authusername(String username){
		
		if(lr.findByUsername(username).getUsername()==username){
			return true;
		}
		return false;
		
	}
	public boolean authpass(String pass1,String pass2){
		if(pass1.equals(pass2))return true;
		return false;
	}
	
	public boolean authpassword(String username,String password,SecretKey seckey){
		
		
		try {
		   /* SecretKey secKey;
			secKey = encdec.getSecretEncryptionKey();
			*/
			byte[] pass=encdec.encryptText(password, seckey);
			
			
			byte[] passenc = lr.findByUsername(username).getEncpassword();
			
			
			System.out.println(passenc.getClass());
			System.out.println(Arrays.equals(pass, passenc));
			System.out.println("pass:"+pass);
			System.out.println("passenc:"+passenc);
			byte[] pass1=encdec.encryptText(password, seckey);
			System.out.println("pass1:"+pass1);
		//	byte[] passconv1=encdec.decryptText(pass, secKey);
		//	byte[] passconv2=encdec.decryptText(passenc, secKey);
		//	byte[] passconv11=encdec.decryptText(pass1, secKey);
		//	System.out.println("-"+passconv1+passconv2+"-");
		//	if(Arrays.equals(passconv1,passconv2)){System.out.println("thank god1");return true;}
		//	if(passconv1.equals(passconv2)){System.out.println("thank god2");return true;}
		//	if(password.equals(newpass)){System.out.println("found the error");return true;}
			if(pass.equals(passenc)){System.out.println("thank god3");return true;}
			if(Arrays.equals(pass,passenc))return true;
		//	if(Arrays.deepEquals(pass, passenc))return true;
			
		//	 byte[] decryptedText = encdec.decryptText(passenc, secKey);
			 /*
			 if(decryptedText.equals(password)){
				 return true;
			 }*/
			 return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
		 
		 
		/*
		//== ani pedthe same object aaa kadha from memory nundi check chesidanta adhe compare chesdunte equals() use cheyalanta
		if(lr.findByUsername(username).getPassword().equals(password)){
			
			return true;
		}
		return false;
		
	}*/
	}
	
	

	

}
