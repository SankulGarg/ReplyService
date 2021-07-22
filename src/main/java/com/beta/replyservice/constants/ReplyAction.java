package com.beta.replyservice.constants;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.beta.replyservice.service.MessageTranslationService;

public enum ReplyAction {
	REVERSE('1') {
		public String perform(MessageTranslationService messageTranslationService, String message) {

			return messageTranslationService.reverse(message);
		}
	},
	ENCODE_MD5('2') {
		public String perform(MessageTranslationService messageTranslationService, String message) {

			return messageTranslationService.encodeMD5(message);
		}
	};

	private char ruleId;

	ReplyAction(char ruleId) {
		this.ruleId = ruleId;
	}

	public String perform(MessageTranslationService messageTranslationService, String message) {

		return null;
	}

	
	
	public static ReplyAction find(char ruleId) {
		return enumMap.get(ruleId);
	}

	private static Map<Character, ReplyAction> enumMap = new HashMap<>();
	static {
		EnumSet.allOf(ReplyAction.class).forEach(action -> {
			enumMap.put(action.ruleId, action);
		});

	}
}
