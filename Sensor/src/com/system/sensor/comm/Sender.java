package com.system.sensor.comm;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Sender {
	
	public static void send(String json) {
		try {
			URL u = new URL("http://localhost:8080/Monitor/api/listener");
			HttpURLConnection conexao = (HttpURLConnection) u.openConnection();
			conexao.setDoOutput(true);
			conexao.setRequestProperty("Content-Type", "application/json");
			conexao.setRequestMethod("POST");
			OutputStreamWriter writer = new OutputStreamWriter(conexao.getOutputStream());
			writer.write(json);
			writer.flush();
			conexao.getResponseCode();
		} catch (MalformedURLException e) {
			System.out.println("URL do Monitor incorreta");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
