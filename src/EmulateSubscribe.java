import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class EmulateSubscribe extends Thread {

    private HashMap<String, ServiceOne> services;
    private NanoService sender;

    @Override
    public void run() {
        startRandomSubscrice();
    }

    public void setServices(HashMap<String, ServiceOne> services) {
        this.services = services;
    }

    public void setSender(NanoService sender) {
        this.sender = sender;
    }

    /**
     * осуществеление рандомной подписки и отписки сервисов
     */
    private void startRandomSubscrice() {

        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String randomKey = String.valueOf(ThreadLocalRandom.current().nextInt(5000));

            ServiceOne serviceOne = services.get(randomKey);

            if (sender.isRegister(serviceOne)) {
                sender.unregister(serviceOne);
                System.out.println("service " + serviceOne.getServiceName() + " has unsubscribed");
            } else {
                sender.register(serviceOne);
                System.out.println("service " + serviceOne.getServiceName() + " has subscribed");
            }
        }
    }
}
