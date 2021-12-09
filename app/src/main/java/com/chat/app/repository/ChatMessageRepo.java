package com.chat.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;

import com.chat.app.entity.Message;

import reactor.core.publisher.Flux;

@Repository
public interface ChatMessageRepo extends ReactiveMongoRepository<Message, String> {

	@Tailable
	public Flux<Message> findWithTailableCursorByChannelId(String channelId);
}
