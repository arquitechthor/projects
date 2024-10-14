package com.map.notification.application;

import com.map.notification.infrastructure.adapter.web.in.SendMailRequest;
import com.map.notification.infrastructure.annotation.UseCase;
import com.map.notification.port.in.NotificationPort;
import com.map.notification.port.out.SendMailPort;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class NotificationUseCase implements NotificationPort {
	
	private final SendMailPort sendMailPort;

	@Override
	public void sendMail(SendMailRequest sendMailRequest) {
		sendMailPort.sendMail(sendMailRequest);
	}
}
