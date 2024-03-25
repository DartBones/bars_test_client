package com.dartbony.bars_test_client.integration;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ApacheHttp {
    public String sendGetRequest(HttpGet request) throws IOException {
        try(var client = this.createClient()) {
            return client.execute(
                request,
                response -> {
                    StringBuilder res = new StringBuilder();
                    if(response.getCode() == 200) {
                        var responseEntity = response.getEntity();
                        if(responseEntity != null) {
                            try(
                                var streamReader = new InputStreamReader(responseEntity.getContent(), StandardCharsets.UTF_8);
                                var bufferedReader = new BufferedReader(streamReader);
                            ) {
                                String line;
                                while((line = bufferedReader.readLine()) != null)
                                    res.append(line);
                            }
                        }
                    }
                    return res.toString();
                }
            );
        }
    }

    private CloseableHttpClient createClient() {
        return HttpClientBuilder.create().disableRedirectHandling().build();
    }
}