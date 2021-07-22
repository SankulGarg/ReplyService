package com.beta.replyservice.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import com.beta.replyservice.service.MessageTranslationService;

@Service
public class MessageTranslationServiceImpl implements MessageTranslationService {
	private final MessageDigest messageDigest;

	MessageTranslationServiceImpl() throws NoSuchAlgorithmException {
		messageDigest = MessageDigest.getInstance("MD5");
	}

	@Override
	public String reverse(String message) {
		return new StringBuilder(message).reverse().toString();
	}

	@Override
	public String encodeMD5(String message) {
		return String.valueOf(Hex.encodeHex(messageDigest.digest(message.getBytes())));
	}

}
