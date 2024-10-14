package com.map.notification.port.in;

import com.map.notification.infrastructure.adapter.web.in.SendMailRequest;

public interface NotificationPort {
    void sendMail(SendMailRequest sendMailRequest);
}
