import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class ServiceOne implements Observer {

    private String serviceName;

    public ServiceOne(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public void update(Observable sender, Object arg) {

        if(sender instanceof Notifier) {
            System.out.println("microservice " +  serviceName + " was updated with information: "  + arg);
        }
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
