package com.chat.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;

@Document(collection = "chat-room")
public class ChatRoom {
	@Id
	private String id;
	private String chatId;
	private String senderId;
	private String recipientId;

	public ChatRoom() {
	}

	public ChatRoom(String id, String chatId, String senderId, String recipientId) {
		this.id = id;
		this.chatId = chatId;
		this.senderId = senderId;
		this.recipientId = recipientId;
	}

	public ChatRoom(String chatId, String senderId, String recipientId) {
		this.chatId = chatId;
		this.senderId = senderId;
		this.recipientId = recipientId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

}
