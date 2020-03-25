import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServer extends Remote {
    <T> void addToStorage(T obj) throws RemoteException;

    List<Ring> getList() throws RemoteException ;
}

//Методы которые добавляют разные сущности
//Сортировок