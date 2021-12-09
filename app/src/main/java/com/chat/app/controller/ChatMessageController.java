package com.chat.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.entity.Message;
import com.chat.app.repository.ChatMessageRepo;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ChatMessageController {
	
	@Autowired
	ChatMessageRepo chatMessageRepo;

	@PreAuthorize("permitAll()")
	@PostMapping("/chats")
	@ResponseStatus(HttpStatus.CREATED)
	public void postChat(@RequestBody Message chatMessage) {
		 chatMessageRepo.save(chatMessage).subscribe();
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping(value = "/chats/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Message> streamMessages(@RequestParam String channelId){
		return chatMessageRepo.findWithTailableCursorByChannelId(channelId);
	}
}
