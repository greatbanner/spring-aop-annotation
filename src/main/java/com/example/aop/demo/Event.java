package com.example.aop.demo;

import java.time.Instant;

public record Event(Instant whenItHappens, String who, String message) {

}
