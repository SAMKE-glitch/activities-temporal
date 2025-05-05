package com.example.temporal.activities;

import java.io.*;
import java.net.*;


public class GreetingActivites implements GreetingActivites {
	@Override
	public String greetInSpanish(String name) {
		StringBuilder builder = new StringBuilder();

		String baseUrl = "http://localhost:9999/get-spanish-greeting?name=";
		URL url = new URL(baseUrl + URLEncoder.encode(name, "UTF-8"));

		try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
			String line;
			while ((line = in.readLine()) != null) {
				builder.append(line).append("\n");
			}
		}

		return builder.toString();
	}
}
