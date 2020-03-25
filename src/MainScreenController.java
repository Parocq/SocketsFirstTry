import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainScreenController {

    private IServer iServer;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private TextField titleField;

    @FXML
    private TextField colorField;

    @FXML
    private TextField priceField;

    @FXML
    private TableView<Ring> table;

    @FXML
    private TableColumn<Ring, String> title;

    @FXML
    private TableColumn<Ring, String> color;

    @FXML
    private TableColumn<Ring, Double> price;

    @FXML
    void onButtonClick(ActionEvent event) throws RemoteException {
        String title = titleField.getText();
        String color = colorField.getText();
        double price = Double.parseDouble(priceField.getText());

        Ring ring = new Ring(title,color,price);
        iServer.addToStorage(ring);
        System.out.println("Added");
        setTableValues ();
    }

    @FXML
    void initialize() throws RemoteException {
        Client client = new Client();
        iServer = client.getServer();
        setTableValues();
    }

    private ObservableList<Ring> ringList;

    public ObservableList<Ring> convertArrayListToObservableListR() throws RemoteException {
        ObservableList<Ring> observableList =  FXCollections.observableArrayList();

        observableList.addAll(iServer.getList());

        return observableList;
    }

    public void setTableValues () throws RemoteException {
        table.getItems().clear();

        ringList = convertArrayListToObservableListR();
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.setItems(ringList);
    }
}
