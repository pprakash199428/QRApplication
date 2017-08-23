package com.spicejet.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SpicejetUtil {

	
	public static String DecryptV2(String text, String key) throws Exception {
		//Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length)
			len = keyBytes.length;
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		//IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.DECRYPT_MODE, keySpec);

		BASE64Decoder decoder = new BASE64Decoder();
		byte[] results = cipher.doFinal(decoder.decodeBuffer(text));
		return new String(results, "UTF-8");
	}

	public static String EncryptV2(String text, String key) {
		try {
			//Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			byte[] keyBytes = new byte[16];
			byte[] b = key.getBytes("UTF-8");
			int len = b.length;
			if (len > keyBytes.length)
				len = keyBytes.length;
			System.arraycopy(b, 0, keyBytes, 0, len);
			SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
			IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);

			byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(results);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
}
