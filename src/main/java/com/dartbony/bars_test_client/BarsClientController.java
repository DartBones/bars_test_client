package com.dartbony.bars_test_client;

import com.dartbony.bars_test_client.dto.Document;
import com.dartbony.bars_test_client.integration.ServerIntegration;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static com.dartbony.bars_test_client.DateUtils.*;

public class BarsClientController implements Initializable {

    @FXML
    private TableView<DocumentTableView> documentTable;

    @FXML
    private TableColumn<DocumentTableView, Integer> number;

    @FXML
    private TableColumn<DocumentTableView, LocalDateTime> date;

    @FXML
    private TableColumn<DocumentTableView, LocalDateTime> updateDate;

    @FXML
    private TableColumn<DocumentTableView, CheckBox> actual;

    private final ObservableList<DocumentTableView> documents = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initDocuments();

        this.number.setCellValueFactory(new PropertyValueFactory<>("number"));

        this.date.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.date.setCellFactory(column -> this.getDateTableCell());

        this.updateDate.setCellValueFactory(new PropertyValueFactory<>("updateDate"));
        this.updateDate.setCellFactory(column -> this.getDateTableCell());

        this.actual.setCellValueFactory(new PropertyValueFactory<>("actual"));

        this.documentTable.setItems(this.documents);
    }

    private void initDocuments() {
        var documentTableViews = ServerIntegration.getInstance().getAllDocuments().stream()
            .map(this::createDocumentTableView)
            .collect(Collectors.toList());
        this.documents.addAll(documentTableViews);
    }

    private DocumentTableView createDocumentTableView(Document document) {
        return new DocumentTableView(
            document.getNumber(),
            document.getDate(),
            document.getUpdateDate()
        );
    }

    private TableCell<DocumentTableView, LocalDateTime> getDateTableCell() {
        return new TableCell<>() {
            @Override
            protected void updateItem(LocalDateTime date, boolean empty) {
                super.updateItem(date, empty);
                var resultText = empty || date == null ? "" : DATE_TIME_FORMAT.format(date);
                setText(resultText);
            }
        };
    }
}