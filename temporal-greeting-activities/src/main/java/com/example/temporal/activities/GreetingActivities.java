package com.example.temporal.activities;

import io.temporal.activity.ActivityInterface;


@ActivityInterface
public interface GreetingActivities {
	String greetInSpanish(String name);
}
