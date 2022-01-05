package com.chat.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.app.entity.ChatRoom;
import com.chat.app.repository.ChatRoomRepository;

@Service
public class ChatRoomService {
	@Autowired
	private ChatRoomRepository chatRoomRepository;

	public Optional<String> getChatId(String senderId, String recipientId, boolean createIfNotExist) {
		return chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId).map(ChatRoom::getChatId)
				.or(() -> {
					if (!createIfNotExist) {
						return Optional.empty();
					}
					String chatId = String.format("%s_%s", senderId, recipientId);
					ChatRoom senderRecipient = new ChatRoom(chatId, senderId, recipientId);
					ChatRoom recipientSender = new ChatRoom(chatId, recipientId, senderId);
					chatRoomRepository.save(senderRecipient);
					chatRoomRepository.save(recipientSender);
					return Optional.of(chatId);
				});
	}
}
