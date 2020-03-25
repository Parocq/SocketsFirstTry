import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Ring> list = new ArrayList<>();

    public Storage() {
    }

    public Storage(List<Ring> list) {
        this.list = list;
    }

    public List<Ring> getList() {
        return list;
    }

    public void setList(List<Ring> list) {
        this.list = list;
    }

    public <T> void addToStorage(T obj){
        list.add((Ring)obj);
    }
}
