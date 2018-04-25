import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class NanoService extends Observable implements Notifier {

    private List<Observer> clients = new ArrayList<>();

    public void informClients (String newNews) {

        for(Observer service: this.clients) {
            service.update(this, newNews);
        }
    }

    public void register(Observer service) {
        clients.add(service);
    }

    public void unregister(Observer service) {
        clients.remove(service);
    }

    public Boolean isRegister(Observer service) {
        return clients.contains(service);
    }

    /** получить информацию с удаленного источника */
    public String getInfoFromRes() {
        return "Все очень плохо";
    }
}
