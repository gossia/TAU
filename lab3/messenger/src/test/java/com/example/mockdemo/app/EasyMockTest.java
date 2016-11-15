package com.example.mockdemo.app;

import org.easymock.EasyMockSupport;
import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;

import static org.junit.Assert.assertEquals;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import org.junit.Rule;
import org.junit.Test;

import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.SendingStatus;
import com.example.mockdemo.app.Messenger;

public class EasyMockTest extends EasyMockSupport{
	
	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	
	@Mock
	private MessageService mock;
	
	@TestSubject
	private Messenger messenger = new Messenger(mock);
	
	private static final String VALID_SERVER = "inf.ug.edu.pl";
	private static final String VALID_MESSAGE = "some message";
	private static final String INVALID_SERVER = "inf.ug.edu.eu";
	private static final String INVALID_MESSAGE = "ab";
	
	@Test
	public void checkConnectionStatusForValidServer() {
		expect(mock.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS);
		replay(mock);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
	}
	
	@Test
	public void checkConnectionStatusForInvalidServer() {
		expect(mock.checkConnection(INVALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		replay(mock);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
	}

	@Test
	public void checkSendingStatusForValidServerValidMessage() throws MalformedRecipientException {
		expect(mock.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENT);
		replay(mock);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}

	@Test
	public void checkSendingStatusForValidServerInvalidMessage() throws MalformedRecipientException {
		expect(mock.send(VALID_SERVER, INVALID_MESSAGE)).andThrow(new MalformedRecipientException()).andReturn(SendingStatus.SENDING_ERROR);
		replay(mock);
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}

	@Test
	public void checkSendingStatusForInvalidServerValidMessage() throws MalformedRecipientException {
		expect(mock.send(INVALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR);
		replay(mock);
		assertEquals(1, messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE));
	}

	@Test
	public void checkSendingStatusForInvalidServerInvalidMessage() throws MalformedRecipientException {
		expect(mock.send(INVALID_SERVER, INVALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR);
		replay(mock);
		assertEquals(1, messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE));
	}

}
