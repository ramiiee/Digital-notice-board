package com.proj.nb.board.service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

@Service
public class EncDecService {

	
		public static SecretKey getSecretEncryptionKey()throws Exception{
		
			KeyGenerator generator= KeyGenerator.getInstance("AES");
			generator.init(128);
			
			SecretKey secKey=generator.generateKey();
			
			return secKey;
		}
		
		public static byte[] encryptText(String plainText,SecretKey secKey) throws Exception{
			
			
			Cipher aesCipher=Cipher.getInstance("AES");
			aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
			byte[] byteCipherText= aesCipher.doFinal(plainText.getBytes());
			return byteCipherText;
			
		}
		
		
		
		public static String decryptText(byte[] byteCipherText, SecretKey secKey)throws Exception{
			Cipher aesCipher = Cipher.getInstance("AES");
			aesCipher.init(Cipher.DECRYPT_MODE, secKey);
			byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
			//return bytePlainText;
			
			return new String(bytePlainText);

		}
		
		@SuppressWarnings({ "unused", "restriction" })
		private static String bytesToHex(byte[] hash) {
			
			return DatatypeConverter.printHexBinary(hash);
			
		}
}
