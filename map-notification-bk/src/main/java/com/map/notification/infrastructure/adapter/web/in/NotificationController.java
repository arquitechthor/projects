package com.map.notification.infrastructure.adapter.web.in;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.map.notification.port.in.NotificationPort;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1")
@AllArgsConstructor
public class NotificationController {
	
	private final NotificationPort notificationPort;

    @PostMapping("/send-mail")
    public ResponseEntity sendMail(@RequestBody SendMailRequest sendMailRequest) {
        notificationPort.sendMail(sendMailRequest);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
