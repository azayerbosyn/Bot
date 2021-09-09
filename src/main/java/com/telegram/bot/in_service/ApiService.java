package com.telegram.bot.in_service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Component;

@Component
public class ApiService {

  public Double getRateByCode(String code) throws IOException {

    StringBuilder url_str = new StringBuilder("https://v6.exchangerate-api.com/v6/02879ddc7a968d571c1ed32f/pair/")
    .append(code)
    .append("/KZT");

    URL url = new URL(url_str.toString());
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
    request.connect();

    JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
    JsonObject jsonobj = root.getAsJsonObject();

    Double req_result = jsonobj.get("conversion_rate").getAsDouble();
    return req_result;
  }

}
