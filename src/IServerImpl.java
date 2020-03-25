import java.rmi.RemoteException;
import java.util.List;

public class IServerImpl implements  IServer {

    private Storage storage = new Storage();

    @Override
    public <T> void addToStorage(T obj) throws RemoteException{
        storage.addToStorage((Ring) obj);
    }

    @Override
    public List<Ring> getList() {
        return storage.getList();
    }

}
