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
import service.StdDataService;

public class StdTableController {

    @FXML
    private Button rebtn;

    @FXML
    private TableView<StdData> tabelView;

    @FXML
    private TableColumn<StdData, Integer> sno;

    @FXML
    private TableColumn<StdData,String> stdname;

    @FXML
    private TableColumn<StdData, Integer> rollno;

    @FXML
    private TableColumn<StdData,String> dept;

    @FXML
    private TableColumn<StdData,String> year;

    @FXML
    private TableColumn<StdData,String> sec;

    @FXML
    private  StackPane stackPane;
    @FXML
    void onReBtnClick(ActionEvent event) {
        service();
        stdData.addAll(tabelView.getItems());
        System.out.println(stdData.size());
    }

    public void setData(){
        tabelView.setItems(stdData);
    }
    public void service() {
        final StdDataService service = new StdDataService();
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
        sno.setCellValueFactory(new PropertyValueFactory<>("Sno"));
        stdname.setCellValueFactory(new PropertyValueFactory<>("stdName"));
        rollno.setCellValueFactory(new PropertyValueFactory<>("rollno"));
        dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        sec.setCellValueFactory(new PropertyValueFactory<>("sec"));
    }
    public static ObservableList<StdData> stdData = FXCollections.observableArrayList();
}
