package com.beta.replyservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.beta.replyservice.constants.ReplyAction;
import com.beta.replyservice.dto.ReplyMessage;
import com.beta.replyservice.service.MessageTranslationService;
import com.beta.replyservice.service.ReplyService;

@Service("ReplyServiceV2")
public class ReplyServiceV2Impl implements ReplyService {

	@Autowired
	private MessageTranslationService messageTranslationService;

	@Override
	public ReplyMessage reply(String unParsedMessage) {
		String[] parsedMesage = unParsedMessage.split("-");
		if (parsedMesage.length != 2)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid Request message");

		String message = parsedMesage[1];
		for (char rule : parsedMesage[0].toCharArray()) {

			ReplyAction action = ReplyAction.find(rule);
			message = action.perform(messageTranslationService, message);

		}

		return new ReplyMessage(message);
	}

}
