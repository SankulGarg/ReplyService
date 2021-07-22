package com.beta.replyservice.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.beta.replyservice.dto.ReplyMessage;
import com.beta.replyservice.service.ReplyService;

@Service
@Primary
public class ReplyServiceImpl implements ReplyService {
	@Override
	public ReplyMessage reply(String unParsedMessage) {
		return new ReplyMessage(unParsedMessage);
	}

}
