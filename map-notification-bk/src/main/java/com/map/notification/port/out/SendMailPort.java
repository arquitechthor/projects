package com.map.notification.port.out;

import com.map.notification.infrastructure.adapter.web.in.SendMailRequest;

public interface SendMailPort {
    void sendMail(SendMailRequest sendMailRequest);
}
