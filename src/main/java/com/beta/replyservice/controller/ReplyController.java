package com.beta.replyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.beta.replyservice.dto.ReplyMessage;
import com.beta.replyservice.service.ReplyService;

@RestController
public class ReplyController {

	@Autowired
	@Qualifier("ReplyServiceV2")
	ReplyService replyServiceV2;

	@Autowired
	ReplyService replyService;

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return replyService.reply(message);
	}

	@GetMapping("v2/reply/{message}")
	public ReplyMessage v2replying(@PathVariable String message) {
		return replyServiceV2.reply(message);
	}
}