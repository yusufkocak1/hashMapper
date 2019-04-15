package com.yube.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Processor {

	public static String Base64Encoder(String data) {

		return Base64.getEncoder().encodeToString(data.getBytes());
	}

	public static String Base64Decoder(String data) {

		return new String(Base64.getDecoder().decode(data.getBytes()));
	}

	public static String SHA256encoder(String data) {
		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");

			byte[] messageDigest = md.digest(data.getBytes(StandardCharsets.UTF_8));
			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			return new String("hata:" + e.getMessage());

		}
	}

	public static String SHA256Decoder(String data) {
		return "Henüz hizmet veremiyoruz.";
	}

	public static String MD5Encoder(String data) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");

			byte[] hashInBytes = md.digest(data.getBytes(StandardCharsets.UTF_8));

			StringBuilder sb = new StringBuilder();
			for (byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			return "hata : " + e.getMessage();
		}
	}

	public static String MD5Deceoder(String data) {
		return "Henüz hizmet veremiyoruz.";
	}

}
