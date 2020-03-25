import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import old.Server;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client extends Application {

    private static IServer iServer;
    private static IServerImpl iServerImpl = new IServerImpl();

    public Client() {
    }

    public void start(Stage myStage) throws  Exception {
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry("localhost");//получение реестра,
                                                                    // передаваемого с сервера
            iServer = (IServer) registry.lookup("rmi://127.0.0.1::1099/jew");//Получение обьекта
                                    //из реестра под заданным имени
        } catch (Exception e) { }

        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

        Scene scene = new Scene(root);
        myStage.setScene(scene);
        myStage.setTitle("Jewelry shop client-server");
        System.out.println("STARTED");
        myStage.show();
    }

    public IServer getServer(){
        return iServer;
    }
}
