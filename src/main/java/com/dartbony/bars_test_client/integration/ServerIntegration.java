package com.dartbony.bars_test_client.integration;

import com.dartbony.bars_test_client.GsonUtils;
import com.dartbony.bars_test_client.dto.*;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.core5.http.HttpHeaders;

import java.io.IOException;
import java.util.*;

public class ServerIntegration {

    private static ServerIntegration instance;

    private final ApacheHttp apacheHttp;

    private ServerIntegration(ApacheHttp apacheHttp) {
        this.apacheHttp = apacheHttp;
    }

    public static ServerIntegration getInstance() {
        if(instance == null)
            instance = new ServerIntegration(new ApacheHttp());
        return instance;
    }

    public List<Document> getAllDocuments() {
        List<Document> result;
        var getRequest = new HttpGet("http://localhost:8091/v1/documents/all");
        getRequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        getRequest.setHeader(HttpHeaders.ACCEPT, "application/json");
        try {
            var response = this.apacheHttp.sendGetRequest(getRequest);
            result = GsonUtils.fromJson(response, DocumentsResponse.class)
                    .map(DocumentsResponse::getDocuments)
                    .orElse(Collections.emptyList());
        } catch (IOException e) {
            result = Collections.emptyList();
        }
        return result;
    }
}