package com.map.notification.infrastructure.adapter.web.out;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

import com.map.notification.infrastructure.adapter.web.in.SendMailRequest;
import com.map.notification.infrastructure.annotation.WebAdapter;
import com.map.notification.port.out.SendMailPort;

@WebAdapter
@AllArgsConstructor
public class SendMailAdapter implements SendMailPort {

    @Override
    public void sendMail(SendMailRequest sendMailRequest) {
        System.out.println("Exito");
    }
}
