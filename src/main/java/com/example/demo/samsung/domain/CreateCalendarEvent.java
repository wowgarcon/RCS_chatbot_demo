package com.example.demo.samsung.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCalendarEvent {
    private String title;
    private String startTime;
    private String endTime;
    private String description;
}
