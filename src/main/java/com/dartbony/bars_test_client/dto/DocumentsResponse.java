package com.dartbony.bars_test_client.dto;

import java.util.*;

public class DocumentsResponse {
    private List<Document> documents;

    public List<Document> getDocuments() {
        if(this.documents == null)
            this.documents = Collections.emptyList();
        return this.documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
