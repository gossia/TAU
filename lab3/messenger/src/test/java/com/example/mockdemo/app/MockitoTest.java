package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import com.example.mockdemo.messenger.SendingStatus;
import com.example.mockdemo.app.Messenger;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
	
	private static final String VALID_SERVER = "inf.ug.edu.pl";
	private static final String VALID_MESSAGE = "some message";
	private static final String INVALID_SERVER = "inf.ug.edu.eu";
	private static final String INVALID_MESSAGE = "ab";

	@Mock
	MessageService mock;
	
	@InjectMocks
	Messenger messenger = new Messenger(new MessageServiceSimpleImpl());

	@Test
	public void checkConnectionStatusForValidServer() {
		when(mock.checkConnection(VALID_SERVER))
		.thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
		verify(mock, times(1)).checkConnection(VALID_SERVER);
	}
	
	@Test
	public void checkConnectionStatusForInvalidServer() {
		when(mock.checkConnection(INVALID_SERVER))
		.thenReturn(ConnectionStatus.FAILURE);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
		verify(mock, times(1)).checkConnection(INVALID_SERVER);
	}

	@Test
	public void checkSendingStatusForValidServerValidMessage() throws MalformedRecipientException {
		when(mock.send(VALID_SERVER, VALID_MESSAGE))
		.thenReturn(SendingStatus.SENT);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}

	@Test
	public void checkSendingStatusForValidServerInvalidMessage() throws MalformedRecipientException {
		when(mock.send(VALID_SERVER, INVALID_MESSAGE))
		.thenThrow(new MalformedRecipientException())
		.thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}

	@Test
	public void checkSendingStatusForInvalidServerValidMessage() throws MalformedRecipientException {
		when(mock.send(INVALID_SERVER, VALID_MESSAGE))
		.thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(1, messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE));
	}

	@Test
	public void checkSendingStatusForInvalidServerInvalidMessage() throws MalformedRecipientException {
		when(mock.send(INVALID_SERVER, INVALID_MESSAGE))
		.thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(1, messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE));
	}

}
