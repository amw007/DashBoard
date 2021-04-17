package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import service.TeaDataService;
import service.TeaDataService;

public class TeaTableController {

    @FXML
    private Button rebtn;

    @FXML
    private TableView<TeaData> tabelView;

    @FXML
    private TableColumn<TeaData, Integer> sno;

    @FXML
    private TableColumn<TeaData,String> Name;

    @FXML
    private TableColumn<TeaData, String> email;

    @FXML
    private TableColumn<TeaData,String> staffPost;

    @FXML
    private TableColumn<TeaData,String> year;

    @FXML
    private TableColumn<TeaData,String> sec;

    @FXML
    private  StackPane stackPane;
    @FXML
    void onReBtnClick(ActionEvent event) {
        service();
        teaData.addAll(tabelView.getItems());
        System.out.println(teaData.size());
    }

    public void setData(){
        tabelView.setItems(teaData);
    }
    public void service() {
        final TeaDataService service = new TeaDataService();
        Region veil = new Region();
        veil.setStyle("-fx-background-color: rgba(0,0,0,0.4)");
        veil.setPrefSize(400,400);
        ProgressIndicator p=new ProgressIndicator();
        p.setMaxSize(140,140);
        p.setStyle("-fx-background-color: rgba(255,165,0,0)");

        p.progressProperty().bind(service.progressProperty());
        veil.visibleProperty().bind(service.runningProperty());
        p.visibleProperty().bind(service.runningProperty());
        tabelView.itemsProperty().bind(service.valueProperty());
        stackPane.getChildren().addAll(veil,p);
        service.start();
    }

    public void initialize(){
        sno.setCellValueFactory(new PropertyValueFactory<>("sno"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        staffPost.setCellValueFactory(new PropertyValueFactory<>("staffPost"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        sec.setCellValueFactory(new PropertyValueFactory<>("sec"));
    }
    public static ObservableList<TeaData> teaData = FXCollections.observableArrayList();
}
