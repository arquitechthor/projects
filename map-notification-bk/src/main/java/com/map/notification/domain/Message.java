package com.map.notification.domain;

import lombok.Builder;

@Builder
public class Message {

    private Long id;
    private String title;
    private String message;

}
