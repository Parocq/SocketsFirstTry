import javax.naming.NamingException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {

    private static IServer iServer;
    private static IServerImpl iServerImpl = new IServerImpl();

    public static void main(String[] args) throws NamingException {
        System.setProperty("java.rmi.server.hostname","127.0.0.1");

        try {
            Registry registry = LocateRegistry.createRegistry(1099);//Реестр обьектов
            //Область памяти, в к от. можно закинуть обьект. Фича в том что эти файлы может получить клиент.
            iServer = (IServer) UnicastRemoteObject.exportObject(iServerImpl, 1099);
            registry.rebind("rmi://127.0.0.1::1099/jew", iServerImpl);//Записмывает обьект имени rmi
            while (true){ }
        } catch (Exception e) {
            System.out.println("Не удалось настроить сервер");
        }
    }
}
