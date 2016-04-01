package cn.nb.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

	private static final String KEY_PWD = "imc_good";
	
	/**
	 * 加密
	 * @param content 需要加密的内容
	 * @param password 加密密码
	 * @return
	 */
	public static byte[] encrypt(String content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG"); 
			secureRandom.setSeed(password.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (Exception e) {
			//暂时什么也不做
		}
		return null;
	}
	
	/**
	 * 使用默认的密钥加密
	 * @param content
	 * @return
	 */
	public static String encrypt(String content){
		byte[] result = encrypt(content, KEY_PWD);
		if(result == null){
			return null;
		}else{
			return parseByte2HexStr(result);
		}
	}

	/**
	 * 解密
	 * @param content 待解密内容
	 * @param password 解密密钥
	 * @return
	 */
	public static String decrypt(byte[] content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG"); 
			secureRandom.setSeed(password.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return new String(result); // 加密
		} catch (Exception e) {
			//暂时什么也不做
		}
		return null;
	}
	
	/**
	 * 使用默认的key解密
	 * @param content
	 * @return
	 */
	public static String decrypt(String content){
		return decrypt(parseHexStr2Byte(content), KEY_PWD);
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		try {
			for (int i = 0; i < hexStr.length() / 2; i++) {
				int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
				int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
						16);
				result[i] = (byte) (high * 16 + low);
			}
		} catch (NumberFormatException e) {
			return null;
		}
		return result;
	}
	
	
	//住函数
	public static void main(String args[]){
//		System.out.println(encrypt(args[0]));
//		System.out.println(decrypt("7C0DBA318CE18AF7C83E99710025722A3645C309A278F93F0E1CCE9E109101A04505E63206C4EC7028C4764169EF7C33488391121B539B7BF9168F36A38AA38D10CD5D9DE56FEB4B93224CC69B6E04F8C8DFE4FAE644858B11402DC23FAD0F88A2B3E1D1B055A44CA8BB05462C1988A09F92B7EBB6FE701F058CBBD5B8576890"));
		System.out.println(encrypt("jdbc:mysql://218.241.108.40:3306/nbdb?noAccessToProcedureBodies=true&useUnicode=true&characterEncoding=UTF-8"));
	}
}
