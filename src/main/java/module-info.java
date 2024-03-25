module com.dartbony.bars_test_client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.httpcomponents.client5.httpclient5;
    requires org.apache.httpcomponents.core5.httpcore5;
    requires com.google.gson;

    opens com.dartbony.bars_test_client to javafx.fxml;
    exports com.dartbony.bars_test_client;
    exports com.dartbony.bars_test_client.integration;
    opens com.dartbony.bars_test_client.integration to javafx.fxml, com.google.gson;
    exports com.dartbony.bars_test_client.dto;
    opens com.dartbony.bars_test_client.dto to javafx.fxml, com.google.gson;
}